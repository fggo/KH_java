package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {
  List<Map> selectSearch1(SqlSession session, Map<String,String> param);

}
