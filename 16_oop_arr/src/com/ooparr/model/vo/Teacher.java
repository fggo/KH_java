package com.ooparr.model.vo;

public class Teacher extends Person{
	private String major;
	private int expert;

	public Teacher() {}

	public Teacher(String name, int age, String addr, char gender,
			String major, int expert) {

		super(name, age, addr, gender);
		this.major = major;
		this.expert = expert;
	}

	public String getMajor() { return major; }
	public void setMajor(String major) { this.major = major; }
	public int getExpert() { return expert; }
	public void setExpert(int expert) { this.expert = expert; }

	@Override
	public String toString() {
		return "Teacher [expert=" + expert + ", major=" + major + ", getExpert()=" + getExpert() + ", getMajor()="
				+ getMajor() + ", getAddress()=" + getAddress() + ", getAge()=" + getAge() + ", getClass()="
				+ getClass() + ", getGender()=" + getGender() + ", getName()=" + getName() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
