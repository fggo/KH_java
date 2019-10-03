package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

  @Override
  public List<Map> selectSearch1(SqlSession session, Map<String, String> param) {
    //case mapper.xml : <if> <when>
    return session.selectList("emp.selectSearch1", param);
  }

  @Override
  public List<Map> selectSearch2(SqlSession session, Map<String, Object> param) {
    return session.selectList("emp.selectSearch2", param);
  }

  @Override
  public List<Map<String,String>> selectEmpList(SqlSession session, int cPage, int numPerPage) {
    // 1. 마이바티스에서 페이징처리를 하기 위해서는 RowBounds객체를 이용
    // RowBounds객체를 생성해서 매개변수로 대입을 해주면 
    // RowBounds 값의 의해 설정된 값을 페이징 처리를 하게됨
    // 생성자의 매개변수 : offset, limit 두개의 값을 받음
    // offset : 몇개의 자료를 (row)가져올지(건너 뛸지)
    // limit : 한페이지당 게시물수 -> 마지막
    RowBounds row = new RowBounds((cPage - 1)*numPerPage, numPerPage);

    return session.selectList("emp.selectEmpList", null, row);
  }

  @Override
  public int selectEmpCount(SqlSession session) {
    return session.selectOne("emp.selectEmpCount");
  }
}
