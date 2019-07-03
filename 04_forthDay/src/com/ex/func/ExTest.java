package com.ex.func;

import java.util.Scanner;

public class ExTest {
	public void cal() {
		Scanner sc = new Scanner(System.in);

		int n1, n2;

		//���꿡 ����� ���� �Է�
		System.out.print("���� n1 �Է�: ");
		n1 = sc.nextInt(); sc.nextLine();
		System.out.print("���� n2 �Է�: ");
		n2 = sc.nextInt(); sc.hasNextLine();
		
		//������ ����
		int add = n1 + n2;
		int minus = n1 - n2;
		int multi = n1 * n2;
		double div = (double)n1 / n2;
		int mod = n1 % n2;

		//������ ���
		System.out.println("\n���ϱ���:\tn1 + n2 = " + add);
		System.out.println("������:\tn1 - n2 = " + minus);
		System.out.println("���ϱ���:\tn1 * n2 = " + multi);
		System.out.println("��������:\tn1 / n2 = " + div);
		System.out.println("��������:\tn1 % n2 = " + mod);
		System.out.println("");
		
		//�񱳿�����
		boolean b1 = n1 <= n2;
		boolean b2 = n1 != n2;
		boolean b3 = n1>n2;
		boolean b4 = n1 == n2;

		System.out.printf("%d <= %d�� %b �Դϴ�.\n", n1, n2, b1);
		System.out.printf("%d != %d�� %b �Դϴ�.\n", n1, n2, b2);
		System.out.printf("%d > %d�� %b �Դϴ�.\n", n1, n2, b3);
		System.out.printf("%d == %d�� %b �Դϴ�.\n", n1, n2, b4);
		System.out.println();
		
		int inputNum1, inputNum2;
		System.out.print("�����Է� 1: ");
		inputNum1 = sc.nextInt(); sc.nextLine();
		
		System.out.print("�����Է� 2: ");
		inputNum2 = sc.nextInt(); sc.nextLine();

		boolean flagA = inputNum1 % 2 == 0;
		boolean flagB = inputNum2 % 3 == 0;
		
		System.out.println(flagA);
		System.out.println(flagB);

		if(inputNum1 % 2 == 0)
			System.out.println(inputNum1 + " �� 2�ǹ���Դϴ�.");
		else if (inputNum1 % 3 == 0)
			System.out.println(inputNum1 + " �� 3�ǹ���Դϴ�.");
		if(inputNum2 % 2 == 0)
			System.out.println(inputNum2 + " �� 2�ǹ���Դϴ�.");
		else if (inputNum2 % 3 == 0)
			System.out.println(inputNum2 + " �� 3�ǹ���Դϴ�.");
		
		//�Ϲݳ� ������.
		//�񱳿�����(����)�� �ΰ��̻� ������ ���
		boolean flagC = true;
		boolean flagD = false;

		System.out.println(flagC && flagD);
		System.out.println(flagC || flagD);
		
		int age = 19;
		char gender = 'M';
		boolean flagMili = true;

		System.out.println(age > 19 && gender == 'M' && flagMili);
		System.out.println(age > 19 || gender == 'M' && flagMili);
		System.out.println(age > 19 && gender == 'M' || flagMili);
	}
}
