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
		System.out.print("아이디 : ");
		id = Main.CONSOLE.nextLine();
		System.out.print("비번 : ");
		pwd = Main.CONSOLE.nextLine();
		System.out.print("이름 : ");
		name = Main.CONSOLE.nextLine();
		System.out.print("이메일 : ");
		email = Main.CONSOLE.nextLine();
		System.out.print("주소 : ");
		addr = Main.CONSOLE.nextLine();
		System.out.print("나이 : ");
		age = Main.CONSOLE.nextInt(); Main.CONSOLE.nextLine();
		System.out.print("전화 : ");
		phone = Main.CONSOLE.nextLine();
		
		String s = id + "," + pwd+ "," + name +","+email
			+"," +addr + "," + age + "," + phone;
		return s;
	}
	
	public void insertMember() {
		System.out.print("아이디 : ");
		String id = Main.CONSOLE.nextLine();
		System.out.print("비번 : ");
		String pwd = Main.CONSOLE.nextLine();
		System.out.print("이름 : ");
		String name = Main.CONSOLE.nextLine();
		System.out.print("이메일 : ");
		String email = Main.CONSOLE.nextLine();
		System.out.print("주소 : ");
		String addr = Main.CONSOLE.nextLine();
		System.out.print("나이 : ");
		int age = Main.CONSOLE.nextInt(); Main.CONSOLE.nextLine();
		System.out.print("전화 : ");
		String phone = Main.CONSOLE.nextLine();

		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setEmail(email);
		member.setAddr(addr);
		member.setAge(age);
		member.setPhone(phone);
	}
	
	public void printMember() {
		System.out.println(id+ pwd+name+email+addr+age+phone);
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
