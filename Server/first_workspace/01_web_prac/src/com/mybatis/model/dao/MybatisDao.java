package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Member;

public interface MybatisDao {
  public int insertMemberAll(SqlSession session, Member m);
}
