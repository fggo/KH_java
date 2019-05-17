package com.abstracttest.controller;

import com.abstracttest.model.vo.Animal;
import com.abstracttest.model.vo.Dog;
import com.abstracttest.model.vo.Jaguar;

public  class AbstractController {
	public void test() {
//		Animal ani = new Animal();
		Dog dog = new Dog("ss", "ss", "¾çÆÄ", 4);

		System.out.println(dog.getName());
		System.out.println(dog.getCategory());
		System.out.println(dog.getCategory());
		System.out.println(dog.getTul());

		Animal ani = new Dog();
		ani.printAnimal();

		ani = new Jaguar();
		ani.printAnimal();
	}
}
