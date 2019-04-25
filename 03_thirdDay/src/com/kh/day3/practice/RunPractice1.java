package com.kh.day3.practice;

//실습예제	
public class RunPractice1 {
	public static void main(String[] args) {
		int inum = 100;
		long lnum = 10000L;
		float fnum = 234.567f;
		double dnum = 567.123456;
		char ch = 'A';
		String s = "Hello World";
		boolean isTrue = true;
		System.out.printf("%d\t%d\t%f\t%f\t%c\t%s\t%b\n", 
				inum, lnum, fnum, dnum ,ch, s, isTrue);
		
		int a = 290;
		byte b = (byte)a;
		System.out.println(a);
		System.out.println(b);
	}
}
