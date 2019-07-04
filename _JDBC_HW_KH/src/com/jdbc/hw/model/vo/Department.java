package com.jdbc.hw.model.vo;

public class Department {
	private String dept_id;
	private String dept_title;
	private String location_id;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(String dept_id, String dept_title, String location_id) {
		super();
		this.dept_id = dept_id;
		this.dept_title = dept_title;
		this.location_id = location_id;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_title=" + dept_title + ", location_id=" + location_id + "]";
	}

	public String getDept_id() { return dept_id; } 
	public void setDept_id(String dept_id) { this.dept_id = dept_id; } 
	public String getDept_title() { return dept_title; } 
	public void setDept_title(String dept_title) { this.dept_title = dept_title; } 
	public String getLocation_id() { return location_id; } 
	public void setLocation_id(String location_id) { this.location_id = location_id; } 
}
