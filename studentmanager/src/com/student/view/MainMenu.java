package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.main.Main;
import com.student.model.vo.Student;

public class MainMenu {
	public static final Scanner CONSOLE = new Scanner(System.in);
	StudentController controller = Main.getController();

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
			choice = CONSOLE.nextInt(); readNewLine();
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
	
	public boolean delete(Student[] students) {
		System.out.print("  삭제할 학생이름 : ");
		String name = CONSOLE.nextLine();

		if(Student.getCount() > 0) {
			int idx = search(name);
			if (idx != -1) {
				students[idx] = null;
				for(int i=idx ; i<Student.getCount()-1; i++)
					students[i] = students[i+1];
				students[Student.getCount() -1] = null;
				Student.deleteCount();
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("등록된 학생이 없습니다.");
			return false;
		}
	}

	private int search(String name) {
		for(int i =0; i<Student.getCount(); i++) {
			if(name.equals(Main.getController().getStudents()[i].getName()))
				return i;
		}
		return -1;
	}
	
	private void readNewLine() {
		if(CONSOLE.hasNextLine())
			CONSOLE.nextLine();
	}
}