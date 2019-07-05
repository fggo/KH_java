package com.jdbc3.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc3.controller.MemberController;
import com.jdbc3.model.vo.Member;

public class MainView {
	private MemberController controller = new MemberController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("=== MAIN MENU ===");
			System.out.println("1. SEARCH ALL EMP");
			System.out.println("2. SEARCH BY EMP NO");
			System.out.println("3. SEARCH BY EMP NAME");
			System.out.println("4. INSERT EMP");
			System.out.println("5. DELETE EMP");
			System.out.println("0. TERMINATE PROGRAM");
			System.out.print("MENU CHOICE >> ");
			int cho = sc.nextInt(); sc.nextLine();
			
			switch(cho) {
				case 1: controller.selectAll(); break;
				case 2: controller.selectId(); break;
				case 3: controller.selectName(); break;
//				case 4: controller.insertEmp(); break;
//				case 5: controller.deleteEmp(); break;
//				case 0: this.displayMsg("TERMINATING THE PROGRAM..."); return;
			}
		} while(true);
		

	}

	public String inputData(String type) {
		Scanner sc = new Scanner(System.in);
		if(type.equals("ID"))
			System.out.print("SEARCH ID : ");
		else
			System.out.print("SEARCH NAME : ");
		return sc.nextLine();
	}

	public void displayMemberAll(List<Member> list) {
		for(Member m : list)
			System.out.println(m);
	}
	
	public void displayMember(Member m) {
		System.out.println(m);
	}

	public void displayMsg(String msg) {
		System.out.println(msg);
	}
}
