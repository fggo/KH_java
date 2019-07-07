package com.jdbc.hw.model.dao;

import static com.jdbc.hw.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.hw.model.vo.Job;

public class JobDao {
	public List<Job> searchAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM JOB";
		
		List<Job> list = new ArrayList<Job>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = getJobList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertJob(Connection conn, Job job) {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO JOB VALUES(?,?)";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job.getJobCode());
			pstmt.setString(2, job.getJobName());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateJob(Connection conn, Job job) {
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE JOB SET job_name=? WHERE job_code=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job.getJobName());
			pstmt.setString(2, job.getJobCode());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteJob(Connection conn, String jobCode) {
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM JOB WHERE job_code=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobCode);
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	private List<Job> getJobList(ResultSet rs){
		List<Job> list = new ArrayList<Job>();
		Job job = null;
		
		try {
			while(rs.next()) {
				job = new Job();
				
				job.setJobCode(rs.getString("job_code"));
				job.setJobName(rs.getString("job_name"));
				
				list.add(job);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
