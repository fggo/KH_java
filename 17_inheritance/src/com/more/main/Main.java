package com.more.main;

import com.more.contoller.MoreController;
import com.person.Controller.PersonController;

public class Main {
	static MoreController mc = new MoreController();
	static PersonController pc = new PersonController();
	
	public static void main(String[] args) {
		mc.shapeTest();
		mc.animalTest();

		pc.personEnroll();
	}
}
