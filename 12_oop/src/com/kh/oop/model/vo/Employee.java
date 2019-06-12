package com.kh.oop.model.vo;

import java.util.Date;

public class Employee {
	private String name;
	private String dept;
	private int salary;
	private String job;
	private int foryears;
	private Date enrollDate;

	private Employee() {
		this.name = "홍길동";
		this.dept = "미지정부서";
		this.job = "사원";
	}

	public Employee(String name, String dept, int sal, String job, int years, Date date) {
		this.name =name;
		this.dept = dept;
		this.salary = sal;
		this.job = job;
		this.foryears = years;
		this.enrollDate = date;
	}
	
	public static Employee getEmployee() {
		return new Employee();
	}
	
	public void printEmployee() {
		System.out.println(name  + dept + salary + 
				job + foryears + enrollDate);
	}
}
