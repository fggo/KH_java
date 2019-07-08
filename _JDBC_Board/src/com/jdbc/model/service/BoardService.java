package com.jdbc.model.service;

import static com.jdbc.common.JDBCTemplate.getConnection;
import static com.jdbc.common.JDBCTemplate.close;
import static com.jdbc.common.JDBCTemplate.commit;
import static com.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jdbc.model.dao.BoardDao;
import com.jdbc.model.vo.Board;

public class BoardService {
	private BoardDao dao = new BoardDao();

	public List<Board> selectAll(){
		Connection conn = getConnection();
		List<Board> list = dao.selectAll(conn);
		
		close(conn);

		return list;
	}
	
	public List<Board> selectWriter(String writer){
		Connection conn = getConnection();
		List<Board> list = dao.selectWriter(conn, writer);
		
		close(conn);

		return list;
	}

	public List<Board> selectTitle(String title){
		Connection conn = getConnection();
		List<Board> list = dao.selectTitle(conn, title);
		
		close(conn);
		
		return list;
	}
	
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = dao.insertBoard(conn, b);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}
	
	public int updateBoard(Board b) {
		Connection conn = getConnection();
		int result = dao.updateBoard(conn, b);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}
	
	public int deleteBoard(int idx) {
		Connection conn = getConnection();
		int result = dao.deleteBoard(conn, idx);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}

	
}
