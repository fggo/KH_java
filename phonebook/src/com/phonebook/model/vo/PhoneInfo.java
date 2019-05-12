package com.phonebook.model.vo;

public class PhoneInfo{
	private String name;
	private String phoneNumber;
	private String birth;
	private static int curCnt = 0;
	
	{
		curCnt++;
	}
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name;
		phoneNumber = num;
		this.birth = birth;
	}
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
		this.birth = null;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
		if(birth != null)
			System.out.println("birth : " + birth);
	}
	
	//getter setter
	public String getName() { return name;}
	public void setName(String name) { this.name = name;}
	public String getPhoneNumber() { return phoneNumber;}
	public void setPhoneNumber(String phone) { this.phoneNumber = phone;}
	public String getBirth() { return birth;}
	public void setBirth(String birth) { this.birth = birth;}
	public static int getCurCnt() { return PhoneInfo.curCnt; }
	public static void setCurCnt(int cnt) { PhoneInfo.curCnt = cnt; }
}
