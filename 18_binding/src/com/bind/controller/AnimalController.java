package com.bind.controller;

import com.bind.model.vo.Animal;
import com.bind.model.vo.Dog;

public class AnimalController {

	public void animalController() {
		Animal ani = new Animal();
		ani = new Dog();
		ani.clean();
		ani.action();
	}
}
