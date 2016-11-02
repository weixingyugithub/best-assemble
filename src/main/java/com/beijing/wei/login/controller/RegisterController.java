package com.beijing.wei.login.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.base.BaseController;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.user.service.UserService;

/**
 * <p>
 * 	注册帐号controller
 * </p>
 * @author com.beijing.wei@live.com
 * @date   2016-01-07
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void save(PrintWriter print, ProjectUser users) {
		userService.save(users);
	}
}
