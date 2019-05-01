package com.kh.controller2;

import java.util.Scanner;

public class Controller {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void exForTest() {
		for(int i =0 ;i<5; i++) {}
		
		int num = 0;
		for(;num<10; num++) {
			System.out.println("print " + num);
		}
		
//		infinite loop
//		for(;;) {}

		int num2 = 10;
		for(; num2==10;) {
			num++;
			if(num==20) num2 = 20;
		}
//		for(int n= 0; n< 10; num+=2, n++) {}
	}
	
	public void whileTest() {
		int i = 0;
		/* while */
		while(i++ < 10) {
			/*1부터 10까지 숫자를 출력하세요. */
//			System.out.print(i+ " ");
			/*10부터 0까지 숫자를 출력하세요.*/
//			System.out.print((11-i) + " ");
			/* 1부터 10까지 홀수만 출력하세요. */
			if(i %2== 1) System.out.print(i + " ");
		}

		System.out.print("\n정수를 입력하세요: ");
		int n = CONSOLE.nextInt(); 
		i = 0;
		int sum = 0;
		while(i++ <n) {
			/* 입력 받은 정수까지의 홀수를 출력하세요 */
			if(i %2 == 1)
				System.out.print(i + " ");
			/* 입력 받은 정수까지의 홀수의 합을 출력하세요. */
			sum += i;
			i++;
		}
		System.out.println("\n1~" + n + " 까지 홀수의 합 : " + sum);
		
		/* do~while */
		int num2 = 3;
		do {
			System.out.println("이것이 실행됩니까?");
		} while(num2++ < 5);
	}
	
	public void stringMethod() {
		boolean flag = true;
		int count = 0;
		char answer;

		while(flag) {
			count = 0;
			System.out.print("문자열을 입력하세요: ");
			String str = CONSOLE.nextLine().toLowerCase();
			System.out.print("문자열을 입력하세요: ");
			char ch = CONSOLE.nextLine().charAt(0);
			
			for(int i =0 ;i<str.length(); i++)
				if(str.charAt(i) == ch)
					count++;
			System.out.println("포함된 갯수 : " + count);

			System.out.print("계속 하시겠습니까? (Y/N) ");
			answer = CONSOLE.nextLine().charAt(0);
			if(answer =='N' || answer =='n') {
				flag = false;
				System.out.println("프로그램을 종료합니다.");
			}
		}
	}
	
	public void breakTest() {
		for(int i =0 ;; i++) {
			if(i == 10) {
				System.out.println("Break for statement!!");
				break;
			}
		}
		
		boolean flag = true;

		while(flag) {
			System.out.println("===음식주문프로그램===");
			System.out.println("1.돈가스");
			System.out.println("2.콩나물국밥");
			System.out.println("3.알탕");
			System.out.println("4.회덮밥");
			System.out.println("5.샌드위치");
			System.out.print("메뉴 번호:  ");
			int choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case 1: System.out.println("돈가스 주문완료"); break;
				case 2: System.out.println("콩나물국밥 주문완료"); break;
				case 3: System.out.println("알탕 주문완료"); break;
				case 4: System.out.println("회덮밥 주문완료"); break;
				case 5: System.out.println("샌드위치 주문완료"); break;
				case 0: System.out.println("프로그램을 종료합니다."); break;
				default: System.out.println("주문메뉴를 다시정해주세요 (1~5): "); break;
			}
			if (choice == 0) break;
		}
	}

	public void computeChange() {
		System.out.print("받으신 금액을 입력하세요: ");
		int yourMoney = CONSOLE.nextInt();
		System.out.print("상품 가격을 입력하세요.");
		int price = CONSOLE.nextInt();
		int moneyToReturn = yourMoney - price;
		System.out.println("거스름돈: " + moneyToReturn + "원");

		int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int temp = moneyToReturn;

		System.out.println("====================");
		for(int i =0 ;i<bills.length; i++) {
			System.out.println(bills[i] + "원권 지폐 "
					+ temp /bills[i]+ "장");
			temp = temp % bills[i];
		}
		System.out.println("====================");
		System.out.println("거스름돈: " + moneyToReturn +"원");
	}
	
	public void testRandom() {
		for(int i =0; i<5; i++) {
			//random*10 == 0~9사이의 임의의 수
//			System.out.println((int)(Math.random()*10 + 1));
			//random*60 == 1~60
//			System.out.println((int)(Math.random()*60)+ 1);
		}
	}
	
	public void silsub() {
		/* 회원정보 입력 */
		System.out.print("입력할 총 회원 수 : ");
		int enrollNum = CONSOLE.nextInt(); CONSOLE.nextLine();
		String personInfo = "";
		int sumAge = 0;
		double sumHeight = 0;
		double sumWeight = 0;

		for(int i =0; i<enrollNum; i++) {

			System.out.print("이름: ");
			String name = CONSOLE.nextLine();
			System.out.print("나이: ");
			int age = CONSOLE.nextInt(); CONSOLE.nextLine();
			System.out.print("사는곳: ");
			String location = CONSOLE.nextLine();
			System.out.print("키: ");
			double height = CONSOLE.nextDouble();
			System.out.print("몸무게: ");
			double weight = CONSOLE.nextDouble(); CONSOLE.nextLine();
			System.out.print("전화번호: ");
			String phone = CONSOLE.nextLine();
			
			sumAge += age;
			sumHeight += height;
			sumWeight += weight;
			
			personInfo +=
					name + "\t" + age +"세\t" + location
					+ "\t" + height+ "cm\t" + weight + "kg\t"
					+ phone + "\n";
		}
		System.out.println("=========== 저장회원==========");
		System.out.println(personInfo);
		System.out.printf("평균나이: %d/"
				+ "평균 키: %.2f / 평균 몸무게: %.2f",
				sumAge/enrollNum, sumHeight/enrollNum, 
				sumWeight/enrollNum);
	}
	
	public void guessRandom() {
		int randNum = (int)(Math.random()*100 + 1);

		int count = 0;
		int num = 0;

		while(true) {
			System.out.print("1~100 사이 정수를 입력하세요: ");
			num = CONSOLE.nextInt();

			count++;
			if(num == randNum) {
				System.out.println("입력하신 " + num + "은"
						+ "난수와 일치합니다!!!");
				break;
			}
			else if( num < randNum) {
				System.out.println("입력하신 " + num + "은"
						+ "난수보다 작습니다.");
			}
			else {
				System.out.println("입력하신 " + num + "은"
						+ "난수보다 큽니다.");
			}
		}
		System.out.println("난수를 맞추기 까지 " 
			+ count + "회 시도하였습니다.");
	}
	
	public void checkPrimary() {
		System.out.print("2보다 큰 정수를 입력하세요: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();

		if (num <= 2)
			System.out.println("숫자를 잘못 입력하셨습니다.");
			
		boolean isPrimary = true;

		for(int i = 2; i <num; i++) 
			if (num%i == 0)
				isPrimary = false;
		
		if(isPrimary)
			System.out.println("소수입니다.");
		else
			System.out.println("소수가 아닙니다.");
	}
}
