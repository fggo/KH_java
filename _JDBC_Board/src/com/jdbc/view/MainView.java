package com.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc.controller.BoardController;
import com.jdbc.controller.MemberController;
import com.jdbc.model.vo.Board;
import com.jdbc.model.vo.Member;

public class MainView {
	MemberController memberController = new MemberController();
	BoardController boardController = new BoardController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		int cho = 0;
		do {
			System.out.println("===== MAIN MENU =====");
			System.out.println("1.MEMBER SUBMENU");
			System.out.println("2.BOARD SUBMENU");
			System.out.println("3.EXIT");
			System.out.print("CHOOSE >> ");
			cho = sc.nextInt();
			switch(cho){
				case 1: this.memberSubMenu(); break;
				case 2: this.boardSubMenu(); break;
				case 3: System.out.println("EXIT...");
					return;
			}
		} while(true);
	}

	public void memberSubMenu() { 
		Scanner sc = new Scanner(System.in);
		int cho = 0;
		do {
			System.out.println("===== MEMBER SUBMENU =====");
			System.out.println("1. SELECT ALL");
			System.out.println("2. SELECT ID");
			System.out.println("3. SELECT NAME");
			System.out.println("4. INSERT MEMBER");
			System.out.println("5. UPDATE MEMBER(address,phone,email)");
			System.out.println("6. DELETE MEMBER");
			System.out.println("7. BACK TO MAIN MENU...");
			System.out.print("CHOOSE >> ");
			cho = sc.nextInt();
			switch(cho){
				case 1: memberController.selectAll(); break;
				case 2: memberController.selectId(); break;
				case 3: memberController.selectName(); break;
				case 4: memberController.insertMember(); break;
				case 5: memberController.updateMember(); break;
				case 6: memberController.deleteMember(); break;
				case 7: System.out.println("BACK TO MAIN MENU..."); return;
			}
			
		} while(true);
	}
	
	public String inputData(String type) {
		Scanner sc = new Scanner(System.in);
		if(type.equals("IDX")) System.out.print("IDX : ");
		else if(type.equals("ID")) System.out.print("ID : ");
		else if(type.equals("NAME")) System.out.print("NAME : ");
		else if(type.equals("WRITER")) System.out.print("WRITER : ");
		else if(type.equals("TITLE")) System.out.print("TITLE : ");
		
		return sc.nextLine();
	}
	
	public Member insertMember() {
		Scanner sc = new Scanner(System.in);
		Member m = new Member();

//		System.out.print("IDX : ");

		System.out.print("MEMBER ID : ");
		m.setMemberId(sc.nextLine());

		System.out.print("MEMBER PWD : ");
		m.setMemberPwd(sc.nextLine());

		System.out.print("MEMBER NAME : ");
		m.setMemberName(sc.nextLine());

		System.out.print("EMAIL : ");
		m.setEmail(sc.nextLine());

		System.out.print("ADDRESS : ");
		m.setAddress(sc.nextLine());

		System.out.print("PHONE : ");
		m.setPhone(sc.nextLine());

//		System.out.print("ENROLL DATE : ");

		return m;
	}

	public Member updateMember() {
		Scanner sc = new Scanner(System.in);
		Member m = new Member();

		System.out.print("IDX : ");
		m.setIdx(sc.nextInt()); sc.nextLine();

		System.out.print("EMAIL : ");
		m.setEmail(sc.nextLine());

		System.out.print("ADDRESS : ");
		m.setAddress(sc.nextLine());

		System.out.print("PHONE : ");
		m.setPhone(sc.nextLine());

		return m;
	}
	
	public int deleteMember() {
		Scanner sc = new Scanner(System.in);

		System.out.print("IDX : ");
		return sc.nextInt();
	}

	public void boardSubMenu() {
		Scanner sc = new Scanner(System.in);
		int cho = 0;
		do {
			System.out.println("===== BOARD SUBMENU =====");
			System.out.println("1. SELECT ALL");
			System.out.println("2. INSERT BOARD");
			System.out.println("3. SELECT WRITER");
			System.out.println("4. SELECT TITLE");
			System.out.println("5. UPDATE BOARD(title,board_comment)");// modify idx
			System.out.println("6. DELETE MEMBER");
			System.out.println("7. BACK TO MAIN MENU...");
			System.out.print("CHOOSE >> ");
			cho = sc.nextInt();
			switch(cho){
				case 1: boardController.selectAll(); break;
				case 2: boardController.insertBoard(); break;
				case 3: boardController.selectWriter(); break;
				case 4: boardController.selectTitle(); break;
				case 5: boardController.updateBoard(); break;
				case 6: boardController.deleteBoard(); break;
				case 7: System.out.println("BACK TO MAIN MENU..."); return;
			}
		} while(true);
	}
	
	public Board insertBoard() {
		Scanner sc = new Scanner(System.in);
		Board b = new Board();

//		System.out.print("IDX : ");

		System.out.print("DIV(공지,일반,비밀) : ");
		b.setDiv(sc.nextLine());
		if(!"공지일반비밀".contains(b.getDiv()))
			return null;

		System.out.print("TITLE : ");
		b.setTitle(sc.nextLine());

		System.out.print("BOARD COMMENT : ");
		b.setBoardComment(sc.nextLine());

		System.out.print("WRITER : ");
		b.setWriter(sc.nextLine());

//		System.out.print("WRITE DATE : ");

		return b;
	}

	public Board updateBoard() {
		Scanner sc = new Scanner(System.in);
		Board b = new Board();

		System.out.print("IDX : ");
		b.setIdx(sc.nextInt()); sc.nextLine();

		System.out.print("TITLE : ");
		b.setTitle(sc.nextLine());

		System.out.print("BOARD COMMENT : ");
		b.setBoardComment(sc.nextLine());

		return b;
	}
	
	public int deleteBoard() {
		Scanner sc = new Scanner(System.in);

		System.out.print("IDX : ");
		return sc.nextInt();
	}

	public <T> void display(T obj) {
		System.out.println(obj);
	}
	
	public <T> void displayList(List<T> list) {
		for(T obj : list)
			System.out.println(obj);
	}
	
	public void displayMsg(String msg) {
		System.out.println(msg);
	}
}
