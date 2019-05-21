package com.kh.food.controller;

import java.util.HashSet;
import java.util.Iterator;

import com.kh.food.model.vo.User;
import com.kh.food.view.MainMenu;

public class UserController {
	HashSet<User> users = new HashSet<User>();
	
	public void mainMenu() {
		MainMenu.mainMenu();
	}

	public void signUp() {
		User user = MainMenu.signUpView();
		boolean isAdded = users.add(user);
		if(isAdded)
			System.out.println("회원가입이 성공적으로 처리되었습니다.");
		else
			System.out.println("회원가입에 실패하였습닌다.");
	}

	public void signIn() {
		String phone = MainMenu.signInView();
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			if(itr.next().getPhone().equals(phone)) {
				System.out.println("로그인 됐슨니다.");
			}
		}
		
		System.out.println("로그인에 실패 하였습니다.");

	}
	public void search() {
	}
}
