package com.jdbc.hw.model.dao;

import static com.jdbc.hw.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.hw.model.vo.Department;

public class DeptDao {
	public List<Department> searchAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPARTMENT";
		
		List<Department> list = new ArrayList<Department>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			list = this.getDept(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertDept(Connection conn, Department dept) {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO DEPARTMENT VALUES(?,?,?)";
		
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDeptId());
			pstmt.setString(2, dept.getDeptTitle());
			pstmt.setString(3, dept.getLocationId());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateDept(Connection conn, Department dept) {
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE DEPARTMENT SET dept_title=?, location_id=? WHERE dept_id=?";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDeptTitle());
			pstmt.setString(2, dept.getLocationId());
			pstmt.setString(3, dept.getDeptId());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int deleteDept(Connection conn, String deptId) {
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM DEPARTMENT WHERE dept_id=?";

		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptId);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	private List<Department> getDept(ResultSet rs){
		List<Department> list = new ArrayList<Department>();
		Department dept = null;

		try {
			while(rs.next()) {
				dept = new Department();
				dept.setDeptId(rs.getString("dept_id"));
				dept.setDeptTitle(rs.getString("dept_title"));
				dept.setLocationId(rs.getString("location_id"));
				
				list.add(dept);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
