package com.beijing.wei.login.mapper;

import com.beijing.wei.login.model.ProjectUserAll;
import com.beijing.wei.login.model.ProjectUserAllExample;
import com.beijing.wei.util.file.generatorMybatis.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface ProjectUserAllMapper {
    int countByExample(ProjectUserAllExample example);

    int deleteByExample(ProjectUserAllExample example);

    int deleteByPrimaryKey(String userAllId);

    int insert(ProjectUserAll record);

    int insertSelective(ProjectUserAll record);

    List<ProjectUserAll> selectByExample(ProjectUserAllExample example);

    ProjectUserAll selectByPrimaryKey(String userAllId);

    int updateByExampleSelective(@Param("record") ProjectUserAll record, @Param("example") ProjectUserAllExample example);

    int updateByExample(@Param("record") ProjectUserAll record, @Param("example") ProjectUserAllExample example);

    int updateByPrimaryKeySelective(ProjectUserAll record);

    int updateByPrimaryKey(ProjectUserAll record);
}