package com.mybatis.model.service;

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
  Student2 selectOne(int no);
}
