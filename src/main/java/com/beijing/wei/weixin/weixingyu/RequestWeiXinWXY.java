package com.beijing.wei.weixin.weixingyu;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.base.BaseController;
import com.beijing.wei.util.file.SysLogs;
import com.beijing.wei.weixin.service.WXYweixinService;

@Controller
@RequestMapping(value = "/wxyweixin")
public class RequestWeiXinWXY extends BaseController {
	@Autowired
	private WXYweixinService wxyweixinService;
	
	
	/**
	 * 校验信息是否是从微信服务器发过来的。
	 * 
	 * @param weChat
	 * @param out
	 */
	@RequestMapping(method = { RequestMethod.GET })
	public void valid(WeChat weChat, PrintWriter out) {
		String signature = weChat.getSignature(); // 微信加密签名
		String timestamp = weChat.getTimestamp(); // 时间戳
		String nonce = weChat.getNonce();// 随机数
		String echostr = weChat.getEchostr();// 随机字符串

		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (ValidateUtil.validate(ValidateUtil.WXY_TOKEN, weChat)) {
			out.print(echostr);
		} else {
			System.out.println("不是微信服务器发来的请求,请小心!");
		}
		out.flush();
		out.close();
	}
	
	
	/**
	 * 微信消息的处理
	 * 
	 * @param request
	 * @param out
	 * @throws Throwable 
	 */
	@RequestMapping(method = { RequestMethod.POST })
	public void dispose(HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		/* 消息的接收、处理、响应 */

		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = ValidateUtil.automatismRestoreEntity(ValidateUtil.automatismRestoreDocument(ValidateUtil.getStringPostWeixin(request)));
		SysLogs.print("INFO", "***************************$$$*** "+respMessage);
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.flush();
		out.close();
	}
}
