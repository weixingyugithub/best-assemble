package com.beijing.wei.hua.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beijing.wei.hua.service.HuaService;
import com.beijing.wei.login.mapper.ProjectUserMapper;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.login.model.ProjectUserExample;
import com.beijing.wei.util.file.generatorMybatis.Page;

@Service
public class HuaServiceImp implements HuaService{

	@Autowired
	private ProjectUserMapper ProjectUserMapper;
	
	public List<ProjectUser> getList(){
		ProjectUserExample ProjectUserExample = new ProjectUserExample();
    	ProjectUserExample.Criteria criteria = ProjectUserExample.createCriteria();
    	Page page = new Page(0, 10);
//		if (rid != null){
//			criteria.andUsersIdEqualTo(rid);//.andRidEqualTo(rid);
//		}
		if (page != null){
			int count = ProjectUserMapper.countByExample(ProjectUserExample);
			page.setPageCount(count);
			ProjectUserExample.setPage(page);
		}
		List<ProjectUser> list = ProjectUserMapper.selectByExample(ProjectUserExample);
		return list;
	}
}
