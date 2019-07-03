package kh.operator.function;

import java.util.Scanner;

public class Example {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void opSample1() {
		int kor, eng, math;
		int total;
		double avg;
		
		System.out.print("���� ����: ");
		kor = CONSOLE.nextInt();
		System.out.print("���� ����: ");
		eng = CONSOLE.nextInt();
		System.out.print("���� ����: ");
		math = CONSOLE.nextInt(); CONSOLE.nextLine();
	
		total = kor + eng + math;
		avg = total / 3.0;
		System.out.println("���� �հ�: " + total);
		System.out.println("���� ��� : " + avg);
		
		boolean passed = kor >= 40 && eng >= 40 && math >= 40 && avg >= 60;
		String resultMsg = passed? "�հ��� �����մϴ�!": "���հ��Դϴ�. ������ �����ϼ���!";
		System.out.println(resultMsg);
	}
	
	public void opSample2() {
		String name;
		int year; // 1~6�г�
		int classRoom; //�� (1~10)
		int number; //��ȣ(1~30)
		char gender; //M/F
		double grade;

		System.out.print("�л��̸�: ");
		name = CONSOLE.nextLine();

		System.out.print("�г�(1~6): ");
		year = CONSOLE.nextInt();

		System.out.print("��(1~10): ");
		classRoom = CONSOLE.nextInt();

		System.out.print("��ȣ(1~30): ");
		number = CONSOLE.nextInt(); CONSOLE.nextLine();

		System.out.print("����(M/F): ");
		gender = CONSOLE.nextLine().charAt(0);
		gender = gender == 'M'? '남': gender == 'F'? '여': '?';

		System.out.print("����: ");
		grade = CONSOLE.nextDouble(); CONSOLE.nextLine();

		System.out.printf("%d�г� %d�� %d�� %c�л� %s�� ������ %.2f�̴�.",
				year, classRoom, number, gender, name, grade);
	}
	
	public void opSample3() {
		System.out.print("���� �Է�: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		
		String msg = num>0? "�����": "����� �ƴϴ�";
		System.out.println(msg);
	}
	
	public void opSample4() {
		System.out.print("���� �Է�: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		
		String msg = num%2 == 0? "¦����": "Ȧ����";
		System.out.println(msg);
	}
}
