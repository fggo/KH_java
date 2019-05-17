package com.inter.model.vo;

import com.inter.model.inter.PrintDriver;

public class SamsongPrint implements PrintDriver{
	private String model;
	private String name;

	public SamsongPrint() {}
	public SamsongPrint(String model, String name) {
		super();
		this.model = model;
		this.name = name;
	}

	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public void printInfo() {
	}

	@Override
	public String printDriver() {
		return null;
	}
}
