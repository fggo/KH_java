package com.student.controller;

import com.student.model.vo.Student;
import com.student.view.MainMenu;

public class StudentController {
	private static final int MAX_CNT = 5;
	private Student[] students = new Student[MAX_CNT];
	
	public void mainMenu() {
		new MainMenu().mainMenu();
	}
	
	public void enroll() {
		if(Student.getCount() < MAX_CNT) {
			Student s = new MainMenu().enrollView();
			students[Student.getCount()-1] = s;
		}
		else {
			System.out.println("  더이상  등록 할 수 없습니다.");
		}
	}

	public void update() {
		if(Student.getCount() == 0) {
			System.out.println("  등록된 학생이 없습니다.");
			return;
		}
		System.out.print("  수정할 학생이름 : "); readNewLine();
		String name=MainMenu.CONSOLE.nextLine();
		int idx = search(name);
		if (idx != -1) {
			System.out.println("====학생수정 화면====");
			System.out.print("  학년(1~3): ");
			int year=MainMenu.CONSOLE.nextInt();
			System.out.print("  번호 : ");
			int number=MainMenu.CONSOLE.nextInt();
			System.out.print("  성적(평균) : ");
			double score =MainMenu.CONSOLE.nextDouble();

			Student s = new Student(number, name, year, score);
			students[idx] = s;
		}
		else {
			System.out.println("  존재하지 않는 학생입니다.");
		}
	}
	
	public void search() {
		if(Student.getCount() == 0) {
			System.out.println("  등록된 학생이 없습니다.");
			return;
		}
		System.out.print("  조회할 학생이름 : "); readNewLine();
		String name=MainMenu.CONSOLE.nextLine();
		int idx = search(name);
		if(idx != -1) {
			System.out.println("  " + name + "학생을 " + (idx+1) + " 번째 자리에서 찾았습니다.");
			students[idx].printStudent();
		}
		else {
			System.out.println("  존재하지 않는 학생입니다.");
		}
	}

	public void updateScore() {
		if(Student.getCount() == 0) {
			System.out.println("  등록된 학생이 없습니다.");
			return;
		}
		System.out.print("  성적 수정 할 학생이름 : "); readNewLine();
		String name=MainMenu.CONSOLE.nextLine();
		int idx = search(name);
		if (idx != -1) {
			students[idx].printStudent();
			System.out.print("  성적 입력(0~100): ");
			double score = MainMenu.CONSOLE.nextDouble();
			students[idx].setScore(score);
			System.out.println("  " + students[idx].getGrade() + " 입니다.");
		}
		else {
			System.out.println("  존재하지 않는 학생입니다.");
		}
	}

	public void delete() {
		if(Student.getCount() == 0) {
			System.out.println("  등록된 학생이 없습니다.");
			return;
		}
		System.out.print("  삭제할 학생이름 : "); readNewLine();
		String name=MainMenu.CONSOLE.nextLine();
		int idx = search(name);
		if (idx != -1) {
			students[idx] = null;
			students[Student.getCount() -1] = null;
			for(int i=idx; i<Student.getCount()-1; i++) {
				students[i] = students[i+1];
			}
			Student.setCount(Student.getCount() - 1);
		}
		else {
			System.out.println("  존재하지 않는 학생입니다.");
		}
	}
	
	private int search(String name) {
		for(int i =0; i<Student.getCount(); i++) {
			if(students[i].getName().equals(name))
				return i;
		}
		return -1;
	}
	
	//remove new line character from buffer
	private void readNewLine() {
		if(MainMenu.CONSOLE.hasNextLine())
			MainMenu.CONSOLE.nextLine();
	}
}