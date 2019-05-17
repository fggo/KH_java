package com.inheritance.main;

import com.inheritance.vo.model.Employee;
import com.inheritance.vo.model.Person;
import com.inheritance.vo.model.Student;
import com.inheritance.vo.model.Teacher;
import com.more.contoller.MoreController;

public class Main {
	public static void main(String[] args) {
		Person[] persons = new Person[4];

		persons[0] = new Employee("홍길동", 22, 'M', "서울", "개발팀", 500);
		persons[1] = new Student("바바", 11, 'M', "부산", 2, 'B');
		persons[2] = new Teacher("가가가", 10, 'F', "인천", "영어", 7);
		persons[3] = new Person("사람", 13, 'F', "광주");

		System.out.println(persons[0]);
		

		new MoreController().createChara();
	}
}
