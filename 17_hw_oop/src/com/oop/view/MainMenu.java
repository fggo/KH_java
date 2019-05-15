package com.oop.view;

import java.util.Scanner;

import com.oop.model.dto.Employee.Employee;

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);

	public static void mainMenu(){
		int choice = 0;
		
		do {
			System.out.println("******* 사원 정보 관리 프로그램 ************");
			System.out.println("1. 새 사원 정보 입력");
			System.out.println("2. 사원 정보 수정");
			System.out.println("3. 사원 정보 삭제");
			System.out.println("4. 사원정보 출력");
			System.out.println("9. 끝내기");
			choice = CONSOLE.nextInt();
			
			switch(choice) {
				case 1: Employee.empInput(); break;
				case 2: Employee.modify(); break;
				case 3: Employee.delete(); break;
				case 4: Employee.empOutput(); break;
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("메뉴번호를 잘못 입력 하셨습니다.");
			}
	//		1.입력  => empInput() 메소드 실행
	//		2. 사원 정보 수정 => 부메뉴 나타남
	//		3. 사원 정보 삭제
	//		4. 사원정보 출력 =>  empOutput() 메소드 실행
	//		9. 끝내기
		} while(choice!= 9);
	}


	public static Employee modifyMenu(Employee e){
		System.out.println("**** 사원 정보 수정 메뉴 *****");
		System.out.println("1. 이름 변경 => setEmpName()");
		System.out.println("2. 급여 변경 => setSalary()");
		System.out.println("3. 부서 변경 => setDept()");
		System.out.println("4. 직급 변경 => setJob()");
		System.out.println("5. 이전 메뉴로 이동 ");
		int choice = CONSOLE.nextInt(); CONSOLE.nextLine();
		switch(choice) {
			case 1: System.out.print("이름: ");
				e.setEmpName(CONSOLE.nextLine()); break;
			case 2: System.out.print("급여: ");
				e.setSalary(CONSOLE.nextInt()); CONSOLE.nextLine(); break;
			case 3: System.out.print("부서: ");
				e.setDept(CONSOLE.nextLine()); break;
			case 4: System.out.print("직급: ");
				e.setJob(CONSOLE.nextLine()); break;
			case 5: System.out.print("이전 메뉴로 이동 ");
				e.setEmpName(CONSOLE.nextLine()); break;
			default:
				System.out.println("잘못된 메뉴입력 입니다.");
				break;
		}
		return e;
	}
	
}
