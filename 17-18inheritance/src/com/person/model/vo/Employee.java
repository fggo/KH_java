package com.person.model.vo;

public class Employee extends Person{
	private String dept;
	private int sal;
	
	public Employee(String name, int age, char gender, String addr, String dept, int sal) {
		super(name, age, gender, addr);
		this.dept = dept;
		this.sal = sal;
	}
	public String getDept() { return dept; }
	public void setDept(String dept) { this.dept = dept; }
	public int getSal() { return sal; }
	public void setSal(int sal) { this.sal = sal; }
}
