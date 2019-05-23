package com.student.main;

import com.student.controller.StudentController;

public class Main {
	private static StudentController controller = new StudentController();
	public static StudentController getController() {
		return controller;
		
	}
	public static void main(String[] args) {
		Main.getController().mainMenu();
		
	}
}
