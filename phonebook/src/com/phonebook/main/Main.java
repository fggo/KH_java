package com.phonebook.main;

import com.phonebook.controller.PhoneBookManager;

public class Main {
	public static void main(String[] args) {
		PhoneBookManager mgr = PhoneBookManager.createManagerInst();
		mgr.mainMenu();
	}
}
