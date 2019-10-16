package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//  @Transactional //트랜젝션의 기준이 되는 것 : RunTimeException 발생시! Exception으로 하면 안됨
//  @Transactional(rollbackFor = Exception.class) //트랜젝션의 기준이 되는 것 : 모든 에러 Exception (RunTimeException 포함) 발생시!
  //annotation 방식 말고 root-context.xml에 등록가능
  public int insertBoard(Map<String, String> param, List<Attachment> attachList) throws Exception{
    //세션 트랜젝션 관리(by spring)
    int result = 0;
    result = dao.insertBoard(sqlSession, param); //board테이블에 데이터 입력!

    if(result ==0) throw new RuntimeException(); //TransactionManager가 자동으로 롤백 처리함

    result = 0; //test RunTime Exception(로직은 제대로 됨)

    if(attachList.size() > 0) {
      for(Attachment a : attachList) {
        a.setBoardNo(Integer.parseInt(param.get("boardNo")));
//        result = dao.insertAttachment(sqlSession, a); //board테이블에 데이터 입력!
        dao.insertAttachment(sqlSession, a); //board테이블에 데이터 입력!
//        한개 데이터 들어가고 exception 처리됨(입력실패)
//        ->TransactionManager는 RunTimeException기준이므로 Exception을 사용하면 1개 들어감
//        상속에 의해 Exception은 더 넓은 범위라 RunTimeException처리가 안됨
//        if(result ==0) throw new RuntimeException(); 
        if(result ==0) throw new Exception();
      }
    }
    
    return result;
  }

  @Override
  public Map<String, String> selectBoard(int no) {
    return dao.selectBoard(sqlSession, no);
  }

  @Override
  public List<Attachment> selectAttachList(int no) {
    return dao.selectAttachList(sqlSession, no);
  }
  
  
  
}
