package com.beijing.wei.webService.service.serviceImp;

import javax.jws.WebService;

import com.beijing.wei.webService.service.GreetingService;

@WebService(endpointInterface = "com.beijing.wei.webService.service.GreetingService")
public class GreetingServiceImpl implements GreetingService {
	public String greeting(String userName) {
		System.out.println(userName);
		return userName+"--";
	}
}
