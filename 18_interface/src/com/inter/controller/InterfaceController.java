package com.inter.controller;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.inter.model.vo.CannonPrint;
import com.inter.model.vo.LgPrint;
import com.inter.model.vo.Print;
import com.inter.model.vo.SamsongPrint;

public class InterfaceController {
	private Print print;

	public void interfaceController(Print print) {
		this.print = print;
		//PrintDriver pd=new PrintDriver();
		//PrintDriver pd=new SamSongPrint();
		//System.out.println(pd.TEST);		
	}
	
	public void usePrint(Print print) {
		print.print();
		print.copy();
		print.scan();
		
//		SamSongPrint sp=new SamSongPrint();
//		sp.printSam();
//		LgPrint lg=new LgPrint();
//		lg.print();
//		CannonPrint c=new CannonPrint();
//		c.connonPrint();
//		Print print=new SamSongPrint();
//		//((SamSongPrint)print).printSam();
//		print.print();
//		print=new LgPrint();
//		print.print();
//		//((LgPrint)print).print();
//		print=new CannonPrint();
//		print.print();
		
	}
	
}












