package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

  @Override
  public List<Map> selectSearch1(SqlSession session, Map<String, String> param) {
    //여기서 case문 쓸필요 없이 mapper.xml에서 <if> <when> 등으로 조건문 씀
    return session.selectList("emp.selectSearch1", param);
  }
}
