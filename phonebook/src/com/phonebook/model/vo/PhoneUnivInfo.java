package com.phonebook.model.vo;

public class PhoneUnivInfo extends PhoneInfo{
	private String major;
	private int year;
	
	public PhoneUnivInfo(String name, String phone, String major, int year) {
		super(name, phone);
		this.major = major;
		this.year = year;
	}
	
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("  major : " + major);
		System.out.println("  year : " + year);
	}

	//getter setter
	public String getMajor() { return major; }
	public void setMajor(String major) { this.major = major; }
	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
}
