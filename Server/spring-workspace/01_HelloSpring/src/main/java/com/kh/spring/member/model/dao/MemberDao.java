package com.kh.spring.member.model.dao;


import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.member.model.vo.Member;

public interface MemberDao {
  Member selectMemberOne(SqlSessionTemplate sqlSession, Member member);
  int insertMember(SqlSessionTemplate sqlSession, Member m);
}
