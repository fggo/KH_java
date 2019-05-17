package com.more.model.vo;

public class Character {
	private String name;
	private int level;
	private int attack;
	private int defence;
	private int exp;
	private Item item;
	
	public Character() {}

	public Character(String name, int level, int attack, int defence, int exp, Item item) {
		super();
		this.name = name;
		this.level = level;
		this.attack = attack;
		this.defence = defence;
		this.exp = exp;
		this.item = item;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getLevel() { return level; }
	public void setLevel(int level) { this.level = level; }
	public int getAttack() { return attack; }
	public void setAttack(int attack) { this.attack = attack; }
	public int getDefence() { return defence; }
	public void setDefence(int defence) { this.defence = defence; }
	public int getExp() { return exp; }
	public void setExp(int exp) { this.exp = exp; }
	public Item getItem() { return item; }
	public void setItem(Item item) { this.item = item; }
}
