package com.kh.oop.model.vo;

import java.util.Date;

public class Employee {
	private String name;
	private String dept;
	private int salary;
	private String job;
	private int foryears;
	private Date enrollDate;

	//default/private ACS일경우 
	//다른 package에서 디폴트로 객체 생성시 에러!
	private Employee() {
		//this : Employee클래스 주소값에 접근
		System.out.println("디폴트 생성자 호출!");
		this.name = "바바바";
		this.dept = "미지정부서";
		this.job = "신입";
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
