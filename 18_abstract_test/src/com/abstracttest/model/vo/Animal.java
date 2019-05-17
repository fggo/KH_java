package com.abstracttest.model.vo;

public abstract class Animal {
	private String name;
	private String category;
	
	public Animal() {}

	public Animal(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public abstract void printAnimal();
//	public void printAnimal() {}
}
