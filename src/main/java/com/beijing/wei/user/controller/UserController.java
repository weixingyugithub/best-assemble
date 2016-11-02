package com.beijing.wei.user.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beijing.wei.base.BaseController;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.user.service.UserService;
import com.beijing.wei.util.file.generatorMybatis.Page;
import com.beijing.wei.util.string.UUIDStringUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userList", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView usersList(Page page) throws FileNotFoundException,
			IOException {
		page = userService.findListByPage(page);
		ModelAndView mav = new ModelAndView();
		mav.addObject("page", page);
		mav.setViewName("user/userList");
		return mav;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void save(PrintWriter print, ProjectUser users) {
		users.setUserId(UUIDStringUtil.getUUID());
		userService.save(users);
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void delete(PrintWriter print, String ids) {
		if (null != ids) {
			String[] idsArray = ids.split(",");
			for (int i = 0; i < idsArray.length; i++) {
				userService.delete(idsArray[i]);
			}
		}
	}

	@RequestMapping(value = "/register", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String register(PrintWriter print, String ids) {
		return "user/register";
	}

}
