package com.method2.main;

import java.util.Scanner;

import com.method2.controller.MethodTest;
import com.method2.controller.StudentController;
import com.method2.model.vo.Member;

public class Main {
	public final static Scanner CONSOLE = new Scanner(System.in);

	public static void main(String[] args) {
		new MethodTest().test1("Hello ", "World!");
		new MethodTest().test2(10, 20);
		new MethodTest().test3('\u0000');
		new MethodTest().test3('A');

		Member member = new Member();
		member.getClientInfo();
		
		StudentController controller = new StudentController();
		controller.insertStudent("ȫ�浿", 3, 99.22, 98.22, 87.222);
	}
}
