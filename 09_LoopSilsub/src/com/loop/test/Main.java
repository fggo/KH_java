package com.loop.test;

import java.util.Scanner;

import com.loop.ForWhile;

public class Main {
	public static final Scanner CONSOLE = new Scanner(System.in);
	
	public static void main(String[] args) {
		int no = 0;
		ForWhile fw = new ForWhile();
		
		do {
			System.out.println("===== 반복문 loop 실습문제 =====");
			System.out.println("1. 별과 숫자 출력하기");
			System.out.println("2. 별 출력하기");
			System.out.println("3. 햄버거 메뉴 고르기");
			System.out.println("4. 문자열에서 문자 개수 찾기");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴 번호 입력 : ");
			no = CONSOLE.nextInt();

			switch(no) {
			case 1: fw.printStar1(); break;
			case 2: fw.printStar2(); break;
			case 3: fw.selectMenu(); break;
			case 4: fw.countInputCharacter(); break;
			case 5: System.out.println("프로그램을 종료합니다...");
				return;
			default: System.out.println("잘못된 메뉴번호 입니다. 다시 입력해주세요.");
				break;
			}
			
		} while( no != 5);
	}
}
