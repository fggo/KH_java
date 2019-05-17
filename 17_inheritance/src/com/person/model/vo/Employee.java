package com.person.model.vo;

public class Employee extends Person{
	private String dept;
	private int salary;
	public Employee() {}

	public Employee(String name, int age, char gender, String address, String dept, int salary) {
		super(name, age, gender, address);
		this.dept = dept;
		this.salary = salary;
	}

	public String getDept() { return dept; }
	public void setDept(String dept) { this.dept = dept; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	
	
}
