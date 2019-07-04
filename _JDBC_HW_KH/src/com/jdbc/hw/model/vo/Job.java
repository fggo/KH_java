package com.jdbc.hw.model.vo;

public class Job {
	private String job_code;
	private String job_name;

	public Job() {
		// TODO Auto-generated constructor stub
	}
	
	public Job(String job_code, String job_name) {
		super();
		this.job_code = job_code;
		this.job_name = job_name;
	}
	
	@Override
	public String toString() {
		return "Job [job_code=" + job_code + ", job_name=" + job_name + "]";
	}

	public String getJob_code() { return job_code; }
	public void setJob_code(String job_code) { this.job_code = job_code; }
	public String getJob_name() { return job_name; }
	public void setJob_name(String job_name) { this.job_name = job_name; }
}
