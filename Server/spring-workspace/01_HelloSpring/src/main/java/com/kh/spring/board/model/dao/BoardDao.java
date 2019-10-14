package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface BoardDao {
  public List<Map<String, String>> selectBoardList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);
  public int selectBoardCount(SqlSessionTemplate sqlSession);
}
