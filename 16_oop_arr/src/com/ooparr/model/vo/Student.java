package com.ooparr.model.vo;

public class Student extends Person{
	private double grade;
	private String major;

	public Student() {}

	public Student(String name, int age, String address, char gender, 
			int grade, String major) {

		super(name, age, address, gender);

		super.setName(name);
		super.setAge(age);
		super.address = address; //protected
		super.setGender(gender);
		this.grade = grade;
		this.major = major;
	}
	
	public void printStudent() { System.out.println(this); }

	public double getGrade() { return grade; }
	public void setGrade(double grade) { this.grade = grade; }
	public String getMajor() { return major; }
	public void setMajor(String major) { this.major = major; }

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", major=" + major + ", address=" + address + ", getGrade()=" + getGrade()
				+ ", getMajor()=" + getMajor() + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getAddress()=" + getAddress() + ", getGender()=" + getGender() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
