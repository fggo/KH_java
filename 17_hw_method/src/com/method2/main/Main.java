package com.method2.main;

import java.util.Scanner;

import com.method2.controller.MethodTest;
import com.method2.controller.NonStaticSample;

public class Main {
	public final static Scanner CONSOLE = new Scanner(System.in);
	static MethodTest mt = new MethodTest();
	static NonStaticSample nss = new NonStaticSample();

	public static void main(String[] args) {
		//method hw #1
		mt.test1("Hello ", "World!");
		mt.test2(10, 20);
		mt.test3('\u0000');
		mt.test3('A');

		//non-static method1
		nss.printLottoNumber();
		nss.outputChar(10, 'A');
		System.out.println(nss.alphabette());
		System.out.println(nss.mySubstring("my substring method", 5, 11));

		int[] arr =  {4,2,5,1,3};
		nss.sortAscending(arr);
		for(int i =0; i<arr.length; i++)
			System.out.print(arr[i]);
		

		//static method hw1
	}
}
