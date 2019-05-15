package com.oop.view;

import java.util.Scanner;

import com.oop.model.dto.Employee;

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
				case 1: break;
				case 2: break;
				case 3:
					break;
				case 4:
					break;
				case 9:
					break;
				default:
					System.out.println("메뉴번호를 잘못 입력 하셨습니다.");
					break;
			}
	//		1.입력  => empInput() 메소드 실행
	//		2. 사원 정보 수정 => 부메뉴 나타남
	//		3. 사원 정보 삭제
	//		4. 사원정보 출력 =>  empOutput() 메소드 실행
	//		9. 끝내기
		} while(choice!= 9);
	}


	public static void modifyMenu(Employee e){
//			Employee emp = new Employee();
		//setter 이용해서 키보드로 입력받은 값 객체 필드에 기록
//			return emp;
	}

//	**** 사원 정보 수정 메뉴 *****
//		1. 이름 변경 => setEmpName()
//		2. 급여 변경 => setSalary()
//		3. 부서 변경 => setDept()
//		4. 직급 변경 => setJob()
//		5. 이전 메뉴로 이동 => return 처리할 것
}
