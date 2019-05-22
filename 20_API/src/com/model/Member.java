package com.model;

public class Member {

	private String id;
	private String pw;
	private String name;
	private int age;
	private double height;
	private String nickname;

	public Member(String id, String pw, String name, int age, double height, String nickname) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.height = height;
		this.nickname = nickname;
	}
	
	public void showMemberInfo() {
		System.out.println(id + pw+ name + age +height + nickname);
	}

	public String getId() { return id; } 
	public void setId(String id) { this.id = id; } 
	public String getPw() { return pw; } 
	public void setPw(String pw) { this.pw = pw; } 
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; } 
	public int getAge() { return age; } 
	public void setAge(int age) { this.age = age; } 
	public double getHeight() { return height; } 
	public void setHeight(double height) { this.height = height; } 
	public String getNickname() { return nickname; } 
	public void setNickname(String nickname) { this.nickname = nickname; } 
}
