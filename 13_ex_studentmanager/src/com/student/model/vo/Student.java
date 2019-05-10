package com.student.model.vo;

public class Student {
	private static int count = 0;
	private int studentNo;
	private String name;
	private char grade;
	private int number;
	private int year;
	private double sungjuk;
	
	{
		studentNo = count++;
	}

	public Student(String name, char grade, int no,
			double sungjuk, int year) {
		this.name = name;
		this.grade = grade;
		this.number = no;
		this.sungjuk = sungjuk;
		this.year = year;
	}

	//setter getter
	public int getStudentNo() { return studentNo; }
	public void setStudentNo(int studentNo) { this.studentNo = studentNo; }
	public int getNumber() { return number; }
	public void setNumber(int number) { this.number = number; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public char getGrade() { return grade; }
	public void setGrade(char grade) { this.grade = grade; }
	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
	public double getSungjuk() { return sungjuk; }
	public void setSungjuk(double sungjuk) { this.sungjuk = sungjuk; }
	
	public static int getCount() { return Student.count; }
	public static void minusCount() {count--;}

	public void printStudent() {
		System.out.printf("%s학생은 %d학년 %d번이고 "
				+ "성적은 %.2f점 %c학점 입니다.\n", 
				name, year, number, sungjuk, grade);
	}
}
