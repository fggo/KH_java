package com.mybatis.model.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.dao.MybatisDaoImpl;
import com.mybatis.model.vo.Member;

import common.SqlSessionTemplate;

public class MybatisServiceImpl implements MybatisService {
  private MybatisDao dao = new MybatisDaoImpl();

  @Override
  public int insertMemberAll(Member m) {
    SqlSession session = SqlSessionTemplate.getSession();
    
    int result = dao.insertMemberAll(session, m);
    
    if(result>0) session.commit();
    else session.rollback();
    
    session.close();
    
    return result;
  }

}
