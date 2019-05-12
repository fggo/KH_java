package com.student.model.vo;

public class Student {
	//학생수
	private static int count = 0;
	private int studentNo;

	//학생정보
	private int number; //학번
	private String name;
	private int year;
	private double score;

	{
		studentNo = count++;
	}

	public Student() {}
	
	public Student(int number, String name, int year, double score) {
		this.number = number;
		this.name = name;
		this.year = year;
		this.score = score;
	}

	public int getStudentNo() { return studentNo; }
	public void setStudentNo(int studentNo) { this.studentNo = studentNo; }
	public int getNumber() { return number; }
	public void setNumber(int number) { this.number = number; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
	public double getScore() { return score; }
	public void setScore(double score) { this.score = score; }
	public char getGrade() { 
		char grade = '\u0000';
		switch((int)score/10) {
			case 9: case 10: grade = 'A'; break;
			case 8: grade = 'B'; break;
			case 7: grade = 'C'; break;
			case 6: grade = 'D'; break;
			case 5:case 4: case 3: case 2: case 1: case 0:
				grade = 'F';
				break;
			default:
				System.out.println("잘못된 점수가 입력되어 있습니다.");
		}
		return grade;
	}


	
	public static int getCount() { return count; }
	public static void setCount(int n) { Student.count = n; }
	
	public void printStudent() {
		System.out.printf("%d 학번 %d 학년 %s 학생의 성적은 %.2f 학점은 %c입니다.\n",
				number, year, name, score, getGrade());
	}
}