package com.kh.board.model.service;

import static common.template.JDBCTemplate.close;
import static common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

public class BoardService {
  private BoardDao dao = new BoardDao();
  
  
  public int selectCountBoard() {
    Connection conn = getConnection();
    
    int count= dao.selectCountBoard(conn);
    
    close(conn);
    
    return count;
  }
  
  public List<Board> selectBoardList(int cPage, int numPerPage){
    Connection conn = getConnection();
    
    List<Board> list = dao.selectBoardList(conn, cPage, numPerPage);
    
    close(conn);

    return list;
  }
  
  public Board selectBoardOne(int no) {
    Connection conn = getConnection();
    
    Board b = dao.selectBoardOne(conn, no);
    
    close(conn);

    return b;
  }
}
