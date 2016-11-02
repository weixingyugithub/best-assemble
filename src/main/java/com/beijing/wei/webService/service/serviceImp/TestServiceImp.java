package com.beijing.wei.webService.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.beijing.wei.webService.service.TestService;

@WebService(endpointInterface = "com.beijing.wei.webService.service.TestService")
public class TestServiceImp implements TestService{
	public List<String> greeting(String userName) {
		System.out.println(userName);
		List<String> list = new ArrayList<String>();
		list.add(userName);
		list.add("asdf");
		return list;
	}
	
}
