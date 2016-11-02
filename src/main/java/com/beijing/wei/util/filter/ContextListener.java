package com.beijing.wei.util.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.beijing.wei.mail.service.MailService;

public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("---------------contextInitialized--------");
		ServletContext sct = sce.getServletContext();
		String realPath = sct.getRealPath("/");
		realPath = realPath.endsWith("/") || realPath.endsWith("\\") ? realPath : realPath + System.getProperty("file.separator");
		System.out.println(realPath);
		Map<String, String> contextConfigure = new HashMap<String, String>();
		contextConfigure.put("realPath", realPath);
		//应用启动时获取bean
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sct);
		MailService mailService = (MailService) context.getBean("mailService");//mail操作service获取
		
		/*XmlWebApplicationContext xmlWeb = new XmlWebApplicationContext();
		
		ClassPathXmlApplicationContext cXmlWeb = new ClassPathXmlApplicationContext("spring-mvc-test.xml");
		CommonsMultipartResolver shm = (CommonsMultipartResolver) cXmlWeb.getBean("multipartResolver");*/
		
		sct.setAttribute("contextConfigure", contextConfigure);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("--------------contextDestroyed---------");
	}
	
}
