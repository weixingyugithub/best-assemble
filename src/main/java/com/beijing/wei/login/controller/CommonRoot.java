package com.beijing.wei.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.beijing.wei.base.BaseController;
import com.beijing.wei.util.common.CommonVariable;
import com.beijing.wei.util.db.ReadProperties;
import com.beijing.wei.util.file.SysLogs;

@Controller
public class CommonRoot extends BaseController {

	@RequestMapping(value = "/", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String index() {
		//getRequest().setAttribute("testNum", "asdfasdfasdf");
		SysLogs.print("INFO", "asggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggdf");
		return "index";
	}

	@RequestMapping(value = "/hello", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String hello(HttpServletRequest request) {
		System.out.println("test");
		return "hello";
	}
	
	@RequestMapping(value = "/rest/{date}", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void rest(@PathVariable String date,HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println(ReadProperties.getWxyValue("wxy.code"));
		String s = request.getParameter("tt");
		this.outJson(response, s);
	}
	
	@RequestMapping(value = "/json/map", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String,String> rest(HttpServletRequest request,HttpServletResponse response) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "1");
		return map;
	}
	
	/**
	 * <p>
	 * 	下载文件	
	 * </p>
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/download", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void download(HttpServletRequest request,HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("/") + "upload"+CommonVariable.FILE_SEPARATOR+"aaa.txt";
		this.downloadFile(response, path, "魏星玉.txt");
	}
	
	/**
	 * <p>
	 * 	上传文件	
	 * </p>
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */

	@RequestMapping(value = "/upload/test")
	public void upload(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "upload"+CommonVariable.FILE_SEPARATOR;
		this.uploadFile(request, response, path);
	}
	
	@RequestMapping(value = "/error/404", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String error404() {
		
		return "error/404";
	}
	
	@RequestMapping(value = "/error/500", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String error500() {
		
		return "error/500";
	}
	
	@RequestMapping(value = "/common/dingwei", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String dingwei() {
		
		return "common/dingwei";
	}
}
