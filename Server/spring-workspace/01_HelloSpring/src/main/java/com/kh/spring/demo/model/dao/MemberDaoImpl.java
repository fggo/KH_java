package com.kh.spring.demo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Member;

//spring bean으로 등록하고 알아서 관리: Dao는 Repository로 적어야 클래스가 bean으로 등록됨
@Repository
public class MemberDaoImpl implements MemberDao {

  @Override
  public Member selectMemberOne(SqlSessionTemplate sqlSession, Member member) {
    return sqlSession.selectOne("member.selectMember", member);
  }

  @Override
  public int insertMember(SqlSessionTemplate sqlSession, Member m) {
    return sqlSession.insert("member.insertMember", m);
  }
  
}
