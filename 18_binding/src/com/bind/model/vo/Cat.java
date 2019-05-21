package com.bind.model.vo;

public class Cat extends Animal {
	private boolean flexibility;
	
	public Cat(String model, int age, boolean flexibility) {
		super(model, age);
		this.flexibility = flexibility;
	}

	public void clean() {
		System.out.println("앞발 낼름");
	}
}
