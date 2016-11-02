package com.beijing.wei.huiying.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.hua.service.HuaService;
import com.beijing.wei.login.model.ProjectUser;

@Controller
@RequestMapping(value = "/hua")
public class HuaController {
	
	@Autowired
	private HuaService huaService;
	
	@RequestMapping(value = "/hua", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String huiying(){
		List<ProjectUser> list = huaService.getList();
		return "hua/hua";
	}
}
