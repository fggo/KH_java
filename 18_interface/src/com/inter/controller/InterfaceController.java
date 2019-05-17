package com.inter.controller;

import com.inter.model.inter.PrintDriver;
import com.inter.model.vo.SamsongPrint;

public class InterfaceController {
	public void interfaceController() {
		PrintDriver pd = new SamsongPrint();
		((SamsongPrint)pd).getModel();

		System.out.println(PrintDriver.TEST);
	}
}
