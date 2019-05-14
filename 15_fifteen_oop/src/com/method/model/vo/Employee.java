package com.method.model.vo;

public class Employee {
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;

	public Employee() {}

	public int getEmpNo() { return empNo; }
	public void setEmpNo(int empNo) { this.empNo = empNo; }
	public String getEmpName() { return empName; } 
	public void setEmpName(String empName) { this.empName = empName; }
	public String getDept() { return dept; }
	public void setDept(String dept) { this.dept = dept; }
	public String getJob() { return job; }
	public void setJob(String job) { this.job = job; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public char getGender() { return gender; }
	public void setGender(char gender) { this.gender = gender; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	public double getBonusPoint() { return bonusPoint; }
	public void setBonusPoint(double bonusPoint) { this.bonusPoint = bonusPoint; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	public void printEmployee() {
	}
}
