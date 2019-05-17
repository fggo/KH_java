package com.person.model.vo;

public class Student extends Person{
	private int grade;
	private int sungjuk;
	
	public Student() {}

	public Student(String name, int age, char gender, String address,
			int grade, int sungjuk) {
		super(name, age, gender, address);
		this.grade = grade;
		this.sungjuk = sungjuk;
	}

	public int getGrade() { return grade; }
	public void setGrade(int grade) { this.grade = grade; }
	public int getSungjuk() { return sungjuk; }
	public void setSungjuk(int sungjuk) { this.sungjuk = sungjuk; }
	
	@Override
	public String toString(){
		return super.getName() + super.getAge()
			+ grade + sungjuk;
	}
}
