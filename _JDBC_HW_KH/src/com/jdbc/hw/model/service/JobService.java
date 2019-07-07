package com.jdbc.hw.model.service;

import static com.jdbc.hw.common.JDBCTemplate.getConnection;
import static com.jdbc.hw.common.JDBCTemplate.close;
import static com.jdbc.hw.common.JDBCTemplate.commit;
import static com.jdbc.hw.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jdbc.hw.model.dao.JobDao;
import com.jdbc.hw.model.vo.Job;

public class JobService {
	private JobDao dao = new JobDao();

	public List<Job> searchAll(){
		Connection conn = getConnection();
		List<Job> list = dao.searchAll(conn);
		
		close(conn);
		
		return list;
	}
	
	public int insertJob(Job job) {
		Connection conn = getConnection();
		int result = dao.insertJob(conn, job);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
	
	public int updateJob(Job job) {
		Connection conn = getConnection();
		int result = dao.updateJob(conn, job);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
	
	public int deleteJob(String jobCode) {
		Connection conn = getConnection();
		int result = dao.deleteJob(conn, jobCode);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
}
