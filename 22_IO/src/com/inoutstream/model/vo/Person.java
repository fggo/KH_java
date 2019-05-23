package com.inoutstream.model.vo;

import java.io.Serializable;

public class Person implements Serializable {
	//객체 마다 고유 id로 식별: 충돌 피함
	private static final long serialVersionUID = 1833572985299902461L;

	private String name;
	private int age;
	private double height;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
	}

	public void showPersonInfo() {
		System.out.println(name + age + height);
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public double getHeight() { return height; }
	public void setHeight(double height) { this.height = height; }
}
