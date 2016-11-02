package com.beijing.wei.homepage.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.base.BaseController;

@Controller
@RequestMapping(value = "/homepage")
public class HomePageController extends BaseController{
	@RequestMapping(value = "/help", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String login() throws FileNotFoundException, IOException {

		return "homepage/help";
	}
}
