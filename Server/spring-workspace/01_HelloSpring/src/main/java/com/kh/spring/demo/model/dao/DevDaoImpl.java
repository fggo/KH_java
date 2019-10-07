package com.kh.spring.demo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

@Repository
public class DevDaoImpl implements DevDao {

  @Override
  public int insertDev(SqlSessionTemplate sqlSession, Dev dev) {
    return sqlSession.insert("dev.insertDev", dev);
  }

}
