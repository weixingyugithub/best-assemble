package com.beijing.wei.user.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beijing.wei.login.mapper.ProjectUserMapper;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.login.model.ProjectUserExample;
import com.beijing.wei.user.service.UserService;
import com.beijing.wei.util.file.generatorMybatis.Page;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private ProjectUserMapper projectUserMapper;
	
	public Page findListByPage(Page page){
		ProjectUserExample projectUserExample = new ProjectUserExample();
    	ProjectUserExample.Criteria criteria = projectUserExample.createCriteria();
    	if(0 == page.getPageNo()){
    		page = new Page(0, 10);
    	}
//		if (rid != null){
//			criteria.andUsersIdEqualTo(rid);//.andRidEqualTo(rid);
//		}
		criteria.andUserIdIsNotNull();//.andRidEqualTo(rid);
		if (page != null){
			int count = projectUserMapper.countByExample(projectUserExample);
			page.setTotalRecords(count);
			projectUserExample.setPage(page);
			projectUserExample.setOrderByClause("cast(user_id as signed)");
		}
		List<ProjectUser> list = projectUserMapper.selectByExample(projectUserExample);
		page.setList(list);
		return page;
	}

	public void save(ProjectUser users) {
		projectUserMapper.insert(users);
	}

	public void delete(String id) {
		projectUserMapper.deleteByPrimaryKey(id);
	}
	
	public void delete(){
		ProjectUserExample projectUserExample = new ProjectUserExample();
		ProjectUserExample.Criteria criteria = projectUserExample.createCriteria();
		criteria.andUserAllIdIsNull();
		projectUserMapper.deleteByExample(projectUserExample);
	}

	public void update(ProjectUser users) {
		projectUserMapper.updateByPrimaryKeySelective(users);
	}
}
