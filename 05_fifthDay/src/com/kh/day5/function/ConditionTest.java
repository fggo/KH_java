package com.kh.day5.function;

import java.util.Scanner;

public class ConditionTest {
	public static final Scanner CONSOLE = new Scanner(System.in);
	
	public void checkGender() {
		System.out.print("����� ������(��,��)? ");
		char gender = CONSOLE.next().charAt(0);

		if(gender == 'M' || gender == '남')
			System.out.println("���������� ������.");
		else if(gender == 'F' || gender == '여') 
			System.out.println("�������ΰ�����.");
	}
	
	public void checkAnimal(){
		System.out.print("�����ΰ���, �Ĺ��ΰ���?");

		String org = CONSOLE.nextLine();

		if(org.equals("����")) {
			System.out.println(org);
		}
	}
	
	public void checkAge() {
		System.out.print("���̸� �Է��ϼ���: ");
		int age = CONSOLE.nextInt();
		
		if (age >=19)
			System.out.println("�����̳׿�!.");
		else if (age >=17) 
			System.out.println("����̳׿�!!!");
		else if(age>= 14) 
			System.out.println("�ߵ��̳׿�.");
		else if (age >= 8) 
			System.out.println("�ʵ��̳׿�!!!");
		else if (age > 0)
			System.out.println("�Ʊ�׿�!");
		else
			System.out.println("���̴� ������ �Ұ����մϴ�.");
	}

	public void checkGrade() {
		int kor, eng, math;
		System.out.print("��������: ");
		kor = CONSOLE.nextInt();
		System.out.print("��������: ");
		eng = CONSOLE.nextInt();
		System.out.print("��������: ");
		math = CONSOLE.nextInt();

		int sum = kor + eng + math;

		if(sum >= 250) {
			System.out.println("������Դϴ�.");
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
			System.out.println("�հ�!");
		else
			System.out.println("���հ�!!");
	}
	
	public void checkSal() {
		System.out.println("A�� ������ �Է��ϼ���: ");
		int salA = CONSOLE.nextInt();
		System.out.println("B�� ������ �Է��ϼ���: ");
		int salB = CONSOLE.nextInt();
		System.out.println("C�� ������ �Է��ϼ���: ");
		int salC = CONSOLE.nextInt();
		
		if(salA >= 5000)
			System.out.println("A�� ��׿������Դϴ�.");
		if(salB >= 5000)
			System.out.println("B�� ��׿������Դϴ�. ");
		if(salC >= 5000)
			System.out.println("C�� ��׿������Դϴ�.");
	}

	public void modByTwo() {
		System.out.print("������ �Է��ϼ���: ");
		int num = CONSOLE.nextInt();

		if (num% 2 == 0)
			System.out.println("¦����.");
		else
			System.out.println("Ȧ����.");
	}

	public void printStudentInfo() {
		System.out.print("�̸�: ");
		String name = CONSOLE.nextLine();
		
		System.out.print("�г�: ");
		int year = CONSOLE.nextInt();
		
		System.out.print("��: ");
		int classRoom = CONSOLE.nextInt();
	
		System.out.print("��ȣ: ");
		int number = CONSOLE.nextInt();
		
		System.out.print("����(M/F): ");
		char gender = CONSOLE.next().charAt(0);

		if(gender == 'M' || gender == '남') gender = '남';
		else if(gender == 'F' || gender == '여') gender = '여';
		else gender = '?';

		System.out.print("����: ");
		double grade = CONSOLE.nextDouble(); CONSOLE.nextLine();
		
		System.out.printf("%d�г� %d�� %d�� %c�л� %s�� ������ %.2f�̴�.",
				year, classRoom, number, gender, name, grade);
	}

	public void runCalculator() {
		System.out.print("����1: ");
		int n1= CONSOLE.nextInt();

		System.out.print("����2: ");
		int n2 = CONSOLE.nextInt();
		System.out.print("������(+ - * /), : ");
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
			System.out.println("�߸� �Է� �ϼ̽��ϴ�."); 
		}
	}	
		public void checkEvenNum() {
		System.out.print("������ �Է��ϼ��� (1~10): ");
		int num = CONSOLE.nextInt();
		
		if(num >= 1 && num <= 10) {
			if(num %2 == 0) 
				System.out.println("¦���Դϴ�.");
			else
				System.out.println("Ȧ���Դϴ�.");
		}
		else {
			System.out.println("���ڰ� 1~10���� ���ڰ� �ƴմϴ�.");
		}
	}

	public void login() {
		System.out.print("���̵��Է�: ");
		String id = CONSOLE.nextLine();
		System.out.print("�н����� �Է�: ");
		String pw = CONSOLE.nextLine();
		if(id.equals("admin")) {
			if(pw.equals("1234")){
				System.out.println("�α��μ���");
				System.out.println("====ȸ������====");
				System.out.println("1. ȸ�����");
				System.out.println("2. ȸ���˻�");
				System.out.println("3. ȸ������");
			}
			else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}
		else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		}
	}
}