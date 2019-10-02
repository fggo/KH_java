package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

  @Override
  public List<Map> selectSearch1(SqlSession session, Map<String, String> param) {
    //여기서 case문 쓸필요 없이 mapper.xml에서 <if> <when> 등으로 조건문 씀
    return session.selectList("emp.selectSearch1", param);
  }

  @Override
  public List<Map> selectSearch2(SqlSession session, Map<String, Object> param) {
    return session.selectList("emp.selectSearch2", param);
  }

  @Override
  public List<Map<String,String>> selectEmpList(SqlSession session, int cPage, int numPerPage) {
    // 1.마이바티스에서 페이징처리를 하기 위해서는 RowBounds객체를 이용
    //RowBounds객체를 생성해서 매개변수로 대입을 해주면 자동으로
    //RowBounds의 값에 의해 설정된 값으로 페이징 처리를 하게됨.
    //생성자의 매개변수: offset, limit
    //  offset : 몇개의 자료를(row) 가져올지(건너뛸지) == 시작 값
    //  limit : 한 페이지 당 게시물 수 == 마지막 값
    RowBounds row = new RowBounds((cPage - 1)*numPerPage, numPerPage);

    return session.selectList("emp.selectEmpList", null, row);
  }

  @Override
  public int selectEmpCount(SqlSession session) {
    return session.selectOne("emp.selectEmpCount");
  }
}
