package com.kh.spring.demo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DevDao;
import com.kh.spring.demo.model.vo.Dev;

@Service
public class DevServiceImpl implements DevService {

//  controller service만 bean으로 등록해줌
  @Autowired
  DevDao dao;

  @Autowired
  SqlSessionTemplate sqlSession;

  @Override
  public int insertDev(Dev dev) {
    return dao.insertDev(sqlSession, dev);
  }

  @Override
  public List<Dev> selectDevList() {
    return dao.selectDevList(sqlSession);
  }

  @Override
  public int updateDev(Dev dev) {
    return dao.updateDev(sqlSession, dev);
  }

  @Override
  public int deleteDev(Dev dev) {
    return dao.deleteDev(sqlSession, dev);
  }

}
