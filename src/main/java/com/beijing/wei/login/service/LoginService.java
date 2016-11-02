package com.beijing.wei.login.service;

import com.beijing.wei.login.model.ProjectUser;

public interface LoginService {

	/**
	 * <p>返回账号、密码、或者验证码错误<p>
	 * 0为账号错误、1为密码错误、2为验证码错误、3为正确
	 * @param projectUsers
	 * @return
	 */
	public String findByUsers(ProjectUser projectUsers);
}
