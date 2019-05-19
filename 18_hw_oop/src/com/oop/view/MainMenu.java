package com.oop.view;

import java.util.Scanner;
import com.oop.model.dto.Employee.Employee;

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);
	static Employee e = Employee.createEmployeeInst();

	public static void mainMenu() {
		int choice = 0;
		do {
			System.out.println("1.사원 입력");
			System.out.println("2.사원 수정");
			System.out.println("3.사원 삭제");
			System.out.println("4.사원 출력");
			System.out.println("9.프로그램 종료");
			System.out.print("메뉴선택: ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case 1: e.empInput(); break;
				case 2: Employee.modifyMenu(e); break;
				case 3:	break;
				case 4: e.empOutput(); break;
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못된 메뉴입력 입니다."); break;
			}
		} while(choice != 9);
	}
	
	public static Employee inputView() {
		System.out.println("===== 사원 입력 =====");
		System.out.print("사원 번호: ");
		int empNo = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("사원 이름: ");
		String empName = CONSOLE.nextLine();
		System.out.print("사원 부서: ");
		String dept = CONSOLE.nextLine();
		System.out.print("사원 직책: ");
		String job = CONSOLE.nextLine();
		System.out.print("사원 나이: ");
		int age = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("사원 성별: ");
		char gender = CONSOLE.nextLine().charAt(0);
		System.out.print("사원 급여: ");
		int salary = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("사원 보너스: ");
		int bonusPoint = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("사원 전화: ");
		String phone = CONSOLE.nextLine();
		System.out.print("사원 주소: ");
		String address = CONSOLE.nextLine();

		return new Employee(empNo, empName, dept, job, age, gender, salary, bonusPoint, phone, address);
	}

	public static void modifyView() {
		System.out.println("**** 사원 정보 수정 메뉴 *****");
		System.out.println("1. 이름 변경");
		System.out.println("2. 급여 변경");
		System.out.println("3. 부서 변경");
		System.out.println("4. 직급 변경");
		System.out.println("5. 이전 메뉴로 이동");
		System.out.print("메뉴선택: ");

	}
}
