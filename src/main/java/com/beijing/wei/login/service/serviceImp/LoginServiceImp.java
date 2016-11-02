package com.beijing.wei.login.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beijing.wei.login.mapper.ProjectUserMapper;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.login.service.LoginService;

@Service
public class LoginServiceImp implements LoginService {
	@Autowired
	private ProjectUserMapper projectUserMapper;
	
	public String findByUsers(ProjectUser projectUser) {
		String flogStatus = "0";
		ProjectUser p = projectUserMapper.findByUser(projectUser.getUserName());
		if(null != p){
			if(!p.getUserPass().equals(projectUser.getUserPass())){
				flogStatus = "1";
			}else if(p.getUserPass().equals(projectUser.getUserPass())){
				flogStatus = "2";
			}
		}
		return flogStatus;
	}
}
