package com.beijing.wei.mail.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.base.BaseController;
import com.beijing.wei.mail.service.MailService;
import com.beijing.wei.util.file.SysLogs;
import com.beijing.wei.util.string.UUIDStringUtil;

@Controller
@RequestMapping(value = "/mail")
public class MailController extends BaseController {
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/send", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void send(PrintWriter out, String mailName,HttpSession session) throws Exception,
			UnsupportedEncodingException, MessagingException {
		String activateCode = UUIDStringUtil.getRemodeSixString();
		session.setAttribute(mailName, activateCode);
		try {
			mailService.send(mailName, "邮箱激活", "您的激活码为:" + activateCode,MailEnum.TEXT);
		} catch (Exception e) {
			SysLogs.print("WARN", e);
		}
		out.write("123");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/receive", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void receive(PrintWriter out,HttpSession session) throws Exception,
			UnsupportedEncodingException, MessagingException {
		String activateCode = UUIDStringUtil.getRemodeSixString();
		try {
			activateCode = mailService.receive();
		} catch (Exception e) {
			SysLogs.print("WARN", e);
		}
		out.write(activateCode);
		out.flush();
		out.close();
	}
}
