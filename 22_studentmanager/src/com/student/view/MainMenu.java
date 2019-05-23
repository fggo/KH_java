package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.main.Main;
import com.student.model.vo.Student;

public class MainMenu {
	
	public final static Scanner CONSOLE = new Scanner(System.in);
	static StudentController controller = Main.getController();
	/*
	 * 1.등록,수정,조회,종료
	 * 학생(학년, 반 ,번호, 주소)
	 * Student[5]
	 * students.stu 파일 저장 /
	 * 구종시 불러오기.종료시 저장하기
	 */
	public static void mainMenu() {
		int choice = -1;

		do {
			System.out.println("=== 메인메뉴 ===");
			System.out.println("1.학생등록 ");
			System.out.println("2.학생수정 ");
			System.out.println("3.학생조회 ");
			System.out.println("4.학생전체 조회");
			System.out.println("0.프로그램 종료");
			System.out.print("메뉴 선택: ");
			choice= CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case 1: controller.enroll(); break;
				case 2: controller.modify(); break;
				case 3: controller.search(); break;
				case 4: controller.searchAll(); break;
				case 0:
					controller.writeToFile();
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		} while(choice != 0);
	}

	public static Student enrollView() {
		System.out.println("=== 학생 등록 ===");
		System.out.print("학생 이름: ");
		String name = CONSOLE.nextLine();
		System.out.print("학생 학년: ");
		int year = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("학생 반: ");
		int classRoom = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("학생 번호: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("학생 주소: ");
		String address = CONSOLE.nextLine();
		
		Student s = new Student(name, year, classRoom, num, address);
		return s;
	}

	public static Student modifyView() {
		System.out.println("=== 학생 수정 ===");
		System.out.print("학생 이름: ");
		String name = CONSOLE.nextLine();
		System.out.print("학생 학년: ");
		int year = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("학생 반: ");
		int classRoom = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("학생 번호: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("학생 주소: ");
		String address = CONSOLE.nextLine();
		
		Student s = new Student(name, year, classRoom, num, address);
		return s;
	}

	public static String searchView() {
		System.out.println("=== 조회할 학생  ===");
		System.out.print("학생 이름: ");
		String name = CONSOLE.nextLine();
		return name;
	}
}
