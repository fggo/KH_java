package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.bcel.AtAjAttributes;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public int insertBoard(Map<String, String> param, List<Attachment> attachList) {
		int result=0;
		result=dao.insertBoard(session,param);//board테이블에 데이터 입력!
		
		if(attachList.size()>0) {
			for(Attachment a : attachList) {
				a.setBoardNo(Integer.parseInt(param.get("boardNo")));
				result=dao.insertAttachment(session,a);
			}
		}
		
		return result;
	}

	@Override
	public int selectBoardCount() {
		return dao.selectBoardCount(session);
	}

	@Override
	public List<Map<String, String>> selectBoardList(int cPage, int numPerpage) {
		return dao.selectBoardList(session,cPage,numPerpage);
	}

}
