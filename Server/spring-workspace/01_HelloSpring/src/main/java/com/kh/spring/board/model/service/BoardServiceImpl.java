package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;

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

  @Override
  public int insertBoard(Map<String, String> param, List<Attachment> attachList) {
    //세션 트랜젝션 관리(by spring)
    int result = 0;
    result = dao.insertBoard(sqlSession, param); //board테이블에 데이터 입력!

    if(attachList.size() > 0) {
      for(Attachment a : attachList) {
        a.setBoardNo(Integer.parseInt(param.get("boardNo")));
        result = dao.insertAttachment(sqlSession, a);
      }
    }
    
    return result;
  }
  
}
