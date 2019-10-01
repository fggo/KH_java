package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;
import com.mybatis.model.vo.Student2;

public class MybatisDaoImpl implements MybatisDao {

  @Override
  public int insertStudent(SqlSession session) {
    int result = session.insert("student.insertStudent");
    //mapper
    //mappernamespace.sql  id
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
  
//    @Override
//  public Student2 selectOne(SqlSession session, int no) {
//    return session.selectOne("student.selectOne", no);
//  }
  
  @Override
  public Map selectOne(SqlSession session, int no) {
    return session.selectOne("student.selectOneMap", no);
  }

  @Override
  public List<Student> selectListStudent(SqlSession session) {
//    selectList 자동으로 List<Student> 인식함
    return session.selectList("student.selectListStudent");
  }

  @Override
  public List<Student2> selectListStudent2(SqlSession session) {
    return session.selectList("student.selectListStudent2");
  }

  @Override
  public List<Map> selectListMap(SqlSession session) {
    return session.selectList("student.selectListMap");
  }

  @Override
  public List<Map> selectSearchName(SqlSession session, String name) {
    return session.selectList("student.selectSearchName", name);
  }

  @Override
  public List<Map> selectSearchMulti(SqlSession session, Map<String, String> params) {
    return session.selectList("student.selectSearchMulti", params);
  }

  @Override
  public int updateStudent(SqlSession session, Map<String, Object> param) {
    return session.update("student.updateStudent", param);
  }

  @Override
  public int deleteStudent(SqlSession session, int no) {
    return session.delete("student.deleteStudent", no);
  }
  
}
