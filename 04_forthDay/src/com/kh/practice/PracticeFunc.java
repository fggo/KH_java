package com.kh.practice;

import java.util.Scanner;

public class PracticeFunc {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void prac() {
		System.out.print("나이를 입력하세요: ");
		int age = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("성별을 입력하세요(남/여): ");
		String gender = CONSOLE.nextLine();
//		char gender = CONSOLE.nextLine().charAt(0);
//		gender == '남'? //char

		String msg = age > 19? 
				gender.equals("남")? "왼쪽으로 가세요.\n" :"오른쪽으로 가세요.\n"
						: "19세이하면 미성년자 입니다.\n";
		
		System.out.print(msg);

	}
	
	public void incentive() {
		System.out.print("\nA의 연봉을 입력하세요: ");
		int salA = CONSOLE.nextInt(); CONSOLE.nextLine();

		System.out.print("B의 연봉을 입력하세요: ");
		int salB = CONSOLE.nextInt(); CONSOLE.nextLine();

		System.out.print("C의 연봉을 입력하세요: ");
		int salC = CONSOLE.nextInt(); CONSOLE.nextLine();

		int raisedA = (int)(salA * 1.05);
		int raisedB = salB;
		int raisedC = (int)(salC * 1.01);

		int sum = salA + salB + salC;
		System.out.println("회사 연봉의 총합은: " + sum + "만원");
		System.out.println("회사 연봉의 평균은: " + (double)sum/3 + "만원");

		String msgA = raisedA >= 3000? "한턱쏴" : "내가쏠게";
		String msgB = raisedB >= 3000? "한턱쏴" : "내가쏠게";
		String msgC = raisedC >= 3000? "한턱쏴" : "내가쏠게";

		System.out.println("A의 인센티브포함한 급여는: " + raisedA + "만원\t" + msgA);
		System.out.println("B의 인센티브포함한 급여는: " + raisedB + "만원\t" + msgB);
		System.out.println("C의 인센티브포함한 급여는: " + raisedC + "만원\t" + msgC);
	}
}
