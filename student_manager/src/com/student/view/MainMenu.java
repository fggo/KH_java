package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;

public class MainMenu {
	private final static Scanner CONSOLE = new Scanner(System.in);
	StudentController controller = new StudentController();
	
	public void mainMenu() {
		System.out.println("1.학생등록" );
		System.out.println("2.학생수정" );
		System.out.println("3.학생조회" );
		System.out.println("4.학생성적입력" );
		System.out.println("5.학생삭제" );
		System.out.println("0.프로그램 종료");
		int choice = CONSOLE.nextInt(); 
		
		do {
			switch(choice) {
				case 1:
				case 2:
			}
		}while(choice != 0);
	}
	
}
