package com.method2.controller;

public class MethodTest {
	public String test1(String s1, String s2) {
		return s1 + s2;
	}
	
	public void test2(int min, int max) {
		if(min<= max) {
			int sum = 0;
			for(int i = min; i<=max; i++)
				sum += i;
			System.out.println(sum);
		}
		else {
			System.out.println("첫번째 인자가 더 작아야 합니다.");
		}
	}
	
	public boolean test3(char ch) {
		if(Character.isLowerCase(ch) || Character.isUpperCase(ch))
			return true;
		else
			return false;
	}
}
