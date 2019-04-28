package com.ex.func;

import java.util.Scanner;

public class ExTest {
	public void cal() {
		Scanner sc = new Scanner(System.in);

		int n1, n2;

		//연산에 사용할 숫자 입력
		System.out.print("숫자 n1 입력: ");
		n1 = sc.nextInt(); sc.nextLine();
		System.out.print("숫자 n2 입력: ");
		n2 = sc.nextInt(); sc.hasNextLine();
		
		//연산결과 저장
		int add = n1 + n2;
		int minus = n1 - n2;
		int multi = n1 * n2;
		double div = (double)n1 / n2;
		int mod = n1 % n2;

		//연산결과 출력
		System.out.println("\n더하기결과:\tn1 + n2 = " + add);
		System.out.println("빼기결과:\tn1 - n2 = " + minus);
		System.out.println("곱하기결과:\tn1 * n2 = " + multi);
		System.out.println("나누기결과:\tn1 / n2 = " + div);
		System.out.println("나머지값:\tn1 % n2 = " + mod);
		System.out.println("");
		
		//비교연산자
		boolean b1 = n1 <= n2;
		boolean b2 = n1 != n2;
		boolean b3 = n1>n2;
		boolean b4 = n1 == n2;

		System.out.printf("%d <= %d은 %b 입니다.\n", n1, n2, b1);
		System.out.printf("%d != %d은 %b 입니다.\n", n1, n2, b2);
		System.out.printf("%d > %d은 %b 입니다.\n", n1, n2, b3);
		System.out.printf("%d == %d은 %b 입니다.\n", n1, n2, b4);
		System.out.println();
		
		int inputNum1, inputNum2;
		System.out.print("정수입력 1: ");
		inputNum1 = sc.nextInt(); sc.nextLine();
		
		System.out.print("정수입력 2: ");
		inputNum2 = sc.nextInt(); sc.nextLine();

		boolean flagA = inputNum1 % 2 == 0;
		boolean flagB = inputNum2 % 3 == 0;
		
		System.out.println(flagA);
		System.out.println(flagB);

		if(inputNum1 % 2 == 0)
			System.out.println(inputNum1 + " 은 2의배수입니다.");
		else if (inputNum1 % 3 == 0)
			System.out.println(inputNum1 + " 은 3의배수입니다.");
		if(inputNum2 % 2 == 0)
			System.out.println(inputNum2 + " 은 2의배수입니다.");
		else if (inputNum2 % 3 == 0)
			System.out.println(inputNum2 + " 은 3의배수입니다.");
		
		//일반논리 연산자.
		//비교연산자(논리값)를 두개이상 결합한 결과
		boolean flagC = true;
		boolean flagD = false;

		System.out.println(flagC && flagD);
		System.out.println(flagC || flagD);
		
		int age = 19;
		char gender = '남';
		boolean flagMili = true;

		System.out.println(age > 19 && gender == '남' && flagMili);
		System.out.println(age > 19 || gender == '남' && flagMili);
		System.out.println(age > 19 && gender == '남' || flagMili);
	}
}
