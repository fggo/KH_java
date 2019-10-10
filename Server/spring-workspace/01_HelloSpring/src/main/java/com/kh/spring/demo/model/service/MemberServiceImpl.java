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
  //spring bean으로 등록되어 있어서 자동으로 관리

  @Override
  public Member selectMemberOne(Member m) {
    return dao.selectMemberOne(sqlSession, m);
  }

  @Override
  public int insertMember(Member m) {
    return dao.insertMember(sqlSession, m);
  }
  
}
