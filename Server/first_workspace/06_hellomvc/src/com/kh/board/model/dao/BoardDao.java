package com.kh.board.model.dao;

import static common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.vo.Board;

public class BoardDao {
  private Properties prop = new Properties();
  
  public BoardDao() {
    String path = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
    try {
      prop.load(new FileReader(path));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  
  public int selectCountBoard(Connection conn) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = prop.getProperty("selectCountBoard");

    int count = 0;
    
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        count = rs.getInt("cnt");
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }

    return count;
  }
  
  public List<Board> selectBoardList(Connection conn, int cPage, int numPerPage){
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = prop.getProperty("selectBoardList");
    
    List<Board> list = new ArrayList<Board>();

    int start = (cPage-1)*numPerPage+1;
    int end = cPage*numPerPage;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, start);
      pstmt.setInt(2, end);

      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        Board b = new Board();

        b.setBoardNo(rs.getInt("board_no"));
        b.setBoardTitle(rs.getString("board_title"));
        b.setBoardWriter(rs.getString("board_writer"));
        b.setBoardContent(rs.getString("board_content"));
        b.setBoardOriginalFilename(rs.getString("board_original_filename"));
        b.setBoardRenamedFilename(rs.getString("board_renamed_filename"));
        b.setBoardDate(rs.getDate("board_date"));
        b.setBoardReadcount(rs.getInt("board_readcount"));
        
        list.add(b);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    
    return list;
  }

  public Board selectBoardOne(Connection conn, int no){
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = prop.getProperty("selectBoardOne");
    
    Board b = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, no);

      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        b = new Board();

        b.setBoardNo(rs.getInt("board_no"));
        b.setBoardTitle(rs.getString("board_title"));
        b.setBoardWriter(rs.getString("board_writer"));
        b.setBoardContent(rs.getString("board_content"));
        b.setBoardOriginalFilename(rs.getString("board_original_filename"));
        b.setBoardRenamedFilename(rs.getString("board_renamed_filename"));
        b.setBoardDate(rs.getDate("board_date"));
        b.setBoardReadcount(rs.getInt("board_readcount"));
      }

    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    
    return b;
  }
}
