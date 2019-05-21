package com.kh.food.view;

import java.util.Scanner;

import com.kh.food.model.vo.User;

interface INIT_MENU {
	int SIGNUP=1, SIGNIN=2, EXIT=0;
}

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);


	public static void mainMenu() {
		System.out.println("=== 메뉴 선택 ===");
		System.out.println("1. 회원 가입");
		System.out.println("2. 로그인");
		System.out.println("0. 메뉴 종료.");
		int choice = -1;
		do {
			switch(choice) {
				case INIT_MENU.SIGNUP:
					break;
				case INIT_MENU.SIGNIN:
					break;
				case INIT_MENU.EXIT:
					return;
			}
		}while(choice != 0);
	}
	
	public static User signUpView() {
		System.out.println("회원 이름 : ");
		String username = CONSOLE.nextLine();
		System.out.println("회원 전화 : ");
		String phone = CONSOLE.nextLine();
		System.out.print("회원 이메일 : " );
		String email = CONSOLE.nextLine();
		System.out.print("회원 주소 : ");
		String address = CONSOLE.nextLine();
		
		User user = new User(username, phone, email, address);
		return user;
	}

	public static String signInView() {
		System.out.print("핸드폰 번호 : ");
		String phone = CONSOLE.nextLine();

		return phone;
	}
}
