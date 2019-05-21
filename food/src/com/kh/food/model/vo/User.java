package com.kh.food.model.vo;

import com.kh.food.view.MainMenu;

public class User {
	private String username;
	private String phone;
	private String email;
	private String address;
	
	public void mainMenu() {
		MainMenu.mainMenu();
	}

	public User(String username, String phone, String email, String address) {
		super();
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public void showUserInfo() {
		System.out.println("이름 : " + username);
		System.out.print("전화: " + phone);
		System.out.println("이메일 : "  + email);
		System.out.println("주소 : " + address);
	}

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
}
