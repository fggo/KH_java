package com.kh.controller;

import java.util.Scanner;

public class SwitchController {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void switchTest() {
		System.out.println("당신의 취미는? ");

		System.out.print("취미를 고르세요"
				+ "(1.코딩 2.독서 3.게임 4.유튜브): ");
		int choice = CONSOLE.nextInt();

		switch(choice) {
		case 1: System.out.println("wow"); break;
		case 2: System.out.println("인기서적 순위..."); break;
		case 3: System.out.println("인기게임 순위..."); break;
		case 4: System.out.println("인기동영상..."); break;
		default:
			System.out.println("잘못입력하셨습니다. 1~4번항목을 선택해주세요...");
			break;
		}

		System.out.print("취미를 고르세요"
				+ "(가.코딩 나.독서 다.게임 라.유튜브): ");
		char ch = CONSOLE.next().charAt(0); CONSOLE.nextLine();

		switch(ch) {
		case '가': System.out.println("wow"); break;
		case '나': System.out.println("인기서적 순위..."); break;
		case '다': System.out.println("인기게임 순위..."); break;
		case '라': System.out.println("인기동영상..."); break;
		default:
			System.out.println("잘못입력하셨습니다. 1~4번항목을 선택해주세요...");
			break;
		}
		
		System.out.print("취미를 고르세요"
				+ "(코딩, 독서, 게임, 유튜브): ");
		String str = CONSOLE.nextLine();

		switch(str) {
		case "코딩": printMsg(); break;
		case "독서": System.out.println("인기서적 순위..."); break;
		case "게임": System.out.println("인기게임 순위..."); break;
		case "유튜브": System.out.println("인기동영상..."); break;
		default:
			System.out.println("잘못입력하셨습니다. 1~4번항목을 선택해주세요...");
			return;
		}
	}

	public void printMsg() {
		if(1<0) System.out.println("wow");
		else System.out.println("화이팅");
	}
	
	public void fruitPrice() {
		System.out.print("가격이 궁금한 과일이름을 입력하세요\n"
				+ "(사과, 바나나, 복숭아, 키위): ");
		String fruit = CONSOLE.nextLine();
		
		switch(fruit) {
		case "사과":
			System.out.println(fruit + "의 가격은 1000원 입니다.");
			break;
		case "바나나":
			System.out.println(fruit + "의 가격은 3000원 입니다.");
			break;
		case "복숭아":
			System.out.println(fruit + "의 가격은 2000원 입니다.");
			break;
		case "키위":
			System.out.println(fruit + "의 가격은 5000원 입니다.");
			break;
		default:
			System.out.println("과일을 잘못입력하셨습니다.");
			break;
		}
	}
	
	public void chooseProgramMenu() {
		System.out.println("*******초기 메뉴********");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴번호 입력 : ");

		int choice = CONSOLE.nextInt(); CONSOLE.nextLine();

		switch(choice) {
		case 1: System.out.println("입력메뉴 선택"); break;
		case 2: System.out.println("수정메뉴 선택"); break;
		case 3: System.out.println("조회메뉴 선택"); break;
		case 4: System.out.println("삭제메뉴 선택"); break;
		case 7: System.out.println("프로그램을 종료합니다."); break;
		default: System.out.println("번호가 잘못 입력되었습니다.\r\n" + 
					"프로그램 종료합니다.");
			break;
		}
	}

	public void chooseBunsik() {
		System.out.println("*******메 뉴********");
		System.out.println("떡볶이 ----------------1000");
		System.out.println("김밥 ------------------ 2000");
		System.out.println("오뎅 ------------------ 1000");
		System.out.println("순대 ------------------ 2000");
		System.out.println("튀김 ------------------ 3000");
		System.out.println("떡튀순 ---------------- 8000");
		System.out.print("메뉴번호 입력 : ");

		String food = CONSOLE.nextLine();
		
		switch(food) {
		case "떡볶이": System.out.println(food + "는 1000원 입니다."); break;
		case "김밥": System.out.println(food + "는 2000원 입니다."); break;
		case "오뎅": System.out.println(food + "는 1000원 입니다."); break;
		case "순대": System.out.println(food + "는 2000원 입니다."); break;
		case "튀김": System.out.println(food + "는 3000원 입니다."); break;
		case "떡튀순": System.out.println(food + "는 8000원 입니다."); break;
		default: System.out.println("번호가 잘못 입력되었습니다. \n"
					+ "프로그램을 종료합니다.");
			break;
		}
	}
	
	public void chooseMcFood() {
		System.out.println("*******메 뉴********");
		System.out.println("a. 햄버거 ----------------3000");
		System.out.println("b. 감자튀김 ------------- 2000");
		System.out.println("c. 치킨 ------------------ 5000");
		System.out.println("d. 사이다 ---------------- 1000");
		System.out.println("e. 콜라 ------------------ 1000");
		System.out.print("메뉴번호 입력 : ");

		char choice = CONSOLE.nextLine().charAt(0);
		
		switch(choice) {
		case 'a': System.out.println("햄버거는 300원입니다.");
			break;
		case 'b': System.out.println("햄버거는 3000원입니다.");
			break;
		case 'c': System.out.println("감자튀김은 2000원입니다.");
			break;
//		c 선택시 “치킨은 5000원입니다.” 출력
//		d 선택시 “사이다는 1000원입니다.” 출력
//		e 선택시 “콜라은 1000원입니다.” 출력
//		다른문자 입력시 “번호가 잘못 입력되었습니다. 프로그램
//		종료합니다.”
		}
	}
	
	public void computeGrade() {
		System.out.print("점수를 입력하세요: ");
		int score = CONSOLE.nextInt(); 

		char grade = '\u0000';
		System.out.println(grade);

		switch(score/10) {
			case 10:
			case 9:
				grade = 'A'; break;
			case 8: grade = 'B'; break;
			case 7: grade = 'C'; break;
			case 6: grade = 'D'; break;
			case 5: case 4: case 3: case 2: case 1: case 0:
				grade = 'F'; break;
			default:
				System.out.println("점수를 잘못입력 하셨습니다. \n"
						+ "1~100사이의 점수만 가능합니다.");
		}

		System.out.println(score + "은 " + grade + "입니다.");
	}
	
	public void computeSal() {
		System.out.print("월 급여 입력 : ");
		int sal = CONSOLE.nextInt(); CONSOLE.nextLine();

		System.out.print("월 매출 입력 : ");
		int profit = CONSOLE.nextInt(); CONSOLE.nextLine();
		int profitBonus = 0;
		double bonusRate = 0.0;

		if(profit >= 5000) {
			bonusRate = .05;
			profitBonus = (int)(profit*bonusRate);
		}
		else if (profit >= 3000) {
			bonusRate = .03;
			profitBonus = (int)(profit*bonusRate);
		}
		else if (profit >= 1000) {
			bonusRate = .01;
			profitBonus = (int)(profit*bonusRate);
		}

		sal += profitBonus;
		System.out.println("============");
		System.out.println("매출액 : " + profit);

		System.out.println("보너스율 : " + bonusRate);
		System.out.println("보너스금액 : " + profitBonus);
		System.out.println("============");
		System.out.println("총 급여 : " + sal);
	}
}
