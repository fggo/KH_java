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
		System.out.println(flag ^ !flag);
	}
}
