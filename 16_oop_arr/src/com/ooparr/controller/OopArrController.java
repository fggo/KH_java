package com.ooparr.controller;

import com.ooparr.model.vo.Person;
import com.ooparr.model.vo.Student;
import com.ooparr.model.vo.Teacher;

public class OopArrController extends Person{
	public void basicPersonTest() {
		Person[] persons = new Person[10];

		for(int i =0; i<persons.length; i++) {
			persons[i] = new Person();
			persons[i].setName("¹Ù¹Ù" + (i+1));
		}
		
		Person p = new Person();
		Student s = new Student();
		Teacher t = new Teacher();

//		System.out.println(p.plus(10, 20));
//		System.out.println(s.plus(10, 20));
		
		System.out.println(t);
		
		//protected: accessible by child(inheriting) classes
		address = "aa";
	
//		ArrayList list = new ArrayList();
//		list.equals(list);
		System.out.println(p);
		System.out.println(s);
		System.out.println(t);
	}
}
