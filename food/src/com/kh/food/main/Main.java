package com.kh.food.main;

import com.kh.food.controller.UserController;

public class Main {
	private static UserController controller = new UserController();

	public static UserController getController() {
		return controller;
	}
	public static void main(String[] args) {
		getController().mainMenu();
	}
}
