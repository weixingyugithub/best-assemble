package com.beijing.wei.webService.service;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface TestService {
	public List<String> greeting(String userName);
}
