package com.inheritance.vo.model;

public class Teacher extends Person{
	private String subject;
	private int experience;

	public Teacher(String name, int age, char gender, String addr, String subject, int experience) {
		super(name, age, gender, addr);
		this.subject = subject;
		this.experience = experience;
	}

	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	public int getExperience() { return experience; }
	public void setExperience(int experience) { this.experience = experience; }
}
