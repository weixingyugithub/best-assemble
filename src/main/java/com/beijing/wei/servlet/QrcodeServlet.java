package com.beijing.wei.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beijing.wei.util.file.SysLogs;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码生成通用servlet
 * 
 * @author com.beijing.wei@live.com
 * @version 版本号：100-000-000<br/>
 *          创建日期：2016-03-15<br/>
 *          历史修订：<br/>
 */
@WebServlet(urlPatterns = "/qrcode")
public class QrcodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 黑色颜色值
	 */
	private static final int BLACK = 0xff000000;

	/**
	 * 白色颜色值
	 */
	private static final int WHITE = 0xFFFFFFFF;

	/**
	 * 二维码生成过程
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param response
	 *            HttpServletResponse 对象
	 * @throws ServletException
	 *             Servlet异常处理
	 * @throws IOException
	 *             IO异常处理
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String contents = request.getParameter("contents");
		int width = null != request.getParameter("width") ? Integer
				.parseInt(request.getParameter("width")) : 100;
		int height = null != request.getParameter("height") ? Integer
				.parseInt(request.getParameter("height")) : 100;

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.QR_CODE, width, height);
			// 在内存中创建图象
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) == true ? BLACK
							: WHITE);
				}
			}
			ServletOutputStream responseOutputStream = response
					.getOutputStream();
			// 输出图象到页面
			ImageIO.write(image, "png", responseOutputStream);
			SysLogs.printInfo("生成验证码成功,内容为："+contents);
			// 以下关闭输入流！
			responseOutputStream.flush();
			responseOutputStream.close();
		} catch (WriterException e) {
			SysLogs.printError("生成验证码失败",e);
		} catch (Exception e) {
			SysLogs.printError("生成验证码失败",e);
		} 

	}

	/**
	 * 处理post请求二维码
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param response
	 *            HttpServletResponse 对象
	 * @throws ServletException
	 *             Servlet异常处理
	 * @throws IOException
	 *             IO异常处理
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * 处理get请求二维码
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param response
	 *            HttpServletResponse 对象
	 * @throws ServletException
	 *             Servlet异常处理
	 * @throws IOException
	 *             IO异常处理
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
