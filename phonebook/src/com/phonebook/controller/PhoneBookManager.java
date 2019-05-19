package com.phonebook.controller;

import java.util.HashSet;
import java.util.Iterator;

import com.phonebook.model.vo.PhoneInfo;
import com.phonebook.view.MainMenu;
import com.phonebook.view.MenuChoiceException;

public class PhoneBookManager {
//	static final int MAX_CNT = 5;
//	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();
	
	private static PhoneBookManager inst = null;
	
	public static PhoneBookManager createManagerInst() {
		if(inst == null)
			inst = new PhoneBookManager();
		return inst;
	}
	
	private PhoneBookManager() {}
	
	public void mainMenu() {
		new MainMenu().mainMenu();
	}
	
	public void inputData() {
//		if(PhoneInfo.getCurCnt() < MAX_CNT) {
//		}
//		else {
//			System.out.println("전화번호부가 다 찼습니다...");
//		}
		try {
			PhoneInfo info = new MainMenu().readInfo();
			if(info!= null) {
//				infoStorage[PhoneInfo.getCurCnt()-1] = info;
				boolean isAdded = infoStorage.add(info);
				if (isAdded == true)
					System.out.println("입력이 완료되었습니다.");
				else
					System.out.println("이미 저장된 데이터 입니다.(이름 중복)");
			}
		}
		catch(MenuChoiceException e) {
			e.showWrongChoice();
			System.out.println("잘못된 서브메뉴를 선택했습니다.");
		}
	}
	
	public void searchData() {
		if(PhoneInfo.getCurCnt() == 0) {
			System.out.println("전화번호부가 비어있습니다.");
			return;
		}
		System.out.print("찾으려는 이름 입력: "); readNewLine();
		String name = MainMenu.CONSOLE.nextLine();
		PhoneInfo info = search(name);
		if(info == null)
			System.out.println("찾으려는 데이터가 없습니다.");
		else {
			info.showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다.\n");
		}
		/*int idx = search(name);
		if(idx <0) {
			System.out.println("찾으려는 데이터가 없습니다.");
		}
		else {
			System.out.println("찾은 데이터: ");
			infoStorage[idx].showPhoneInfo();
		}*/
	}
	
	public void deleteData() {
		if(PhoneInfo.getCurCnt() == 0) {
			System.out.println("전화번호부가 비어있습니다.");
			return;
		}
		System.out.print("지우려는 이름 입력: "); readNewLine();
		String name = MainMenu.CONSOLE.nextLine();
		
		/*int idx = search(name);
		if(idx <0) {
			System.out.println("삭제하려는 데이터가 없습니다.");
		}
		else {
			for(int i =idx; i<PhoneInfo.getCurCnt()-1; i++)
				infoStorage[idx] = infoStorage[idx+1];

			infoStorage[PhoneInfo.getCurCnt() -1] = null;
			PhoneInfo.deleteCnt();
			System.out.println("데이터를 삭제하였습니다.");
		}*/
		
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		
		PhoneInfo info = null;
		while(itr.hasNext()) {
			info = itr.next();
			if(name.compareTo(info.getName()) == 0) {
				itr.remove();
				System.out.println("데이터를 삭제하였습니다.");
				return;
			}

		}
		System.out.println("삭제하려는 데이터가 없습니다.");
	}
	
	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();

		PhoneInfo info = null;
		while(itr.hasNext()) {
			info = itr.next();
			if(name.compareTo(info.getName()) == 0)
				return info;
		}
		return null;

		/*for(int i =0; i<PhoneInfo.getCurCnt(); i++) {
			info = infoStorage[i];
			if(name.compareTo(info.getName()) == 0) {
				return i;
			}
		}
		return -1;*/
	}
	
	//remove new line character from buffer
	private void readNewLine() {
		if(MainMenu.CONSOLE.hasNextLine())
			MainMenu.CONSOLE.nextLine();
	}

}