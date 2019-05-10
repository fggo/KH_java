package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.vo.Student;

public class MainMenu {
	public static final Scanner CONSOLE = new Scanner(System.in);
	StudentController controller = new StudentController();

	public void mainMenu() {
		int choice = 0;
		do {
			System.out.println("===학생관리 프로그램===");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생 조회");
			System.out.println("4. 학생 성적입력");
			System.out.println("5. 학생 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.print("입력: ");
			choice = CONSOLE.nextInt();

			switch(choice) {
				case 1: controller.enroll(); break;
				case 2: controller.update(); break;
				case 3: controller.search(); break;
				case 4: controller.inputSungjuk(); break;
				case 5: controller.delete(); break;
				case 6: System.out.println("프로그램을 종료합니다...");
					System.exit(0);
				default: System.out.println("잘못된 메뉴 번호 입니다...");
			}
		}while(choice!= 6);
	}
	
	public Student enrollView() {
		if(CONSOLE.hasNextLine())
			CONSOLE.nextLine();

		System.out.println("===== 학생등록 화면 =====");
		System.out.print("이름: ");
		String name = CONSOLE.nextLine();
		System.out.print("학점: ");
		char grade = CONSOLE.next().charAt(0);
		System.out.print("번호: ");
		int no = CONSOLE.nextInt();
		System.out.print("점수: ");
		double sungjuk = CONSOLE.nextDouble();
		System.out.print("학년: ");
		int year = CONSOLE.nextInt();
		
		Student s = new Student(name, grade, no, sungjuk, year);

		return s;
	}
	

}
