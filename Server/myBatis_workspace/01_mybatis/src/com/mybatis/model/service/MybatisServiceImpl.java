package com.mybatis.model.service;

import static common.SqlSessionTemplate.getSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.dao.MybatisDaoImpl;
import com.mybatis.model.vo.Student;
import com.mybatis.model.vo.Student2;

public class MybatisServiceImpl implements MybatisService {
  private MybatisDao dao = new MybatisDaoImpl();

  @Override
  public int insertStudent() {
    SqlSession session = getSession();
    int result = dao.insertStudent(session);

    if(result >0) session.commit();
    else session.rollback();
    
    session.close();

    return result;
  }

  @Override
  public int insertStudent2(int no) {
    SqlSession session = getSession();
    int result = dao.insertStudent2(session, no);

    if(result >0) session.commit();
    else session.rollback();
    
    session.close();

    return result;
  }

  @Override
  public int insertName(String name) {
    SqlSession session = getSession();
    int result = dao.insertName(session, name);

    if(result >0) session.commit();
    else session.rollback();
    
    session.close();

    return result;
  }

  @Override
  public int insertStudentAll(Student s) {
    SqlSession session = getSession();
    int result = dao.insertStudentAll(session, s);
    
    if(result > 0) session.commit();
    else session.rollback();
    
    session.close();

    return result;
  }

  @Override
  public int insertStudentAll(Map<String, String> s) {
    SqlSession session = getSession();
    int result = dao.insertStudentAll(session, s);
    
    if(result > 0) session.commit();
    else session.rollback();
    
    session.close();

    return result;
  }

  @Override
  public int selectCount() {
    SqlSession session = getSession();
    int result = dao.selectCount(session);

    session.close();

    return result;
  }

//  @Override
//  public Student selectOne(int no) {
//    SqlSession session = getSession();
//    Student s = dao.selectOne(session, no);
//
//    session.close();
//
//    return s;
//  }

  @Override
  public Student2 selectOne(int no) {
    SqlSession session = getSession();
    Student2 s = dao.selectOne(session, no);

    session.close();

    return s;
  }
}
