package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;
@Repository
public class BoardDaoImpl implements BoardDao {

		
	@Override
	public int insertBoard(SqlSessionTemplate session, Map<String, String> param) {
		return session.insert("board.insertBoard",param);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, Attachment att) {
		return session.insert("board.insertAttachment", att);
	}

	@Override
	public int selectBoardCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectBoardCount");
	}

	@Override
	public List<Map<String, String>> selectBoardList(SqlSessionTemplate session, int cPage, int numPerPage) {
		RowBounds rows=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return session.selectList("board.selectBoardList",null,rows);
	}

}




