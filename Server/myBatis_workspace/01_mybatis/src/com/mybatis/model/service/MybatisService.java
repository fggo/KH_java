package com.mybatis.model.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;

import common.SqlSessionTemplate;

public class MybatisService {
	private MybatisDao dao = new MybatisDao();
//	JDBC Connection 대신 Mybatis에서는 sqlsession
	public int insertStudent() {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = dao.insertStudent(session);
		if(result > 0) session.commit();
		else session.rollback();
		session.close();

		return result;
	}

	public int insertStudent2(int no) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = dao.insertStudent2(session, no);
		if(result > 0) session.commit();
		else session.rollback();

		session.close();

		return result;
	}
}
