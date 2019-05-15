package com.method2.model.vo;

import com.method2.main.Main;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String addr;
	private int age;
	private String phone;
	
	public String getClientInfo() {
		System.out.print("이름 : ");
		name = Main.CONSOLE.nextLine();
		System.out.print("나이 : ");
		age = Main.CONSOLE.nextInt(); Main.CONSOLE.nextLine();
		System.out.print("전화 : ");
		phone = Main.CONSOLE.nextLine();
		
		String s = name +"," + age + "," + phone;

		return s;
	}
	
	public void insertMember() {
		System.out.print("아이디 : ");
		setId(Main.CONSOLE.nextLine());
		System.out.print("비번 : ");
		setPwd(Main.CONSOLE.nextLine());
		System.out.print("이름 : ");
		setName(Main.CONSOLE.nextLine());
		System.out.print("이메일 : ");
		setEmail(Main.CONSOLE.nextLine());
		System.out.print("주소 : ");
		setAddr(Main.CONSOLE.nextLine());
		
		Member member = this;

		member.printMember();
	}
	
	public void printMember() {
		System.out.println(id + pwd + name + email + addr);
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; } 
	public void setEmail(String email) { this.email = email; }
	public String getAddr() { return addr; }
	public void setAddr(String addr) { this.addr = addr; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
}
