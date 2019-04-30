package com.kh.day5.function;

import java.util.Scanner;

public class ConditionTest {
	public static final Scanner CONSOLE = new Scanner(System.in);
	
	public void checkGender() {
		System.out.print("당신의 성별은(남,여)? ");
		char gender = CONSOLE.next().charAt(0);

		if(gender == 'M' || gender == '남')
			System.out.println("오른쪽으로 가세요.");
		else if(gender == 'F' || gender == '여') 
			System.out.println("왼쪽으로가세요.");
	}
	
	public void checkAnimal(){
		System.out.print("동물인가요, 식물인가요?");

		String org = CONSOLE.nextLine();

		if(org.equals("동물")) {
			System.out.println(org);
		}
	}
	
	public void checkAge() {
		System.out.print("나이를 입력하세요: ");
		int age = CONSOLE.nextInt();
		
		if (age >=19)
			System.out.println("성인이네요!.");
		else if (age >=17) 
			System.out.println("고딩이네요!!!");
		else if(age>= 14) 
			System.out.println("중딩이네요.");
		else if (age >= 8) 
			System.out.println("초딩이네요!!!");
		else if (age > 0)
			System.out.println("아기네요!");
		else
			System.out.println("나이는 음수가 불가능합니다.");
	}

	public void checkGrade() {
		int kor, eng, math;
		System.out.print("국어점수: ");
		kor = CONSOLE.nextInt();
		System.out.print("영어점수: ");
		eng = CONSOLE.nextInt();
		System.out.print("수학점수: ");
		math = CONSOLE.nextInt();

		int sum = kor + eng + math;

		if(sum >= 250) {
			System.out.println("우수생입니다.");
		}
		
		double avg = sum / 3.0;

		String grade;
		if(avg >= 90 && avg <=100) {
			grade = "A";
			if(avg >= 95) grade += "+";
			else grade += "-";
		}
		else if (avg >=80) {
			grade = "B";
			if(avg>=85) grade += "+";
			else grade += "-";
		}
		else if(avg >=70) {
			grade ="C";
		}
		else if (avg >=60)
			System.out.println("D");
		else
			System.out.println("F");

		boolean overForty = kor >= 40 
					&& eng >= 40
					&& math >=40;

		if (overForty && avg >=60) 
			System.out.println("합격!");
		else
			System.out.println("불합격!!");
	}
	
	public void checkSal() {
		System.out.println("A의 연봉을 입력하세요: ");
		int salA = CONSOLE.nextInt();
		System.out.println("B의 연봉을 입력하세요: ");
		int salB = CONSOLE.nextInt();
		System.out.println("C의 연봉을 입력하세요: ");
		int salC = CONSOLE.nextInt();
		
		if(salA >= 5000)
			System.out.println("A는 고액연봉자입니다.");
		if(salB >= 5000)
			System.out.println("B는 고액연봉자입니다. ");
		if(salC >= 5000)
			System.out.println("C는 고액연봉자입니다.");
	}

	public void modByTwo() {
		System.out.print("정수를 입력하세요: ");
		int num = CONSOLE.nextInt();

		if (num% 2 == 0)
			System.out.println("짝수다.");
		else
			System.out.println("홀수다.");
	}

	public void printStudentInfo() {
		System.out.print("이름: ");
		String name = CONSOLE.nextLine();
		
		System.out.print("학년: ");
		int year = CONSOLE.nextInt();
		
		System.out.print("반: ");
		int classRoom = CONSOLE.nextInt();
	
		System.out.print("번호: ");
		int number = CONSOLE.nextInt();
		
		System.out.print("성별(M/F): ");
		char gender = CONSOLE.next().charAt(0);

		if(gender == 'M' || gender == '남') gender = '남';
		else if(gender == 'F' || gender == '여') gender = '여';
		else gender = '?';

		System.out.print("성적: ");
		double grade = CONSOLE.nextDouble(); CONSOLE.nextLine();
		
		System.out.printf("%d학년 %d반 %d번 %c학생 %s은 성적이 %.2f이다.",
				year, classRoom, number, gender, name, grade);
	}

	public void runCalculator() {
		System.out.print("정수1: ");
		int n1= CONSOLE.nextInt();

		System.out.print("정수2: ");
		int n2 = CONSOLE.nextInt();
		System.out.print("연산자(+ - * /), : ");
		char op = CONSOLE.next().charAt(0);

		int result;
	
		if ((n1 > 0 && n2 > 0)
				&& (op == '+' || op == '-' || op != '*' || op != '/')) {
			if(op == '+') {
				result = n1+n2;
				System.out.println(n1 + " + " + n2 + " = " + result);
			}
			else if(op == '-') {
				result = n1 - n2;
				System.out.println(n1 + " - " + n2 + " = " + result);
			}
			else if (op == '*') {
				result = n1 * n2;
				System.out.println(n1 + " * " + n2 + " = " + result);
			}
			else if (op == '/') {
				result = n1 /n2;
				System.out.println(n1 + " / " + n2 + " = " + result);
			}
		}
		else {
			System.out.println("잘못 입력 하셨습니다."); 
		}
	}	
		public void checkEvenNum() {
		System.out.print("정수를 입력하세요 (1~10): ");
		int num = CONSOLE.nextInt();
		
		if(num >= 1 && num <= 10) {
			if(num %2 == 0) 
				System.out.println("짝수입니다.");
			else
				System.out.println("홀수입니다.");
		}
		else {
			System.out.println("숫자가 1~10사이 숫자가 아닙니다.");
		}
	}

	public void login() {
		System.out.print("아이디입력: ");
		String id = CONSOLE.nextLine();
		System.out.print("패스워드 입력: ");
		String pw = CONSOLE.nextLine();
		if(id.equals("admin")) {
			if(pw.equals("1234")){
				System.out.println("로그인성공");
				System.out.println("====회원관리====");
				System.out.println("1. 회원등록");
				System.out.println("2. 회원검색");
				System.out.println("3. 회원삭제");
			}
			else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
		else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}
}