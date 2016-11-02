package com.beijing.wei.util.file.generatorMybatis;

import java.util.List;

import com.beijing.wei.login.mapper.ProjectUserMapper;
import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.login.model.ProjectUserExample;

public class Test {  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	
    }  
    private ProjectUserMapper projectUsersMapper;
    	
    public List<ProjectUser> queryBattleLogInfo(Page page) {
		
    	ProjectUserExample projectUsersExample = new ProjectUserExample();
    	ProjectUserExample.Criteria criteria = projectUsersExample.createCriteria();
//		if (rid != null){
//			criteria.andUsersIdEqualTo(rid);//.andRidEqualTo(rid);
//		}
		if (page != null){
			int count = projectUsersMapper.countByExample(projectUsersExample);
			page.setPageCount(count);
//			projectUsersExample.setLimitStart(page.getBegin()); // 分页的第一个参数，从第几条数据开始（0为第一条）
//			projectUsersExample.setLimitEnd(page.getEnd());    // 每页的条数，取多少数据
			projectUsersExample.setPage(page);
		}
		return projectUsersMapper.selectByExample(projectUsersExample);
	}

}  