package com.jdbc.first.view;

import java.util.Scanner;

import com.jdbc.first.controller.MemberController;

public class MainView {
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----회원관리프로그램-----");
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 이름으로 조회");
			System.out.println("0. 종료");
			System.out.print("입력 ; ");
			int cho = sc.nextInt(); sc.nextLine();

			switch(cho) {
				case 1: new MemberController().memberAllSearch(); break;
				case 2: 
				case 0: System.out.println("프로그램을 종료합니다."); return;
			}
		}
	}
}
