package com.kh.oop.controller;

import com.kh.oop.model.vo.Person;
import com.kh.oop.model.vo.Car;

public class ObjectController {

	public void accessTest() {
		new Person().printPerson();
		new Car();
		Person p1=new Person();
		p1.printPerson();
//		접근제한자별 멤버변수 접근
//		p1.name;//private 일때는 접근불가
//		System.out.println(p1.age);

//		public으로 선언되어서 접근이 가능
//		System.out.println(p1.age);
		p1.printPerson();
//		p1.gender;//default로 선언되서 불가능
//		default는 같은패키지내에서만 접근이 가능
		p1.setName("댕댕이");
		System.out.println(p1.getName());
		System.out.println(p1.getMemberId());
//		p1.memberId="p002";
	}
}
