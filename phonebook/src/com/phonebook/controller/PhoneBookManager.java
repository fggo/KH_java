package com.phonebook.controller;

import com.phonebook.model.vo.PhoneInfo;
import com.phonebook.view.MainMenu;

public class PhoneBookManager {
	static final int MAX_CNT = 5;
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	
	private static PhoneBookManager inst = null;
	
	public static PhoneBookManager createManagerInst() {
		if(inst == null)
			inst = new PhoneBookManager();
		return inst;
	}
	
	private PhoneBookManager(){}
	
	public void mainMenu() {
		new MainMenu().mainMenu();
	}
	
	public void readData() {
		if(PhoneInfo.getCurCnt() < MAX_CNT) {
			PhoneInfo info = new MainMenu().readInfo();
			if(info!= null) {
				infoStorage[PhoneInfo.getCurCnt()-1] = info;
				System.out.println("입력이 완료되었습니다.");
			}
		}
		else {
			System.out.println("전화번호부가 다 찼습니다...");
		}
	}
	
	public void searchData() {
		if(PhoneInfo.getCurCnt() == 0) {
			System.out.println("전화번호부가 비어있습니다.");
			return;
		}
		System.out.print("찾으려는 이름 입력: "); readNewLine();
		String name = MainMenu.CONSOLE.nextLine();
		int idx = search(name);
		if(idx <0) {
			System.out.println("찾으려는 데이터가 없습니다.");
		}
		else {
			System.out.println("찾은 데이터: ");
			infoStorage[idx].showPhoneInfo();
		}
	}
	
	public void deleteData() {
		if(PhoneInfo.getCurCnt() == 0) {
			System.out.println("전화번호부가 비어있습니다.");
			return;
		}
		System.out.print("지우려는 이름 입력: "); readNewLine();
		String name = MainMenu.CONSOLE.nextLine();
		int idx = search(name);
		if(idx <0) {
			System.out.println("삭제하려는 데이터가 없습니다.");
		}
		else {
			for(int i =idx; i<PhoneInfo.getCurCnt()-1; i++)
				infoStorage[idx] = infoStorage[idx+1];

			infoStorage[PhoneInfo.getCurCnt() -1] = null;
			PhoneInfo.setCurCnt(PhoneInfo.getCurCnt() - 1);
			System.out.println("데이터를 삭제하였습니다.");
		}
		
	}
	
	private int search(String name) {
		PhoneInfo info = null;
		for(int i =0; i<PhoneInfo.getCurCnt(); i++) {
			info = infoStorage[i];
			if(name.compareTo(info.getName()) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	//remove new line character from buffer
	private void readNewLine() {
		if(MainMenu.CONSOLE.hasNextLine())
			MainMenu.CONSOLE.nextLine();
	}

}