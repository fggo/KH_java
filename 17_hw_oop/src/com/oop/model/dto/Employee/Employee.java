package com.oop.model.dto.Employee;

import com.oop.view.MainMenu;

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

//	1. 키보드입력용 메소드 : empInput()
	public static void empInput() {
	}
	public static void empOutput() {
	}
//	2. 출력용 메소드 : empOutput()
//	3. 값 변경용 메소드 : setName(String newName) //이름 변경용
//	  => 각 필드 값 변경용 메소드 작성
//	* 실행용 클래스 : com.oop.run.EmpTest
//	메뉴작성 : 메소드 작성
	
	public static void modify() {
	}

	
	public static void delete() {
	}

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
}
