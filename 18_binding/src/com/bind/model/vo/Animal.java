package com.bind.model.vo;

public class Animal {
	private String model;
	private int age;

	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String model, int age) {
		super();
		this.model = model;
		this.age = age;
	}
	
	public void action() {}
	public void clean() {}

	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}
