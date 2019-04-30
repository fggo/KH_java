package com.kh.controller;

import java.util.Scanner;

public class ForController {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void forTest() {

		/* 100~1출력*/
		for(int i = 1; i <= 100; i++) 
			System.out.print(101-i + " ");

		/* 1~100 합계 출력*/
		int sum = 0;
		for(int i = 1; i <= 100; i++)
			sum += i;
		System.out.println("\n1~100까지의 합: " + sum);

		/* 1~100의 짝수 합 출력*/
		int evenSum = 0;
		for(int i = 1; i <= 100; i++) {
			if (i%2 == 0)
				evenSum += i;
		}
		System.out.println("1~100까지 짝수의 합: " + evenSum);
		
		/* 1~100 홀수 합 출력*/
		int oddSum = 0;
		for(int i=1 ; i<= 100; i++) {
			if(i%2== 1)
				oddSum += i;
		}
		System.out.println("홀수 합: " + oddSum);
		
		/* 입력 숫자 길이만큼 "수박" 출력*/
		System.out.print("수박을 반복할 숫자 입력: ");
		int n = CONSOLE.nextInt();

		String subak = "";
		for(int i =0; i<n; i++) {
			if(i%2 ==0)
				subak += "수";
			else
				subak += "박";
		}
		System.out.println(subak);
		
		/*9x9 단*/ 
		System.out.print("구구단 계산할 숫자 입력(1~9): ");
		int level = CONSOLE.nextInt(); 
		for(int i =1; i<10; i++) {
			System.out.println(level + " X " + i + " = " +(level*i));
		}

		// for(i =0 ;i < CONSOLE.nextInt(); i++) 
		// 다음은 for문 돌때마다 입력 해야함... i < 범위가 매번 바뀜.
	}
}
