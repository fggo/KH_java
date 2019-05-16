package com.more.model.vo;

public class Dog extends Animal{

	public Dog(String category, String name) {
		super(category, name);
	}

	@Override
	public void bark() {
		System.out.println("港港 港");
	}

	public void action() {
		System.out.println("部府如甸扁 如甸如甸");
	}
}
