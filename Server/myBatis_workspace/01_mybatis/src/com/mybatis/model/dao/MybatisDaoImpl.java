package com.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;
import com.mybatis.model.vo.Student2;

public class MybatisDaoImpl implements MybatisDao {

  @Override
  public int insertStudent(SqlSession session) {
    int result = session.insert("student.insertStudent");
    //mapper를 고르는 형식
    //mappernamespace.sql태그 id값
    return result;
  }

  @Override
  public int insertStudent2(SqlSession session, int no) {
    return session.insert("student.insertStudent2", no);
  }

  @Override
  public int insertName(SqlSession session, String name) {
    return session.insert("student.insertName", name);
  }

  @Override
  public int insertStudentAll(SqlSession session, Student s) {
    return session.insert("student.insertStudentAll", s);
  }

  @Override
  public int insertStudentAll(SqlSession session, Map<String, String> s) {
    return session.insert("student.insertStudentMap", s);
  }

  @Override
  public int selectCount(SqlSession session) {
    return session.selectOne("student.selectCount");
  }

//  @Override
//  public Student selectOne(SqlSession session, int no) {
//    return session.selectOne("student.selectOne", no);
//  }
  
    @Override
  public Student2 selectOne(SqlSession session, int no) {
    return session.selectOne("student.selectOne", no);
  }
}
