package logic.controller;

import logic.view.Menu;

public class Function {
	public void calculator() {
		System.out.print("첫번째 정수: ");
		int n1 = Menu.CONSOLE.nextInt(); 
		System.out.print("두번째 정수: ");
		int n2 = Menu.CONSOLE.nextInt();
		System.out.print("연산문자: ");
		char operator= Menu.CONSOLE.next().charAt(0); 
		
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
		int n1 = Menu.CONSOLE.nextInt();
		System.out.print("정수2 입력: ");
		int n2 = Menu.CONSOLE.nextInt();
		
		int small = n1<n2? n1:n2;
		int big = n1>n2? n1:n2;

		int sum = 0;
		for(int i =small; i<= big; i++) 
			sum += i;
		
		System.out.println(small + "부터 " + big 
				+" 까지의 합계: " + sum);
	}
	
	public void profile() {
		if(Menu.CONSOLE.hasNextLine())
			Menu.CONSOLE.nextLine();
		
		System.out.print("이름: ");
		String name = Menu.CONSOLE.nextLine();

		System.out.print("나이: ");
		int age = Menu.CONSOLE.nextInt(); Menu.CONSOLE.nextLine();

		System.out.print("성별: ");
		String gender = Menu.CONSOLE.nextLine();

		System.out.print("성격: ");
		String personality = Menu.CONSOLE.nextLine();

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("성별: " + gender + "자");
		System.out.println("성격: " + personality );
	}

	public void sungjuk() {
		if(Menu.CONSOLE.hasNextLine())
			Menu.CONSOLE.nextLine();
		
		System.out.print("이름: ");
		String name = Menu.CONSOLE.nextLine();

		System.out.print("학년: ");
		int year = Menu.CONSOLE.nextInt();

		System.out.print("반: ");
		int classRoom = Menu.CONSOLE.nextInt();

		System.out.print("번호: ");
		int number = Menu.CONSOLE.nextInt();

		System.out.print("성별(M/F): ");
		char gender = Menu.CONSOLE.next().charAt(0);
		gender = (gender =='M'? '남': '여');

		System.out.print("성적: ");
		double grade = Menu.CONSOLE.nextDouble();
		
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
		System.out.print("양의정수를 입력: ");
		int num = Menu.CONSOLE.nextInt();
		if (num <1) {
			System.out.println("양수가 아닙니다.");
			return;
		}

		String str = "";
		for(int i =0 ;i<num; i++) {
			str = String.format("%" + (i+1) + "s", String.valueOf(i+1)).replace(' ', '*');
			System.out.println(str);
		}
		System.out.println("================");
	}
	
	public void sumRandomNumber() {
		int sum = 0;
		for (int i =0; i<100; i++)
			sum += (int)(Math.random()*100 + 1);
		
		System.out.println("1부터 100까지 발생된 임의의 정수들의 합계: " + sum); 
	}

	public void continueGugudan() {
		System.out.print("양의정수 하나 입력: ");
		int num = Menu.CONSOLE.nextInt();

		for(int i =1; i<=9; i++) {
			if(i%num == 0)
				continue;
			System.out.println(num + " * " + i + " = " +(num * i));
		}
		System.out.println("================");
	}
	
	public void shutNumber() {
		int guessNum = 0;
		char answer = '\u0000';

		int n1 = 0, n2 = 0;
		do {
			System.out.print("주사위 합(2~12)을 예상해주세요: ");
			guessNum = Menu.CONSOLE.nextInt(); Menu.CONSOLE.nextLine();

			n1 = (int)(Math.random()*6 + 1);
			n2 = (int)(Math.random()*6 + 1);
			
			if (guessNum == n1 + n2)
				System.out.println("맞췄습니다.");
			else
				System.out.println("틀렸습니다.");
			
			System.out.print("계속하시겠습니까?(y/n): ");
			answer = Menu.CONSOLE.next().charAt(0);
		}while(Character.toLowerCase(answer) == 'y');
	}
}
