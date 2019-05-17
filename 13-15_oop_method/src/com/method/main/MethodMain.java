package com.method.main;

import com.method.controller.MethodTest;

public class MethodMain {
	public static void main(String[] args) {
		int su1 = 10;
		int su2 = 20;

		char op1 = '+';
		char op2 = '/';

//		char[] operators = {'+', '-', '*', '/', '%'};
//		double result = 0;
//		for(int i =0; i<operators.length; i++) {
//			result = mt.calculator2(su1, su2, operators[i]);
//			System.out.println("  result = " + result);
//		}

		new MethodTest().calculator1(su1, su2, op1);
		System.out.println(new MethodTest().calculator2(20, 30, op2));
		String msg1 = new MethodTest().concatString("가가가", "나나나");
		msg1 += "vvvvvv";
		String msg2 = msg1 + new MethodTest().greeting();
		System.out.println(msg2);
		
		//배열 return
		int[] copy = new MethodTest().arrayReturn();
		System.out.println("Main");
		for(int i : copy) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//배열 copy
		new MethodTest().inputArr(copy);
		for(int i : copy) {
			System.out.print(i + " ");
		}
		
		int a = 10;
		int b = 20;
		new MethodTest().intUpdate(a, b);
		System.out.println("\n" + a + ", " + b);
	}
}
