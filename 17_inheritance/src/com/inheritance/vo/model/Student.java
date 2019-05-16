package com.inheritance.vo.model;

public class Student extends Person{
	private int year;
	private char grade;

	public Student(String name, int age, char gender, String addr, int year, char grade) {
		super(name, age, gender, addr);
		this.year = year;
		this.grade = grade;
	}

	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
	public char getGrade() { return grade; }
	public void setGrade(char grade) { this.grade = grade; }
}
