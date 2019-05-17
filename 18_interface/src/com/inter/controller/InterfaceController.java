package com.inter.controller;

import com.inter.model.inter.PrintDriver;
import com.inter.model.vo.SamsongPrint;

public class InterfaceController {
	public void interfaceController() {
//		PrintDriver pd = new PrintDriver();
		PrintDriver pd = new SamsongPrint();
//		((SamsongPrint)pd)
		System.out.println(pd.TEST);
	}
}
