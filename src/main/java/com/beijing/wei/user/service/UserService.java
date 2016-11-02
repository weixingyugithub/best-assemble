package com.beijing.wei.user.service;

import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.util.file.generatorMybatis.Page;

/**
 * <p>
 * 	users操作接口	
 * </p>
 * @author com.beijing.wei@live.com
 *
 */

public interface UserService {
	
	/**
	 * <p>
	 * 	根据page对像查询分页数据
	 * </p>
	 * @param page 查询分页
	 * @return
	 */
	public Page findListByPage(Page page);
	
	/**
	 * <p>
	 * 	新增保存一个对像
	 * </p>
	 * @param users users对像
	 */
	public void save(ProjectUser users);
	
	/**
	 * <p>
	 * 	根据id删除对像
	 * </p>
	 * @param id usersId
	 */
	public void delete(String id);
	
	/**
	 * <p>
	 * 	修改users对像
	 * </p>
	 * @param users 修改后的对像保存修改
	 */
	public void update(ProjectUser users);
}
