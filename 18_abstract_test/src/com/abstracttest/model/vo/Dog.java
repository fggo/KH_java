package com.abstracttest.model.vo;

public class Dog extends Animal {
	private String tul;
	private double weight;

	public String getTul() { return tul; }
	public void setTul(String tul) { this.tul = tul; }
	public double getWeight() { return weight; }
	public void setWeight(double weight) { this.weight = weight; }

	public Dog() {}

	public Dog(String name, String category, String tul, double weight) {
		super(name, category);
		this.tul = tul;
		this.weight = weight;
	}

	@Override
	public void printAnimal() {
		System.out.println("°­¾ÆÁö");
	}
}
