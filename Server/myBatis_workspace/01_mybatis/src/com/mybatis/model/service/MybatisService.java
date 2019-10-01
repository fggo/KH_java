package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import com.mybatis.model.vo.Student;
import com.mybatis.model.vo.Student2;

public interface MybatisService {
  int insertStudent();
  int insertStudent2(int no);
  int insertName(String name);
  int insertStudentAll(Student s);
  int insertStudentAll(Map<String, String> s);
  int selectCount();
//  Student selectOne(int no);
//  Student2 selectOne(int no);
  
  Map selectOne(int no); //vo객체 없이 select
  
  //리스트 조회하기
  List<Student> selectListStudent();
  List<Student2> selectListStudent2();
  List<Map> selectListMap();

  //list조회시 조건 달기
  List<Map> selectSearchName(String name);

  //여러개의 parameter 조회
  List<Map> selectSearchMulti(Map<String, String> params);

  int updateStudent(Map<String, Object> param);

  int deleteStudent(int no);
}
