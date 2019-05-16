package com.kh.lotto.view;

import com.kh.lotto.model.vo.User;
import java.util.Scanner;

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("********** 회원 정보관리 프로그램  **********");
		System.out.println("1. 회원 정보 입력  => clientInput() 메소드 실행 - 부메뉴 작성");
		System.out.println("2. 회원 정보 수정 => clientEdit() 메소드 실행 - 부메뉴 작성");
		System.out.println("3. 회원 정보 삭제 => clientDelete");
		System.out.println("4. 회원정보 출력 =>  clientOutput() 메소드 실행");
		System.out.println("0. 끝내기");
		
		int choice = 0;
		do {
			choice = CONSOLE.nextInt();
			if (CONSOLE.hasNextLine()) CONSOLE.nextLine();
			switch(choice) {
				case 1:
				case 2:
				case 3:
			}
		}while(choice !=9);
	}
	
	public static User inputView() {
		System.out.println("********** 회원 추가 프로그램 **********");
		System.out.println("1.아이디 : ");
		System.out.println("2.비밀번호 : ");
		System.out.println("3.계좌번호 : ");
		System.out.println("4.이메일 : ");
		return null;
	}
}
