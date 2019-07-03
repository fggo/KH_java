package logic.controller;

import logic.view.Menu;

public class Function {
	public void calculator() {
		System.out.print("ù��° ����: ");
		int n1 = Menu.CONSOLE.nextInt(); 
		System.out.print("�ι�° ����: ");
		int n2 = Menu.CONSOLE.nextInt();
		System.out.print("���깮��: ");
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
				System.out.println("0���� ���� �� �����ϴ�");
				result = 0;
			}
			else 
				result = n1 /n2;
			break;
		default:
			System.out.println("�����ڸ� �߸��Է��ϼ̽��ϴ�.");
			break;
		}

		System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
	}

	public void totalCalculator() {
		System.out.print("����1 �Է�: ");
		int n1 = Menu.CONSOLE.nextInt();
		System.out.print("����2 �Է�: ");
		int n2 = Menu.CONSOLE.nextInt();
		
		int small = n1<n2? n1:n2;
		int big = n1>n2? n1:n2;

		int sum = 0;
		for(int i =small; i<= big; i++) 
			sum += i;
		
		System.out.println(small + "���� " + big 
				+" ������ �հ�: " + sum);
	}
	
	public void profile() {
		if(Menu.CONSOLE.hasNextLine())
			Menu.CONSOLE.nextLine();
		
		System.out.print("�̸�: ");
		String name = Menu.CONSOLE.nextLine();

		System.out.print("����: ");
		int age = Menu.CONSOLE.nextInt(); Menu.CONSOLE.nextLine();

		System.out.print("����: ");
		String gender = Menu.CONSOLE.nextLine();

		System.out.print("����: ");
		String personality = Menu.CONSOLE.nextLine();

		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);
		System.out.println("����: " + gender + "��");
		System.out.println("����: " + personality );
	}

	public void sungjuk() {
		if(Menu.CONSOLE.hasNextLine())
			Menu.CONSOLE.nextLine();
		
		System.out.print("�̸�: ");
		String name = Menu.CONSOLE.nextLine();

		System.out.print("�г�: ");
		int year = Menu.CONSOLE.nextInt();

		System.out.print("��: ");
		int classRoom = Menu.CONSOLE.nextInt();

		System.out.print("��ȣ: ");
		int number = Menu.CONSOLE.nextInt();

		System.out.print("����(M/F): ");
		char gender = Menu.CONSOLE.next().charAt(0);
		gender = (gender =='M'? '남': '여');

		System.out.print("����: ");
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

		System.out.printf("%d�г� %d�� %d�� %c�л� %s�� ������ %.2f�̰�, %c�����Դϴ�.\n",
				year, classRoom, number, gender, name, grade, letterGrade);
	}
	
	public void printStarNumber() {
		System.out.print("���������� �Է�: ");
		int num = Menu.CONSOLE.nextInt();
		if (num <1) {
			System.out.println("����� �ƴմϴ�.");
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
		
		System.out.println("1���� 100���� �߻��� ������ �������� �հ�: " + sum); 
	}

	public void continueGugudan() {
		System.out.print("�������� �ϳ� �Է�: ");
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
			System.out.print("�ֻ��� ��(2~12)�� �������ּ���: ");
			guessNum = Menu.CONSOLE.nextInt(); Menu.CONSOLE.nextLine();

			n1 = (int)(Math.random()*6 + 1);
			n2 = (int)(Math.random()*6 + 1);
			
			if (guessNum == n1 + n2)
				System.out.println("������ϴ�.");
			else
				System.out.println("Ʋ�Ƚ��ϴ�.");
			
			System.out.print("����Ͻðڽ��ϱ�?(y/n): ");
			answer = Menu.CONSOLE.next().charAt(0);
		}while(Character.toLowerCase(answer) == 'y');
	}
}
