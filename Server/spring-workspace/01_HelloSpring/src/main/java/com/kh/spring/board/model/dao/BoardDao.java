package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.board.model.vo.Attachment;

public interface BoardDao {
  List<Map<String, String>> selectBoardList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);
  int selectBoardCount(SqlSessionTemplate sqlSession);
  int insertBoard(SqlSessionTemplate sqlSession, Map<String,String> param);
  int insertAttachment(SqlSessionTemplate sqlSession, Attachment att);

}
