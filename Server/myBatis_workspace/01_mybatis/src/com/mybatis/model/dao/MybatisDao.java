package com.mybatis.model.dao;

import java.util.List;
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
//  Student2 selectOne(SqlSession session, int no);
  
  public Map selectOne(SqlSession session, int no);

  List<Student> selectListStudent(SqlSession session);

  List<Student2> selectListStudent2(SqlSession session);
  
  List<Map> selectListMap(SqlSession session);

  List<Map> selectSearchName(SqlSession session, String name);

  List<Map> selectSearchMulti(SqlSession session, Map<String, String> params);
  
  int updateStudent(SqlSession session, Map<String, Object> param);

  int deleteStudent(SqlSession session, int no);
}
