package com.student.controller;

import com.student.model.vo.Student;
import com.student.view.MainMenu;

public class StudentController {
	public static final int MAX_CNT = 6;
	Student[] students = new Student[5];
	
	public void mainMenu() {
		new MainMenu().mainMenu();
	}

	public void enroll() {
		Student s = new MainMenu().enrollView();
		if(students.length < MAX_CNT) {
			students[Student.getCount() + 1] = s;
		}
		else {
			System.out.println("더이상 등록할 수 없습니다.");
		}
	}
}
