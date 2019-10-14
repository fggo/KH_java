package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.model.dao.MemoDao;

@Service
public class MemoServiceImpl implements MemoService {

//  controller service만 bean으로 등록해줌
  @Autowired
  MemoDao dao;

  @Autowired
  SqlSessionTemplate sqlSession;
  //spring bean으로 등록되어 있어서 자동으로 관리

  @Override
  public List<Map<String, String>> selectList() {
    return dao.selectList(sqlSession);
  }
  
  
  
  
}
