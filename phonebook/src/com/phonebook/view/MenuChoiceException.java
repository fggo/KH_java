package com.phonebook.view;

public class MenuChoiceException extends Exception {
	int wrongChoice;

	public MenuChoiceException(int wrongChoice) {
		super("잘못된 메뉴선택 입니다.");
		this.wrongChoice = wrongChoice;
	}
	
	public void showWrongChoice() {
		System.out.println(wrongChoice + "에 해당하는 메뉴가 없습니다.");
	}
}
