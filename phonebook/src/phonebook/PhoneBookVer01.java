package phonebook;

import java.util.Scanner;
/*
 * 전화번호 관리 프로그램 구현 프로젝트
 * Version 0.1
 */

class PhoneInfo{

	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name;
		phoneNumber = num;
		this.birth = birth;
	}
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
		this.birth = null;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
		if(birth != null)
			System.out.println("birth : " + birth);
		
		System.out.println();
	}
}

class PhoneBookManger {
	static final int MAX_CNT = 100;
	PhoneInfo[] infoStorage = 
			new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	public void putData() {
		System.out.println("데이터 입력을 시작합니다. ");
		if(PhoneBookVer01.CONSOLE.hasNextLine()) PhoneBookVer01.CONSOLE.nextLine();

		System.out.print("이름 : ");
		String name = PhoneBookVer01.CONSOLE.nextLine();
		System.out.print("전화 : ");
		String phone = PhoneBookVer01.CONSOLE.nextLine();
		System.out.print("생일 : ");
		String birth = PhoneBookVer01.CONSOLE.nextLine();

		if(curCnt >= MAX_CNT) {
			System.out.println("전화번호부가 다 찼습니다...");
		}
		infoStorage[curCnt++] = new PhoneInfo(name, phone, birth);
		System.out.println("입력이 완료되었습니다.");
	}
	
	public void searchData() {
		System.out.print("찾으려는 이름 입력: ");
		String name = PhoneBookVer01.CONSOLE.nextLine();
		int idx = search(name);
		if(idx <0) {
			System.out.println("찾으려는 데이터가 없습니다.");
		}
		else {
			System.out.println("찾은 데이터: ");
		}
	}
	
	public void deleteData() {
		System.out.print("지우려는 이름 입력: ");
		String name = PhoneBookVer01.CONSOLE.nextLine();
		int idx = search(name);
		if(idx <0) {
			System.out.println("삭제하려는 데이터가 없습니다.");
		}
		else {
			for(int i =idx; i<curCnt-1; i++)
				infoStorage[idx] = infoStorage[idx+1];

			curCnt--;
			System.out.println("데이터를 삭제하였습니다.");
		}
		
	}
	
	private int search(String name) {
		PhoneInfo info = null;
		for(int i =0; i<curCnt; i++) {
			info = infoStorage[i];
			if(name.compareTo(info.name) == 0) {
				return i;
			}
		}
		return -1;
	}

}
public class PhoneBookVer01 {
	static final Scanner CONSOLE = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택: ");
	}
	
	public static void readData() {

	}

	public static void main(String[] args) {
		int choice = 0;
		while(true) {
			showMenu();
			choice = CONSOLE.nextInt();
			switch(choice) {
			case 1: readData(); break;
			case 2: 
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("잘못 입력하셨습니다...");
				break;
			}
		}
	}
}
