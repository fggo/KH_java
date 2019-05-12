package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.vo.Student;

public class MainMenu {
	public static final Scanner CONSOLE = new Scanner(System.in);
	StudentController controller = new StudentController();
	
	public void mainMenu(){
		int choice = -1;

		do{
			System.out.println("1.학생 등록");
			System.out.println("2.학생 조회");
			System.out.println("3.학생 수정");
			System.out.println("4.학생성적 입력");
			System.out.println("5.학생 삭제");
			System.out.println("0.프로그램 종료");
			System.out.print("입력: ");
			choice = CONSOLE.nextInt();
			switch(choice){
				case 1: controller.enroll(); break;
				case 2: controller.search(); break;
				case 3: controller.update(); break;
				case 4: controller.updateScore(); break;
				case 5: controller.delete(); break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}while(choice != 0);
	}
	
	public Student enrollView(){
		if (CONSOLE.hasNextLine())
			CONSOLE.nextLine();
		System.out.println("====학생등록 화면====");
		System.out.print("  학생이름 : ");
		String name=MainMenu.CONSOLE.nextLine();
		System.out.print("  학년(1~3): ");
		int year=MainMenu.CONSOLE.nextInt();
		System.out.print("  번호 : ");
		int number=MainMenu.CONSOLE.nextInt();
		System.out.print("  성적(평균 1~100) : ");
		double score =MainMenu.CONSOLE.nextDouble();

		Student s = new Student(number, name, year, score);
		return s;
	}
}