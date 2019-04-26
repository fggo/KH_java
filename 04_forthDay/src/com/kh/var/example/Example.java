package com.kh.var.example;

import java.util.Scanner;

public class Example {
	public Scanner sc = new Scanner(System.in);

	public void example1() {
		System.out.print("첫번째 정수: ");
		int n1 = sc.nextInt();
		System.out.print("두번째 정수: ");
		int n2 = sc.nextInt(); sc.nextLine();

		int add = n1 +n2;
		int minus = n1 - n2;
		int multi = n1 * n2;
		int div = n1 / n2;
		int mod = n1 % n2;

		System.out.println("더하기 결과: " + add);
		System.out.println("뺴기 결과: " + minus);
		System.out.println("곱하기 결과: " + multi);
		System.out.println("나누기한 몫: " + div);
		System.out.println("나누기한 나머지: " + mod);
	}
	
	public void example2() {
		System.out.print("가로: ");
		double width = sc.nextDouble();
		System.out.print("세로: ");
		double height = sc.nextDouble(); sc.nextLine();
		
		System.out.println("면적: " + width*height);
		System.out.println("둘레: " + 2*(width+height));
	}
	
	public void example3() {
		System.out.print("문자열을 입력하시오(문자3개 이상 단어): ");
		String str = sc.nextLine();
		System.out.println("첫번째 문자: " + str.charAt(0));
		System.out.println("두번째 문자: " + str.charAt(1));
		System.out.println("세번째 문자: " + str.charAt(2));
	}
}
