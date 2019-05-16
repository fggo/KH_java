package com.kh.lotto.view;

import java.util.Scanner;

import com.kh.lotto.controller.UserController;
import com.kh.lotto.model.vo.User;

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);
	static UserController controller = new UserController();
	
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
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case 1: controller.input(); break;
				case 2: controller.update(); break;
				case 3: controller.delete(); break;
				case 4: controller.search(); break;
				case 5: controller.searchAll(); break;
				case 0: System.out.println("프로그램을 종료합니다.");
					return;
			}
		}while(choice !=9);
	}
	
	public static User inputView() {
		System.out.println("===== 회원 추가 프로그램 =====");
		System.out.print("아이디 : ");
		String username = CONSOLE.nextLine();
		System.out.print("비밀번호 : ");
		String password = CONSOLE.nextLine();
		System.out.print("계좌번호 : ");
		String accountNumber = CONSOLE.nextLine();
		
		User user = new User(username, password, accountNumber);
		return user;
	}
	
	
}
