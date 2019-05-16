package com.inheritance.vo.model;

public class Person {
	private String name;
	private int age;
	private char gender;
	private String addr;
	
	public Person(String name, int age, char gender, String addr) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.addr = addr;
	}
	
	public void printInfo() {
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public char getGender() { return gender; }
	public void setGender(char gender) { this.gender = gender; }
	public String getAddr() { return addr; }
	public void setAddr(String addr) { this.addr = addr; }
	
}
