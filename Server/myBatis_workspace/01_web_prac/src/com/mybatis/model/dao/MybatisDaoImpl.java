package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Member;

public class MybatisDaoImpl implements MybatisDao {

  @Override
  public int insertMemberAll(SqlSession session, Member m) {
    session.insert("insertMemberAll", m);
    return 0;
  }

}
