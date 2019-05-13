package com.phonebook.view;

import java.util.Scanner;

import com.phonebook.controller.PhoneBookManager;
import com.phonebook.model.vo.PhoneCompanyInfo;
import com.phonebook.model.vo.PhoneInfo;
import com.phonebook.model.vo.PhoneUnivInfo;

interface INIT_MENU{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}

interface INPUT_SELECT{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

public class MainMenu {
	public static final Scanner CONSOLE = new Scanner(System.in);
	PhoneBookManager mgr = PhoneBookManager.createManagerInst();

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
				case INIT_MENU.INPUT: mgr.readData(); break;
				case INIT_MENU.SEARCH: mgr.searchData(); break;
				case INIT_MENU.DELETE: mgr.deleteData(); break;
				case INIT_MENU.EXIT: 
					System.out.println("프로그램을 종료합니다...");
					return;
				default:
					System.out.println("잘못 입력하셨습니다...");
					break;
			}
		}while(choice != 4);
	}
	
	public PhoneInfo readInfo() {
		System.out.println("데이터입력을 시작합니다.");
		System.out.println("1. 일반 2. 대학 3. 회사.");
		System.out.print("입력: ");
		int choice = CONSOLE.nextInt(); readNewLine();
		PhoneInfo info = null;
		
		switch(choice) {
			case INPUT_SELECT.NORMAL: info = readFriendInfo(); break;
			case INPUT_SELECT.UNIV: info = readUnivFriendInfo(); break;
			case INPUT_SELECT.COMPANY: info = readCompanyFriendInfo(); break;
			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. 주메뉴로 돌아갑니다.");
				break;
		}
		return info;
	}
	
	public PhoneInfo readFriendInfo() {
		System.out.println("===== 일반친구 데이터 입력 =====");
		System.out.print("  이름 : ");
		String name = MainMenu.CONSOLE.nextLine();
		System.out.print("  전화 : ");
		String phone = MainMenu.CONSOLE.nextLine();

		PhoneInfo info = new PhoneInfo(name, phone);
		return info;
	}
	
	public PhoneInfo readUnivFriendInfo() {
		System.out.println("===== 대학친구 데이터 입력 =====");
		System.out.print("  이름 : ");
		String name = MainMenu.CONSOLE.nextLine();
		System.out.print("  전화 : ");
		String phone = MainMenu.CONSOLE.nextLine();
		System.out.print("  전공 : ");
		String major = MainMenu.CONSOLE.nextLine();
		System.out.print("  학년 : ");
		int year = MainMenu.CONSOLE.nextInt();

		PhoneUnivInfo info = new PhoneUnivInfo(name, phone, major, year);
		return info;
	}
	
	public PhoneInfo readCompanyFriendInfo() {
		System.out.println("===== 회사친구 데이터 입력 =====");
		System.out.print("  이름 : ");
		String name = MainMenu.CONSOLE.nextLine();
		System.out.print("  전화 : ");
		String phone = MainMenu.CONSOLE.nextLine();
		System.out.print("  회사 : ");
		String company = MainMenu.CONSOLE.nextLine();
		
		PhoneCompanyInfo info = new PhoneCompanyInfo(name, phone, company);
		return info;
	}

	//remove newline from buffer
	private void readNewLine() {
		if(CONSOLE.hasNextLine())
			CONSOLE.nextLine();
	}
}
