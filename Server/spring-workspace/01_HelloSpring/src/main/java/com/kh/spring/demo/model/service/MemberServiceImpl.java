package com.kh.spring.demo.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.MemberDao;
import com.kh.spring.demo.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

//  controller service만 bean으로 등록해줌
  @Autowired
  MemberDao dao;

  @Autowired
  SqlSessionTemplate sqlSession;

  @Override
  public Member selectMemberOne(Member m) {
    return dao.selectMemberOne(sqlSession, m);
  }
  
}
