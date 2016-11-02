package com.beijing.wei.login.mapper;

import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.login.model.ProjectUserExample;
import com.beijing.wei.util.file.generatorMybatis.MyBatisRepository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface ProjectUserMapper {
    int countByExample(ProjectUserExample example);

    int deleteByExample(ProjectUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(ProjectUser record);

    int insertSelective(ProjectUser record);

    List<ProjectUser> selectByExample(ProjectUserExample example);

    ProjectUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") ProjectUser record, @Param("example") ProjectUserExample example);

    int updateByExample(@Param("record") ProjectUser record, @Param("example") ProjectUserExample example);

    int updateByPrimaryKeySelective(ProjectUser record);

    int updateByPrimaryKey(ProjectUser record);
    
    ProjectUser findByUser(String usersName);
}