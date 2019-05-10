package com.kh.oop.controller;

import com.kh.oop.model.vo.Person;
import com.kh.oop.model.vo.Car;

public class ObjectController {
	public void accessTest() {
		//1. static 공용으로 사용가능하게 변수를 공개하는것
		//	저장공간이 heap이 아닌 static 영역에 저장됨
		//	프로그램 시작과 동시에 저장공간이 생성됨.
		System.out.println(new Person().hashCode());
		new Person().printPerson(); //0x222

		Person p1 = new Person(); //0x123
		p1.printPerson();
		System.out.println(p1.hashCode());

		//접근제한자별 멤버변수 접근
//		p1.name; //ERROR if private
		//'public' static
		Person.name = "라라라";
		//static변수는 인스턴스변수처럼 접근 X
		//p1.name = "0바바";
		
		//static method
		Person.getName();

//		System.out.println(p1.gender);
		System.out.println(p1);
		Person.name = "가나다";
		System.out.println(Person.getName());
	}
	
	public void initialBlock() {
		Person p1 = new Person();
		p1.printPerson();
		Person p2 = new Person();
		p2.printPerson();
		p1.printPerson();
	}
}