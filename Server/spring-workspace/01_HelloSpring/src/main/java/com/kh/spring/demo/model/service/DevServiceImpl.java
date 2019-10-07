package com.kh.spring.demo.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DevDao;
import com.kh.spring.demo.model.vo.Dev;

@Service
public class DevServiceImpl implements DevService {

  @Autowired
  DevDao dao;

  @Autowired
  SqlSessionTemplate sqlSession;

  @Override
  public int insertDev(Dev dev) {
    return dao.insertDev(sqlSession, dev);
  }

}
