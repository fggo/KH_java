package com.kh.practice;

import java.util.Scanner;

public class PracticeFunc {
	public static Scanner sc = new Scanner(System.in);

	public void prac() {
		System.out.print("나이를 입력하세요: ");
		int age = sc.nextInt(); sc.nextLine();
		System.out.print("성별을 입력하세요: ");
		char gender = sc.nextLine().charAt(0);

		String msg = age > 19? 
				gender == '남'? "왼쪽으로가세요." :"오른쪽으로가세요."
						: "미성년자는 출입할 수 없습니다.";
		
		System.out.print(msg);

	}
	
	public void incentive() {
		System.out.print("A의 연봉을 입력하세요: ");
		int salA = sc.nextInt(); sc.nextLine();

		System.out.print("B의 연봉을 입력하세요: ");
		int salB = sc.nextInt(); sc.nextLine();

		System.out.print("C의 연봉을 입력하세요: ");
		int salC = sc.nextInt(); sc.nextLine();

		int sum = salA + salB + salC;
		System.out.print("회사 연봉의 총합은: " + sum + "만원");
//
//		String msgA = salA*1.04 >= 3000? "한턱쏴" : "내가쏠게";
//		String msgB = salB >= 3000? "한턱쏴" : "내가쏠게";
//		String msgC = salC >= 3000? "한턱쏴" : "내가쏠게";
//
//		System.out.println("A의 인센티브포함한 급여는: " +  + "만원\t" + );
////		5 0 1%

		//연봉
		//총합
		//평균
		//인센 + 쏴/내가
	}
}
