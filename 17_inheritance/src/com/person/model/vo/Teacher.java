package com.person.model.vo;

public class Teacher extends Person{
	private String subject;
	private int exp;

	public Teacher(String name, int age, char gender, String address, String subject, int exp) {
		super(name, age, gender, address);
		this.subject = subject;
		this.exp = exp;
	}

	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	public int getExp() { return exp; }
	public void setExp(int exp) { this.exp = exp; }
}
