package com.kh.lotto.view;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import com.kh.lotto.controller.UserController;
import com.kh.lotto.main.Main;

interface INPUT_SELECT{
	int SIGNUP=1, SIGNIN=2, MODIFY=3, DELETE=4, SEARCH=5, SEARCHALL=6, EXIT=0;
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
			System.out.println("2. 회원 로그인");
			System.out.println("3. 회원 수정");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 회원 조회");
			System.out.println("6. 회원 전체조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴선택 : ");

			choice = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(choice) {
				case INPUT_SELECT.SIGNUP: controller.signUp(); break;
				case INPUT_SELECT.SIGNIN: controller.signIn(); break;
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
	
	public static Map<String, Object> signUpView() {
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
		
		Map<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("username", username);
		hmap.put("password", password);
		hmap.put("grade", Character.valueOf(grade));
		hmap.put("createdDate", createdDate);
		hmap.put("accountNumber", accountNumber);
		hmap.put("userPoint", Integer.valueOf(userPoint));
		hmap.put("userMoney", Integer.valueOf(userMoney));
		hmap.put("gambleRecord", gambleRecord);
		
		return hmap;
	}
	
	public static Map<String, String> signInView() {
		System.out.println("===== 회원 로그인 =====");
		//username
		System.out.print("로그인 사용자 아이디 : ");
		String username = CONSOLE.nextLine();
		//password
		System.out.print("로그인 사용자 비밀번호 : ");
		String password = CONSOLE.nextLine();

		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);

		return map;
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
