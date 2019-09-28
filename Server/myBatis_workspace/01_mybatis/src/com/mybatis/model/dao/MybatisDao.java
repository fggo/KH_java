package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public class MybatisDao {
  public int insertStudent(SqlSession session) {
//    <mapper namespace="student">
//    <insert id="insertStudent">
    int result = session.insert("student.insertStudent");

    return result;
  }

  public int insertStudent2(SqlSession session, int no) {
    int result = session.insert("student.insertStudent2", no);

    return result;
  }
}
