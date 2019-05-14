package com.method.controller;

import java.util.Scanner;

import com.method.model.vo.Member;

public class MemberController {
	public final static Scanner CONSOLE = new Scanner(System.in);

	public Member enrollMember() {
		Member m = new Member();
		m.setName("바바");
		m.setEmail("aaa@a.com");
		m.setAddress("서울");
		m.setAge(99);
		m.setHeight(999.99);
		m.setWeight(1.113);
		return m;
	}
	
	public void updateMember(Member m) {
		System.out.println("===== 멤버 정보 수정 =====");
		System.out.print("이름 : " );
		String name = CONSOLE.nextLine();
		System.out.print("이메일 : ");
		String email = CONSOLE.nextLine();
		System.out.print("주소 : ");
		String address = CONSOLE.nextLine();
		System.out.print("나이 : ");
		int age = CONSOLE.nextInt();
		System.out.print("키 : ");
		double height = CONSOLE.nextDouble();
		System.out.print("몸무게 : ");
		double weight = CONSOLE.nextDouble();
		
		m.setName(name);
		m.setEmail(email);
		m.setAddress(address);
		m.setAge(age);
		m.setHeight(height);
		m.setWeight(weight);
	}
	
	//overloading
	public void updateMember(int n) {

	}
}
