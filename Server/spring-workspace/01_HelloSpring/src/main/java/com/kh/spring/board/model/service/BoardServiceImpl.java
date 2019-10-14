package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

//  controller service만 bean으로 등록해줌
  @Autowired
  BoardDao dao;

  @Autowired
  SqlSessionTemplate sqlSession;
  //spring bean으로 등록되어 있어서 자동으로 관리

  @Override
  public List<Map<String, String>> selectBoardList(int cPage, int numPerPage) {
    return dao.selectBoardList(sqlSession, cPage, numPerPage);
  }

  @Override
  public int selectBoardCount() {
    return dao.selectBoardCount(sqlSession);
  }
  
  
  
  
  
}
