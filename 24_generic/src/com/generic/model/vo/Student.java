package com.generic.model.vo;

public class Student<T, U> {

	T studentNo;
	U test;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(T sudentNo, U test) {
		this.studentNo=studentNo;
		this.test = test;
	}

//	public void setStudentNo() {
//		
//	}
}