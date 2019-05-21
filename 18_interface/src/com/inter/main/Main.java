package com.inter.main;

import com.inter.controller.InterfaceController;
import com.inter.model.vo.BMWCar;

public class Main {

	public static void main(String[] args) {
		InterfaceController ic=new InterfaceController();
		ic.usePrint(new BMWCar());

	}

}
