package com.kh.lotto.controller;

import java.util.HashSet;
import java.util.Iterator;

import com.kh.lotto.model.vo.User;
import com.kh.lotto.view.MainMenu;

public class UserController {
//	private final static int MAX_CNT = 25;
//	private User[] users = new User[MAX_CNT];
	private HashSet<User> users = new HashSet<User>();

	public void mainMenu() {
		MainMenu.mainMenu();
	}
	
	public void input() {
		User user = MainMenu.inputView();
		users.add(user);
	}

	public void modify() {
		if(users.size() == 0) {
			System.out.println("유저가 없습니다.");
			return;
		}
		//수정할 유저 아이디
		String username = MainMenu.modifyView();

		/*NOT ALLOWED TO MODIFY
			//username
			//grade
			//date
			//userPoint
			//userMoney
			//gambleRecord
		*/

		//수정할 데이터
		User user = search(username);

		if(user == null) {
			System.out.println("존재하지 않는 유저입니다.");
		}
		else {
			//password
			System.out.print("비밀번호 : ");
			String password = MainMenu.CONSOLE.nextLine();
			//accountNumber
			System.out.print("계좌번호 : ");
			String accountNumber = MainMenu.CONSOLE.nextLine();
			
			user.setPassword(password);
			user.setAccountNumber(accountNumber);
		}
	}

	public void delete() {
		if(users.size() == 0) {
			System.out.println("유저가 없습니다.");
			return;
		}
		String username = MainMenu.deleteView();

		Iterator<User> itr = users.iterator();
		User user = null;
		while(itr.hasNext()) {
			user = itr.next();
			if(username.equals(user.getUsername())) {
				itr.remove();
				System.out.println("데이터를 삭제하였습니다.");
				return;
			}
		}
		System.out.println("삭제하려는 데이터가 없습니다.");
	}


	public void search() {
		if(users.size() == 0) {
			System.out.println("유저가 없습니다.");
			return;
		}
		String username = MainMenu.searchView();
		User user = search(username);
		if(user == null) {
			System.out.println("유저가 없습니다.");
		}
		else {
			user.showUserInfo();
		}
	}

	public void searchAll() {
		if(users.size() == 0) {
			System.out.println("유저가 없습니다.");
			return;
		}
		Iterator<User> itr = users.iterator();
		User user = null;
		while(itr.hasNext()) {
			user = itr.next();
			user.showUserInfo();
		}
	}

	private User search(String username) {
		Iterator<User> itr = users.iterator();
		User user = null;
		while(itr.hasNext()) {
			user = itr.next();
			if(username.equals(user.getUsername()))
				return user;
		}
		return null;
	}

	public HashSet<User> getUsers() { return users; }
}
