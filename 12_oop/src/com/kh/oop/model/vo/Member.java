package com.kh.oop.model.vo;

public class Member {
	public static String name;
	private String memberID = "p001";
	char gender;
	private int age;
	private int sal;
	private int maritalCount;
	private int child;

	public Member() {
		memberID = "";
	}
	public Member(String memberID) {
		this.memberID = memberID;
	}

	public void printMember() {
		System.out.println(getName()+ memberID + gender + age);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
}