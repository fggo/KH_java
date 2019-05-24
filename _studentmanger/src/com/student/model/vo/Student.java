package com.student.model.vo;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int grade;
	private int room;
	private int number;
	private String address;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int grade, int room, int number, String address) {
		super();
		this.name = name;
		this.grade = grade;
		this.room = room;
		this.number = number;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", room=" + room + ", number=" + number + ", address="
				+ address + "]";
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getGrade() { return grade; }
	public void setGrade(int grade) { this.grade = grade; }
	public int getRoom() { return room; }
	public void setRoom(int room) { this.room = room; }
	public int getNumber() { return number; }
	public void setNumber(int number) { this.number = number; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
}
