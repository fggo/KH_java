package com.list.model.vo;

public class Student extends Person {
	private int year;
	private int grade;
	private String major;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String address, int year, int grade, String major) {
		super(name, age, address);
		this.year = year;
		this.grade = grade;
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [year=" + year + ", grade=" + grade + ", major=" + major + "]";
	}

	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
	public int getGrade() { return grade; }
	public void setGrade(int grade) { this.grade = grade; }
	public String getMajor() { return major; }
	public void setMajor(String major) { this.major = major; }
}
