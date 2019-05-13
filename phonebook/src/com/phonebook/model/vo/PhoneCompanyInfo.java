package com.phonebook.model.vo;

public class PhoneCompanyInfo extends PhoneInfo{

	private String company;
	
	public PhoneCompanyInfo(String name, String phone, String company) {
		super(name, phone);
		this.company = company;
	}
	
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("  company : " + company);
	}

	//getter setter
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }
}
