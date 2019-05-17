package com.oop.model.vo;

public class Animal {
	private String category;
	private String name;

	public Animal() {}
	public Animal(String category, String name) {
		super();
		this.category = category;
		this.name = name;
	}
	
	public void bark() {
		System.out.println("Â¢´Ù.");
	}
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
