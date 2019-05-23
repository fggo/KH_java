package com.student.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.student.model.vo.Student;
import com.student.view.MainMenu;

public class StudentController {
	/*
	 * 1.등록,수정,조회,종료
	 * 학생(학년, 반 ,번호, 주소)
	 * Student[5]
	 * students.stu 파일 저장 /
	 * 구종시 불러오기.종료시 저장하기
	 */
	
	private Student[] students = new Student[5];
	private File file = new File("Student.stu");
	private int studentCount;
	
	private MainMenu menu;

	public void mainMenu() {
		if(menu == null)
			menu = new MainMenu();

		readFromFile();
		MainMenu.mainMenu();
	}

	public void writeToFile() {
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(students);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFromFile() {
		if(file.exists() == false) 
			return;
	
		try (ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(file))){

			students = (Student[])ois.readObject();
			for(int i =0; i<students.length; i++)
				if(students[i] == null) {
					Student.setCount(i);
					break;
				}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void enroll() {
		Student s = MainMenu.enrollView();
		if(Student.getCount() <= students.length)
			students[Student.getCount() - 1] = s;
	}
	
	public void modify() {
		
	}
	public void search() {
		if(Student.getCount() <1) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		String name = MainMenu.searchView();
		for(int i =0; i<Student.getCount(); i++) {
			if(students[i].getName().equals(name))
				students[i].showStudentInfo();
		}

	}
	
	
	
	public void searchAll() {
		if(Student.getCount() <1) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		for(int i =0; i<Student.getCount(); i++) {
			students[i].showStudentInfo();
		}
	}

	public Student[] getStudents() { return students; }
	public void setStudents(Student[] students) { this.students = students; }
}
