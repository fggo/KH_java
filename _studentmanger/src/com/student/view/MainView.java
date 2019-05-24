package com.student.view;

import java.util.List;
import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.vo.Student;

public class MainView {
	StudentController controller;

	public void mainView(StudentController controller) {
		this.controller = controller;
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while(true) {
			System.out.println("=== 학생관리 프로그램 ===");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생조회");
			System.out.println("0. 종료");
			System.out.print("입력: ");
			choice = sc.nextInt();

			//선택한 메뉴로 이동하기!
			switch(choice) {
				case 1: controller.enrollStudent(); break;
				case 2: controller.updateStudent(); break;
				case 3: controller.searchStudent(); break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					controller.saveData();
					return;
			}
		}
	}
	
	public Student enrollStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 학생등록 화면 ===");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("성적 : ");
		int grade = sc.nextInt(); 
		System.out.print("반 : ");
		int room = sc.nextInt();
		System.out.print("번호 : ");
		int number = sc.nextInt(); sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();

		return new Student(name, grade, room, number, address);
	}
	
	public String searchInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 학생수정 ===");
		System.out.print("수정할 학생이름: ");
		return sc.nextLine();
	}
	
	public int searchInput(List list) {
		//수정할 학생 이름 입력 받아서, index return
		
		return -1;
	}
	
	public void searchView(List list) {
		for(Object o : list) {
			if(o instanceof Student) {
				Student s =(Student)o;
				System.out.println(s);
			}
		}
	}

	
	
}
