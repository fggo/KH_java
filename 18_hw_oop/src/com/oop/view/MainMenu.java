package com.oop.view;

import java.util.Scanner;

import com.oop.controller.EmployeeController;
import com.oop.model.dto.Employee.Employee;
import com.oop.run.EmpTest;

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);
	static EmployeeController controller = EmpTest.getController();

	public static void mainMenu() {
		int choice = 0;
		do {
			System.out.println("1.사원 입력");
			System.out.println("2.사원 수정");
			System.out.println("3.사원 삭제");
			System.out.println("4.사원 출력");
			System.out.println("9.프로그램 종료");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case 1: 
				case 2:
				case 3:
				case 4:
				case 9: System.out.println("프로그램을 종료합니다."); return;
			}
		} while(choice != 9);
	}
	
	public static Employee inputView() {
		return null;
	}
}
