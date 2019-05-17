package com.oop.model.vo;

public class Shield extends Item {
	private String name;
	private int defence;

	public Shield() {}
	
	public Shield(String name, int defence) {
		super();
		this.name = name;
		this.defence = defence;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getDefence() { return defence; }
	public void setDefence(int defence) { this.defence = defence; }
}
