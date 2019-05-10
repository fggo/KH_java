package com.student.controller;

import com.student.model.vo.Student;
import com.student.view.MainMenu;

public class StudentController {
	public static final int MAX_CNT = 5;
	Student[] students = new Student[MAX_CNT];
	
	public void mainMenu() {
		new MainMenu().mainMenu();
	}

	public void enroll() {
		Student s = new MainMenu().enrollView();
		if(Student.getCount() < MAX_CNT) {
			students[Student.getCount()-1] = s;
		}
		else {
			System.out.println("더이상 등록할 수 없습니다.");
		}
	}

	public void update() {
		int idx = -1;
		if (Student.getCount() >0) {
			removeNewLine();

			System.out.print("수정할 학생 이름: ");
			String name = MainMenu.CONSOLE.nextLine();
			idx = search(name);

			if(idx > -1) {
				students[idx].printStudent();
				System.out.println("===== 학생정보 수정 화면 =====");
				System.out.print("성적: ");
				char grade = MainMenu.CONSOLE.next().charAt(0);
				System.out.print("번호: ");
				int no = MainMenu.CONSOLE.nextInt();
				System.out.print("점수: ");
				double sungjuk = MainMenu.CONSOLE.nextDouble();
				System.out.print("학년: ");
				int year = MainMenu.CONSOLE.nextInt();
				
				students[idx] = new Student(name, grade, no, sungjuk, year);
			}
		}
		System.out.println("등록된 학생이 없습니다.");
	}

	public void search() {
		int idx = -1;
		if (Student.getCount() >0) {
			removeNewLine();

			System.out.print("찾으려는 학생 이름: ");
			String name = MainMenu.CONSOLE.nextLine();
			idx = search(name);
			if(idx != -1) {
				System.out.println("찾았습니다!");
				students[idx].printStudent();
				return;
			}
		}
		System.out.println("등록된 학생이 없습니다.");
	}
	
	public void inputSungjuk() {
		int idx = -1;
		double sungjuk = 0;
		if (Student.getCount() >0) {
			removeNewLine();

			System.out.print("성적 입력할 학생 이름: ");
			String name = MainMenu.CONSOLE.nextLine();
			idx = search(name);
			if(idx!= -1) {
				System.out.print("성적: ");
				sungjuk = MainMenu.CONSOLE.nextDouble();
				students[idx].setSungjuk(sungjuk);
				return;
			}
		}
		System.out.println("등록된 학생이 없습니다.");
	}

	public void delete() {
		if (Student.getCount() >0) {
			int idx = -1;
			removeNewLine();

			System.out.print("찾으려는 학생 이름: ");
			String name = MainMenu.CONSOLE.nextLine();
			idx = search(name);
			if(idx != -1) {
				students[idx] = null;
				for(int i =idx; i<Student.getCount()-1; i++)
					students[i] = students[i+1];
				Student.minusCount();
				System.out.println("삭제 완료하였습니다. "
						+ "남은학생수: " + Student.getCount());
				return;
			}
		}
		System.out.println("등록된 학생이 없습니다.");
	}
		
	private int search(String name) {
		if (Student.getCount() >0) {
			for(int i =0; i<Student.getCount(); i++) {
				if(students[i].getName().equals(name)) {
					return i;
				}
			}
		}
		return -1;
	}

	private void removeNewLine() {
		if(MainMenu.CONSOLE.hasNextLine())
			MainMenu.CONSOLE.nextLine();
	}
}
