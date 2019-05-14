package com.method.model.vo;

public class Member {

//	이름 이메일 주소 나이 키 몸무게
	private String name;
	private String email;
	private String address;
	private int age;
	private double height;
	private double weight;

	public Member() {}

	public Member(String name, String email, String address,
			int age, double height, double weight) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.height = height;
		this.weight = weight;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public double getHeight() { return height; }
	public void setHeight(double height) { this.height = height; }
	public double getWeight() { return weight; }
	public void setWeight(double weight) { this.weight = weight; }
	
	public void printMember() {
		System.out.println(name+ email+ address+ age+ 
				height+ weight);
	}
}
