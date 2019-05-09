package com.kh.oop.main;

import com.kh.oop.controller.ObjectController;
import com.kh.oop.model.vo.Car;
public class Main {

	public static void main(String[] args) {
		ObjectController oc=new ObjectController();
		oc.accessTest();
		Car c=new Car();
		c.personTest();
	}
}