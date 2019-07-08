package com.jdbc.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.jdbc.common.JDBCTemplate.close;
import com.jdbc.model.vo.Board;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		try {
			prop.load(new FileReader("resources/board_query.properties"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Board> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectAll");
		
		List<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = this.getBoardList(rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public List<Board> selectWriter(Connection conn, String writer) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectWriter");
		
		List<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();

			list = this.getBoardList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public List<Board> selectTitle(Connection conn, String title) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectTitle");
		
		List<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			list = this.getBoardList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getDiv());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getBoardComment());
			pstmt.setString(4, b.getWriter());
		
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getBoardComment());
			pstmt.setInt(3, b.getIdx());
		
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBoard(Connection conn, int idx) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx);
		
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	private List<Board> getBoardList(ResultSet rs){
		List<Board> list = new ArrayList<Board>();
		Board b = null;

		try {
			while(rs.next()) {
				b = new Board();
				
				b.setIdx(rs.getInt("idx"));
				b.setDiv(rs.getString("div"));
				b.setTitle(rs.getString("title"));
				b.setBoardComment(rs.getString("board_comment"));
				b.setWriter(rs.getString("writer"));
				b.setWriteDate(rs.getDate("write_date"));
				
				list.add(b);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
