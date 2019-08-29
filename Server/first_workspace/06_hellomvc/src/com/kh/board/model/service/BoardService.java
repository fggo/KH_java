package com.kh.board.model.service;

import static common.template.JDBCTemplate.close;
import static common.template.JDBCTemplate.commit;
import static common.template.JDBCTemplate.getConnection;
import static common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardComment;

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
    if(b!=null) {
      int result = dao.updateCount(conn, no);

      if(result>0) {commit(conn);}
      else {rollback(conn);}  
    }
    
    close(conn);

    return b;
  }
  
  public Board selectBoardOne(int no, boolean hasRead) {
    Connection conn = getConnection();
    
    Board b = dao.selectBoardOne(conn, no);
    if(!hasRead) {
      if(b!=null) {
        int result = dao.updateCount(conn, no);
        
        if(result>0) {commit(conn);}
        else {rollback(conn);}  
      }
    }
    
    close(conn);

    return b;
  }

  public int insertBoard(Board b) {
    Connection conn = getConnection();
    int result = dao.insertBoard(conn, b);
    if(result > 0) {
      commit(conn);

      result = dao.selectSeqBoard(conn, b);

    }else {
      rollback(conn);
    }
    
    return result;
  }
  
  public int insertComment(BoardComment bc) {
    Connection conn = getConnection();
    int result = dao.insertComment(conn, bc);
    
    if(result>0) {commit(conn);}
    else {rollback(conn);}
    close(conn);

    return result;
  }
}
