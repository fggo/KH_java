package com.kh.food.main;

import com.kh.food.controller.UserController;

public class Main {
	private static UserController controller = Main.getController();

	public static UserController getController() {
		return new UserController();
	}
	public static void main(String[] args) {
		getController().mainMenu();
	}
}
