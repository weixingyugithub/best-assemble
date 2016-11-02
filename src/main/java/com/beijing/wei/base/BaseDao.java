package com.beijing.wei.base;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao extends SqlSessionDaoSupport {
	private SqlSessionFactory sessionFactory;

	@Resource
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		super.setSqlSessionFactory(sessionFactory);
	}
}
