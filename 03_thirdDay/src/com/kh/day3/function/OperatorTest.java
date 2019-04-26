package com.kh.day3.function;

public class OperatorTest {
	public void selfAdd(){
		int num = 10;
		//14
		int num2 =++num+20; // 35
		int num3 = num++ + 20;// 35
		System.out.println(num++);
		System.out.println(num);
		System.out.println(++num);
		
		//논리부정연산
		boolean flag = true;
		System.out.println(!flag);

		//bit operator - xor ^
		System.out.println(flag ^ !flag); // 1^0 == 1

		System.out.println(1^0); //1
		System.out.println(0^1); //1
		System.out.println(1^1); //0
		System.out.println(0^0); //0
		
		//실습예제1. ++ --
		int a= 10, b = 20, c= 30;
		a++;
		b = (--a) + b;
		c = (a++) + (--b);
		System.out.println(a); // 11
		System.out.println(b); // 29
		System.out.println(c); // 39
		flag = true;
		System.out.println(!!!!flag); //true
		
		System.out.println(10/3);
	}
}
