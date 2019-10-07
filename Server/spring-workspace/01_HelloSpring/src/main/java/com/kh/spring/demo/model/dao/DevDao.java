package com.kh.spring.demo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

public interface DevDao {
  int insertDev(SqlSessionTemplate sqlSession, Dev dev);
}
