package com.kh.lotto.controller;

import com.kh.lotto.model.vo.User;
import com.kh.lotto.view.MainMenu;

public class UserController {
	private final static int MAX_CNT = 25;
	private User[] users = new User[MAX_CNT];
	private static int count = 0;
	{
		count++;
	}

	public User[] getUsers() { return users; }
	public void setUsers(User[] users) { this.users = users; }
	public static int getCount() { return count; }
	public static void deleteCount() { UserController.count--; }
	public static int getMaxCnt() { return MAX_CNT; }
	
	public void input() {
		User user = MainMenu.inputView();
		
	}
	
	public void delete() {}
	public void update() {}

	public void searchAll() {

		for(int i =0; i<count; i++) {
			users[i].showUserInfo();
			System.out.println();
		}
	}

	public void search() {
		
	}

	private int search(String username) {
		for(int i =0; i<count; i++) {
			if(users[i].getUsername().equals(username))
				return i;
		}
		return -1;
	}
}
