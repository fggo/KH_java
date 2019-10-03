package com.prac.model.service;

import static common.SqlSessionTemplate.getSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.prac.model.dao.EmpDao;
import com.prac.model.dao.EmpDaoImpl;

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

}
