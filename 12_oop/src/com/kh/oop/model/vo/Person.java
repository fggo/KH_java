package com.kh.oop.model.vo;

public class Person {

	private String memberId="p001";
	private String name;
	//public int age;
	//char gender;//default
	private int age;
	private char gender;
	private String[] hobby;
	private double height;
	
	public Person() {}

	//setter메소드!
	public void setName(String name) {
		this.name=name;
	}
	//getter메소드!
	public String getName() {
		return name;
	}
	public void setMemberId(String id) {
		this.memberId = id;
	}
	public String getMemberId() {
		return memberId;
	}
	
	public void printPerson() {
		System.out.println(name+age+gender+hobby+height);
	}
}
