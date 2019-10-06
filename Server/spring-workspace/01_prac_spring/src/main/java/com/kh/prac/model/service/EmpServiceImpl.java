package com.kh.prac.model.service;

import static common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.prac.model.dao.EmpDao;
import com.kh.prac.model.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService {

  private EmpDao dao = new EmpDaoImpl();

  @Override
  public int insertEmp(Map<String, Object> param) {
    SqlSession session = getSession();

    int result = dao.insertEmp(session, param);

    if(result >0) session.commit();
    else session.rollback();

    return result;
  }

  @Override
  public List<Map> searchEmp(Map<String, Object> param) {
    SqlSession session = getSession();
    List<Map> list = dao.searchEmp(session, param);
    
    session.close();
    
    return list;
  }



}
