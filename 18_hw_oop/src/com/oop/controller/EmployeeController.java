package com.oop.controller;

import com.oop.model.dto.Employee.Employee;
import com.oop.view.MainMenu;

public class EmployeeController {
	private final static int MAX_CNT = 5;
	Employee[] employees =  new Employee[MAX_CNT];
	private MainMenu menu;
	
	
	public void mainMenu() {
		menu = new MainMenu();
		menu.mainMenu();
	}
	
	public void input() {
		
	}
	
	public void update() {
		
	}
	public void delete() {
		
	}
	
	public void searchAll() {
		
	}
	
	public void search() {
		
	}
	
	private int search(String name) {
		return -1;
	}
}
