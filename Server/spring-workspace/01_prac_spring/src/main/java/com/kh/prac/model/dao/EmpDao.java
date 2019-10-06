package com.kh.prac.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {
  int insertEmp(SqlSession session, Map<String, Object> param);
  List<Map> searchEmp(SqlSession session, Map<String, Object> param);
}
