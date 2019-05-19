package com.kh.lotto.view;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;

import com.kh.lotto.controller.UserController;
import com.kh.lotto.main.Main;
import com.kh.lotto.model.vo.User;

interface INPUT_SELECT{
	int INPUT=1, MODIFY=2, DELETE=3, SEARCH=4, SEARCHALL=5, EXIT=0;
}

interface USER_GRADE{
	char A='A', B='B', C='C', D='D', F='F';
}

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);
	static UserController controller = Main.getController();

	public static void mainMenu() {
		int choice = 0;
		do {
			System.out.println("===== 회원 정보관리 프로그램 =====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 수정");
			System.out.println("3. 회원 탈퇴");
			System.out.println("4. 회원 조회");
			System.out.println("5. 회원 전체조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴선택 : ");

			choice = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(choice) {
				case INPUT_SELECT.INPUT: controller.input(); break;
				case INPUT_SELECT.MODIFY: controller.modify(); break;
				case INPUT_SELECT.DELETE: controller.delete(); break;
				case INPUT_SELECT.SEARCH: controller.search(); break;
				case INPUT_SELECT.SEARCHALL: controller.searchAll(); break;
				case INPUT_SELECT.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}while(choice !=9);
	}
	
	public static User inputView() {
		System.out.println("===== 회원 가입 =====");

		//username
		System.out.print("아이디 : ");
		String username = CONSOLE.nextLine();

		//password
		System.out.print("비밀번호 : ");
		String password = CONSOLE.nextLine();

		//grade
		char grade = USER_GRADE.F;

		//date
		LocalDateTime createdDate = LocalDateTime.now();

		//accountNumber
		System.out.print("계좌번호 : ");
		String accountNumber = CONSOLE.nextLine();
		
		//userPoint userMoney
		int userPoint = 0;
		int userMoney = 0;

		//gambleRecord
		HashSet<String> gambleRecord = new HashSet<String>();
		
		User user = new User(username, password, grade, createdDate, accountNumber, userPoint, userMoney, gambleRecord);
		return user;
	}
	
	public static String searchView() {
		//username
		System.out.println("===== 회원 조회 =====");
		System.out.print("조회할 사용자 아이디 : ");
		String username = CONSOLE.nextLine();
		return username;
	}

	public static String deleteView() {
		//username
		System.out.println("===== 회원 삭제 =====");
		System.out.print("삭제할 사용자 아이디 : ");
		String username = CONSOLE.nextLine();
		return username;
	}
	
	public static String modifyView() {
		//username
		System.out.println("===== 회원 수정 =====");
		System.out.print("수정할 사용자 아이디 : ");
		String username = CONSOLE.nextLine();
		
		return username;
	}
}
