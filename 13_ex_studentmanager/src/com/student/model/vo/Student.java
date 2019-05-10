package com.student.model.vo;

public class Student {
	private int studentNo;
	private int number;
	private String name;
	private int year;
	private char grade;
	private int classRoom;
	private double score;
	private static int count = 0;

	public Student(int no, String name, int year,
			char grade, int classRoom, double score) {
		this.number = no;
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.classRoom = classRoom;
		this.score = score;
		studentNo = count++;
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
	public int getClassRoom() { return classRoom; }
	public void setClassRoom(int classRoom) { this.classRoom = classRoom; }
	public double getScore() { return score; }
	public void setScore(double score) { this.score = score; }
	
	public static int getCount() {
		return Student.count;
	}

	public void printStudent() {
		System.out.printf("%d번 %s학생은 %d학년 %d반이고 "
				+ "성적은 %.2f점 %c학점 입니다.\n", 
				studentNo, name, year, classRoom, score, grade);
	}
	
}
