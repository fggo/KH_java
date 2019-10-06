package com.kh.prac.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

  @Override
  public int insertEmp(SqlSession session, Map<String, Object> param) {
    return session.insert("emp.insertEmp", param);
  }

  @Override
  public List<Map> searchEmp(SqlSession session, Map<String, Object> param) {
    return session.selectList("emp.selectMap", param);
  }
  
}
