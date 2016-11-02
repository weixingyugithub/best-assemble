package com.beijing.wei.base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.beijing.wei.util.common.CommonVariable;
/**
 * 上传类
 * @author com.beijing.wei@live.com
 *
 */
public abstract class UploadController extends DownController{

	/**
	 * 单个文件上传
	 * 
	 * @param is
	 * @param fileName
	 * @param filePath
	 */
	public void upFile(File uploadFile, String filePath, String fileName) {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		FileInputStream is = null;
		BufferedInputStream bis = null;
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File f = new File(filePath + CommonVariable.FILE_SEPARATOR + fileName);
		try {
			is = new FileInputStream(uploadFile);
			bis = new BufferedInputStream(is);
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			byte[] bt = new byte[4096];
			while ((bis.read(bt)) > 0) {
				bos.write(bt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != bos) {
					bos.close();
					bos = null;
				}
				if (null != fos) {
					fos.close();
					fos = null;
				}
				if (null != is) {
					is.close();
					is = null;
				}

				if (null != bis) {
					bis.close();
					bis = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * <p>
	 * 实现多文件上传
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param downloadFile
	 * @author com.beijing.wei@live.com
	 * @date 2015-04-30
	 */
	public void uploadFile(HttpServletRequest request,
			HttpServletResponse response, String downloadFile) {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = "demoUpload"
								+ file.getOriginalFilename();
						// 定义上传路径
						String path = downloadFile
								+ CommonVariable.FILE_SEPARATOR + fileName;
						File localFile = new File(path);
						try {
							file.transferTo(localFile);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}

		}
	}
}
