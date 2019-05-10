package com.kh.oop.controller;

import java.util.Date;

import com.kh.oop.model.vo.Employee;

public class ObjectController {
	public void constructorTest() {
//		Employee e = new Employee(); //when public Employee()
		Employee e = Employee.getEmployee(); //when private Employee()
		e.printEmployee();
		
		Employee e1 = new Employee("홍길동", "전산부", 
				100, "개발자", 1, new Date());
		
		e1.printEmployee();
	}
}
