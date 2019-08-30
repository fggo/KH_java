package com.kh.board.model.dao;

import static common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardComment;

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
  
  public int selectSeqBoard(Connection conn, Board b) {
    Statement stmt = null;
    ResultSet rs = null;
    int result = 0;
    String sql="select seq_board_no.currval from dual";
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      if(rs.next()) {
        result = rs.getInt(1);
      }
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      close(rs);
      close(stmt);
    }
    return result;
  }

  public int insertBoard(Connection conn, Board b)
  {
    PreparedStatement pstmt = null;
    int result = 0;
    String sql = prop.getProperty("insertBoard");

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, b.getBoardTitle());
      pstmt.setString(2, b.getBoardWriter());
      pstmt.setString(3, b.getBoardContent());
      pstmt.setString(4, b.getBoardOriginalFilename());
      pstmt.setString(5, b.getBoardRenamedFilename());

      result= pstmt.executeUpdate();
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      close(pstmt);
    }
    return result;
  }
  
  public int updateCount(Connection conn, int no) {
    Statement stmt = null;
    int result = 0;
    String sql = "update board set board_readcount=board_readcount+1"
        + " where board_no=" + no;

    try {
      stmt = conn.createStatement();
      result = stmt.executeUpdate(sql);
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(stmt);
    }
    return result;
  }
  
  public int insertComment(Connection conn, BoardComment bc) {
    PreparedStatement pstmt = null;
    int result = 0;
    String sql = prop.getProperty("insertComment");
    try {
      pstmt= conn.prepareStatement(sql);
      pstmt.setInt(1, bc.getBoardCommentLevel());
      pstmt.setString(2, bc.getBoardCommentWriter());
      pstmt.setString(3, bc.getBoardCommentContent());
      pstmt.setInt(4, bc.getBoardRef());
      pstmt.setString(5, bc.getBoardCommentRef()==0? null:String.valueOf(bc.getBoardCommentRef()));

      result = pstmt.executeUpdate();

    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
    }

    return result;
  }
  
  public List<BoardComment> selectBoardComment(Connection conn, int boardNo){
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<BoardComment> list = new ArrayList<BoardComment>();
    BoardComment bc = null;
    String sql = prop.getProperty("selectBoardComment");
    
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, boardNo);
      rs = pstmt.executeQuery();

      while(rs.next()) {
        bc = new BoardComment();

        bc.setBoardCommentNo(rs.getInt("board_comment_no"));
        bc.setBoardCommentLevel(rs.getInt("board_comment_level"));
        bc.setBoardCommentWriter(rs.getString("board_comment_writer"));
        bc.setBoardCommentContent(rs.getString("board_comment_content"));
        bc.setBoardRef(rs.getInt("board_ref"));
        bc.setBoardCommentRef(rs.getInt("board_comment_ref"));
        bc.setBoardCommentDate(rs.getDate("board_comment_date"));

        list.add(bc);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    return list;
  }

  public int deleteComment(Connection conn, int boardRef, int commentNo) {
    PreparedStatement pstmt = null;
    int result = 0;
    String sql = prop.getProperty("deleteComment");
    
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, boardRef);
      pstmt.setInt(2, commentNo);
      
      result = pstmt.executeUpdate();
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
    }
    
    return result;
  }
}
