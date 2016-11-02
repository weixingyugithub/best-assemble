package com.beijing.wei.login.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.base.BaseController;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.login.service.LoginService;
import com.beijing.wei.util.common.CommonSession;
import com.beijing.wei.util.db.ReadProperties;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String login() throws FileNotFoundException, IOException {
		// ProjectUsers pu = new ProjectUsers();
		// pu.setUsersName("aa");
		// pu.setUsersPass("aa");
		// System.out.println(loginService.findByUsers(pu));
		// String name = ReadProperties.getValueFromProperties("wxy.name");
		// System.out.println(name + "-----");
		return "login/login";
	}

	@RequestMapping(value = "/validate", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void validate(ProjectUser user, HttpSession session,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String flogStatus = loginService.findByUsers(user);
		if (null != user && flogStatus.equals("2")) {
			boolean flag = false;
			if (Boolean.valueOf(ReadProperties.getWxyValue("wxy.validate"))) {
				String validateLoginSession = session.getAttribute(
						CommonSession.VALIDATE_LOGIN_SESSION).toString();
				if (null != validateLoginSession
						&& !"".equals(user.getValidate())
						&& user.getValidate().equals(validateLoginSession)) {
					flag = true;
				}
			} else {
				flag = true;
			}
			if (flag) {
				flogStatus = "3";
				session.setAttribute(CommonSession.PROJECT_USER_SESSION, user);
			}
		}
		// 当为ajax验证登录时使用
		// this.outString(response, flogStatus);
		if (flogStatus.equals("3")) {
			Object loginUrl = session
					.getAttribute(CommonSession.LOGIN_URL_SUCCESS_SESSION);
			if (null != loginUrl && !"".equals(loginUrl)) {
				// 转发到访问页面
				response.sendRedirect(loginUrl.toString());
			} else {
				response.sendRedirect(request.getContextPath());
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/login");
		}

	}

}
