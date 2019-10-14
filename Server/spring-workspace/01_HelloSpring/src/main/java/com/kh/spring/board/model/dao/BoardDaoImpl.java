package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//spring bean으로 등록하고 알아서 관리: Dao는 Repository로 적어야 클래스가 bean으로 등록됨
@Repository
public class BoardDaoImpl implements BoardDao {


  @Override
  public List<Map<String, String>> selectBoardList(SqlSessionTemplate sqlSession, int cPage, int numPerPage) {
    RowBounds rows = new RowBounds((cPage-1)*numPerPage, numPerPage);
    return sqlSession.selectList("board.selectBoardList", null, rows);
  }

  @Override
  public int selectBoardCount(SqlSessionTemplate sqlSession) {

    return sqlSession.selectOne("board.selectBoardCount");
  }
  
  
  
  
}
