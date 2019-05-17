package com.kh.lotto.controller;

import com.kh.lotto.model.vo.User;
import com.kh.lotto.view.MainMenu;

public class UserController {
	private final static int MAX_CNT = 25;
	private User[] users = new User[MAX_CNT];

	public static int getMaxCnt() { return MAX_CNT; }
	public User[] getUsers() { return users; }
	public void setUsers(User[] users) { this.users = users; }
	
	public void input() {
		User user = MainMenu.inputView();
	}
	
	public void delete() {}
	public void update() {}

	public void searchAll() {
		if(User.getCount() == 0) {
			System.out.println();
		}

		for(int i =0; i<User.getCount(); i++) {
			users[i].showUserInfo();
			System.out.println();
		}
	}

	public void search() {
		if(User.getCount() == 0) {
			System.out.println("유저가 없습니다.");
		}
		else {
			String name = MainMenu.searchView();
			int idx = search(name);
		}

	}

	private int search(String username) {
		for(int i =0; i<User.getCount(); i++) {
			if(users[i].getUsername().equals(username))
				return i;

		}
		return -1;
	}
}
