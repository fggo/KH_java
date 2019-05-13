package com.phonebook.model.vo;

public class PhoneInfo{
	private String name;
	private String phoneNumber;
	private static int curCnt = 0;
	
	{
		curCnt++;
	}
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name;
		phoneNumber = num;
	}
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
	}
	
	//getter setter
	public String getName() { return name;}
	public void setName(String name) { this.name = name;}
	public String getPhoneNumber() { return phoneNumber;}
	public void setPhoneNumber(String phone) { this.phoneNumber = phone;}
	public static int getCurCnt() { return PhoneInfo.curCnt; }
	public static void setCurCnt(int cnt) { PhoneInfo.curCnt = cnt; }
}
