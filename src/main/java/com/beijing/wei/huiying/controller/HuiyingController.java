package com.beijing.wei.huiying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/huiying")
public class HuiyingController {
	
	@RequestMapping(value = "/huiying", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String huiying(){
		return "huiying/huiying";
	}
}
