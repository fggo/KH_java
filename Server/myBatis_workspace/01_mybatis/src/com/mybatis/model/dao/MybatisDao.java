package com.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;
import com.mybatis.model.vo.Student2;

public interface MybatisDao {
  int insertStudent(SqlSession session);
  int insertStudent2(SqlSession session, int no);
  int insertName(SqlSession session, String name);
  int insertStudentAll(SqlSession session, Student s);
  int insertStudentAll(SqlSession session, Map<String, String> s);
  int selectCount(SqlSession session);
//  Student selectOne(SqlSession session, int no);
  Student2 selectOne(SqlSession session, int no);
}
