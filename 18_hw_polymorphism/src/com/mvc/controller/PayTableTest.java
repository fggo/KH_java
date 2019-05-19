package com.mvc.controller;

import com.mvc.model.PayTable;
import com.mvc.model.Salary;

public class PayTableTest {
	public static void main(String[] args) {
		Salary[] pt = new Salary[4];
		pt[0] = new PayTable("소서노", 750000, 2, 3);
		pt[1] = new PayTable("고주몽", 800000, 1, 4);
		pt[2] = new PayTable("모팔모", 650000, 6, 2);
		pt[3] = new PayTable("바바바", 990000, 9, 3);
		
		System.out.println("\t\t\t\t**** 급여명세서 ****");
		System.out.println("---------------------------------------------"
				+ "------------------------------------------------------");
		System.out.println("이름\t기본급\t가족수\t가족수당\t시간외근무\t시간외수당\t세금\t인센티브(%)\t성과금\t실수령액");
		System.out.println("---------------------------------------------"
				+ "------------------------------------------------------");
		for(int i =0; i<pt.length; i++) {
			((PayTable)pt[i]).calc();
			((PayTable)pt[i]).out();
		}

		System.out.println("---------------------------------------------"
				+ "------------------------------------------------------");
		System.out.println("인원수 : " + PayTable.getCount() + "명");
	}
}
