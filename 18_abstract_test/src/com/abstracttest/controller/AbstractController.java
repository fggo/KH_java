package com.abstracttest.controller;

import com.abstracttest.model.vo.Animal;
import com.abstracttest.model.vo.Bus;
import com.abstracttest.model.vo.Car;
import com.abstracttest.model.vo.Dog;
import com.abstracttest.model.vo.Jaguar;

public  class AbstractController {
	public void test() {
		Dog dog = new Dog("ss", "ss", "¾çÆÄ", 4);
		System.out.println(dog.getName());
		System.out.println(dog.getCategory());
		System.out.println(dog.getTul());

		Animal ani = new Dog();
		ani.printAnimal();
		((Dog)ani).getTul();
		
		ani = new Jaguar();
		ani.printAnimal();
		((Jaguar)ani).getPaw();
	}
	
	public void test2() {
		Car vehicle = new Bus("BusModel01", "V100", 4, 20,
				"HappyBusCORP", "Seoul", "Hyundai", 200);
		vehicle.move(10, 20);
		((Bus)vehicle).getCompany();
		((Bus)vehicle).addPassenger();
	}
}
