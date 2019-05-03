package login.controller;

import java.util.Scanner;

public class Function {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void calculator() {
		System.out.print("첫번째 정수: ");
		int n1 = CONSOLE.nextInt(); 
		System.out.print("두번째 정수: ");
		int n2 = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("연산문자: ");
		char operator= CONSOLE.nextLine().charAt(0); 
		
		int result = 0;

		switch(operator) {
		case '+': result = n1 + n2;
			break;
		case '-': result = n1 - n2;
			break;
		case '*': result = n1 * n2;
			break;
		case '/': 
			if (n2==0) {
				System.out.println("0으로 나눌 수 없습니다");
				result = 0;
			}
			else 
				result = n1 /n2;
			break;
		default:
			System.out.println("연사자를 잘못입력하셨습니다.");
			break;
		}

		System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
	}

	public void totalCalculator() {
		System.out.print("정수1 입력: ");
		int n1 = CONSOLE.nextInt();
		System.out.print("정수2 입력: ");
		int n2 = CONSOLE.nextInt();
		
		int small = n1<n2? n1:n2;
		int big = n1>n2? n1:n2;

		int sum = 0;
		for(int i =small; i<= big; i++) 
			sum += i;
		
		System.out.println(small + "부터 " + big 
				+" 까지의 합계: " + sum);
	}
	
	public void profile() {
		System.out.print("이름: ");
		String name = CONSOLE.nextLine();
		System.out.print("나이");
		int age = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("성별: ");
		char gender = CONSOLE.nextLine().charAt(0);
		gender = gender =='M'? '남': gender=='F'? '여' :'\u0000';
		System.out.print("성격: ");
		String personality = CONSOLE.nextLine();

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("성별: " + gender + "자");
		System.out.println("성격: " + personality );
	}

	public void sungjuk() {
		System.out.print("이름: ");
		String name = CONSOLE.nextLine();
		System.out.print("학년: ");
		int year = CONSOLE.nextInt();
		System.out.print("반: ");
		int classRoom = CONSOLE.nextInt();
		System.out.print("번호: ");
		int number = CONSOLE.nextInt(); CONSOLE.nextLine();
		System.out.print("성별(M/F): ");
		char gender = CONSOLE.nextLine().charAt(0);
		gender = gender =='M'? '남': gender=='F'? '여' :'?';
		System.out.print("성적: ");
		double grade = CONSOLE.nextDouble(); CONSOLE.nextLine();
		
		char letterGrade = '\u0000';
		if(grade >= 90)
			letterGrade = 'A';
		else if(grade>=80)
			letterGrade = 'B';
		else if(grade >= 70)
			letterGrade = 'C';
		else if (grade >=60)
			letterGrade = 'D';
		else
			letterGrade ='F';

		System.out.printf("%d학년 %d반 %d번 %c학생 %s의 점수는 %.2f이고, %c학점입니다.\n",
				year, classRoom, number, gender, name, grade, letterGrade);
	}
	
	public void printStarNumber() {

	}
	
	public void sumRandomNumber() {
		
	}

	public void continueGugudan() {
		
	}
	
	public void shutNumber() {
		
	}
}
