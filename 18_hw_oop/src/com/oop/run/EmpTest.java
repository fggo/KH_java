package com.oop.run;

import com.oop.controller.EmployeeController;

public class EmpTest {
	private static EmployeeController controller = new EmployeeController();
	
	public static EmployeeController getController() {
		return controller;
	}

	public static void main(String[] args) {
		getController().mainMenu();
	}
}
