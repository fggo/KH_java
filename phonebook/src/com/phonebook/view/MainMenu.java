package com.phonebook.view;

import java.util.Scanner;

import com.phonebook.controller.PhoneBookManager;
import com.phonebook.model.vo.PhoneInfo;

public class MainMenu {
	public static final Scanner CONSOLE = new Scanner(System.in);
	PhoneBookManager mgr = new PhoneBookManager();

	public void mainMenu() {
		int choice = -1;
		do {
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.print("선택: ");
			choice = CONSOLE.nextInt();
			switch(choice) {
				case 1: mgr.readData(); break;
				case 2: mgr.searchData(); break;
				case 3: mgr.deleteData(); break;
				case 4: 
					System.out.println("프로그램을 종료합니다...");
					return;
				default:
					System.out.println("잘못 입력하셨습니다...");
					break;
			}
		}while(choice != 4);
	}
	
	public PhoneInfo readDataView() {
		if(CONSOLE.hasNextLine())
			CONSOLE.nextLine();
		System.out.println("===== 데이터 입력 =====");
		System.out.print("  이름 : ");
		String name = MainMenu.CONSOLE.nextLine();
		System.out.print("  전화 : ");
		String phone = MainMenu.CONSOLE.nextLine();
		System.out.print("  생일 : ");
		String birth = MainMenu.CONSOLE.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phone, birth);
		return info;
	}
}
