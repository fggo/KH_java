package silsub.sample;

import java.util.Scanner;

public class Munjae {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void test1() {

		System.out.print("국어점수: ");
		int kor = CONSOLE.nextInt();
		System.out.print("영어점수: ");
		int eng = CONSOLE.nextInt();
		System.out.print("수학점수: ");
		int math = CONSOLE.nextInt(); CONSOLE.nextLine();

		int sum = kor + eng + math;
		double avg = sum / 3.0;

		boolean overForty = kor >= 40
						 && eng >= 40
						 && math >= 40;
		System.out.println("합계: " + sum);
		System.out.printf("평균: %.2f\n", avg);

		if(overForty && avg >= 60)
			System.out.println("합격 입니다.");
		else
			System.out.println("불합격 입니다.");
	}
	
	public void test2() {
		showMenu();

		int choice = CONSOLE.nextInt(); CONSOLE.nextLine();

		switch(choice) {
		case 1:
			System.out.println("입력메뉴가 선택되었습니다.");
			break;
		case 2:
			System.out.println("수정메뉴가 선택되었습니다.");
			break;
		case 3:
			System.out.println("조회메뉴가 선택되었습니다.");
			break;
		case 4:
			System.out.println("삭제메뉴가 선택되었습니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
		default:
			System.out.println("번호가 잘못 입력 되었습니다.\n다시 입력하십시오.");
		}
	}
	
	public void showMenu() {
		System.out.println("***초기 메뉴***");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회"); 
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴번호 입력: ");
	}
	
	public void test3() {
		System.out.print("정수 입력: ");
		int num = CONSOLE.nextInt();
		if(num > 0)
			System.out.println("양수다.");
		else if (num < 0)
			System.out.println("음수다.");
		else
			System.out.println("0이다.");
	}

	public void test4() {
		System.out.print("정수 입력: ");
		int num = CONSOLE.nextInt();
		if(num % 2 == 0)
			System.out.println("짝수다.");
		else
			System.out.println("홀수다.");
	}
	
	public void inputTest() {
		
		System.out.print("이름: ");
		String name = CONSOLE.next();
		System.out.print("나이: ");
		int age = CONSOLE.nextInt();
		System.out.print("키: ");
		double height = CONSOLE.nextDouble();
		
		if (name != null
				&& name.length() > 0 
				&& age > 0 
				&& height >0) {
			System.out.println("이름: " + name);
			System.out.println("나이: " + age);
			System.out.println("키: " + height);
			System.out.printf("확인: %s의 나이는 %d세이고, 키는 %.2f cm 이다.", 
					name, age, height);
		}
		else {
			System.out.println("이름을 잘못입력 했습니다.");
		}
	}
	public void test6() {
		System.out.print("정수1: ");
		int n1= CONSOLE.nextInt();

		System.out.print("정수2: ");
		int n2 = CONSOLE.nextInt();
	
		if (n1 > 0 && n2 > 0) {
			System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
			System.out.println(n1 + " - " + n2 + " = " + (n1-n2));
			System.out.println(n1 + " * " + n2 + " = " + (n1*n2));
			System.out.println(n1 + " / " + n2 + " = " + (n1/n2));
			System.out.println(n1 + " % " + n2 + " = " + (n1%n2));
		}
		else {
			System.out.println("정수를 잘못 입력 하셨습니다."); 
		}
	}

	public void test7() {
		System.out.print("점수: ");
		int score = CONSOLE.nextInt();

		String grade = "";

		if (score > 100 || score <0) {
			System.out.println("점수를 잘못입력 하셨습니다.");
		}
		else if(score >= 90) {
			grade = "A";
			if(score >= 95) grade += "+";
		}
		else if (score >=80) {
			grade = "B";
			if(score>=85) grade += "+";
		}
		else if(score >=70) {
			grade ="C";
			if (score>=75) grade += "+";
		}
		else if (score >=60) {
			grade = "D";
			if (score>=65) grade += "+";
		}
		else { // 0~59
			grade = "F";
		}
		
		System.out.printf("점수: %d\t학점: %s\n", score, grade);
	}
}