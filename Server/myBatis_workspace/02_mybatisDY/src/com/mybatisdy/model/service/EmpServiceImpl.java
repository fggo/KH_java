package com.mybatisdy.model.service;

import static common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatisdy.model.dao.EmpDao;
import com.mybatisdy.model.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService {
  private EmpDao dao = new EmpDaoImpl();

  @Override
  public List<Map> selectSearch1(Map<String, String> param) {
    SqlSession session = getSession();
    List<Map> list = dao.selectSearch1(session, param);
    
    session.close();
    
    return list;
  }

  @Override
  public List<Map> selectSearch2(Map<String, Object> param) {
    SqlSession session = getSession();

    List<Map> list = dao.selectSearch2(session, param);
    
    session.close();
    
    return list;
  }

  @Override
  public List<Map<String, String>> selectEmpList(int cPage, int numPerPage) {
    SqlSession session = getSession();
    
    List<Map<String, String>> list = dao.selectEmpList(session, cPage, numPerPage);

    session.close();

    return list;
  }

  @Override
  public int selectEmpCount() {
    SqlSession session = getSession();
    
    int count = dao.selectEmpCount(session);

    session.close();

    return count;
  }
  
}
