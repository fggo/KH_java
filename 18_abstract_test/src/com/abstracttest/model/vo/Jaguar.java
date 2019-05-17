package com.abstracttest.model.vo;

public class Jaguar extends Animal{
	private String paw;
	
	public String getPaw() { return paw; }
	public void setPaw(String paw) { this.paw = paw; }

	@Override
	public void printAnimal() {
		System.out.println("Àç±Ô¾î");
	}
}
