package com.beijing.wei.xsd.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beijing.wei.base.BaseController;

@Controller
@RequestMapping(value = "/schema")
public class XsdController extends BaseController {
	
	public static String getRealPath(HttpServletRequest request) {
		// 磁盘路径
		@SuppressWarnings("unchecked")
		Map<String, String> contextConfigure = Map.class.cast(request
				.getSession().getServletContext()
				.getAttribute("contextConfigure"));
		String realPath = contextConfigure.get("realPath");
		return realPath;
	}

	@RequestMapping(value = "/user.xsd", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void user(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String classPath = XsdController.class.getResource("/").getPath();
		String path = classPath.replace("%20", " ") + "/com/beijing/wei/custom/bean/user.xsd";
		File file = new File(path);
		this.outXml(response, FileUtil.readAsString(file));
	}
}
