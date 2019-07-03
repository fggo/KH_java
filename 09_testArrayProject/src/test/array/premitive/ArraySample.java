package test.array.premitive;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ArraySample {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void test1() {
		int[] intArr = new int[10];
		int sum = 0;
		
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (int)(Math.random()*100 + 1);
			sum += intArr[i];
		}
		System.out.println("1~100���� ����  10���� ��: " + sum);
	}

	public void test2() {
		int[] intArr = new int[10];
		int max = 0, min = 0;
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (int)(Math.random()*100 + 1);
			if(i == 0) {
				max = intArr[i];
				min = intArr[i];
			}

			if (intArr[i] > max) max = intArr[i];
			if (intArr[i] < min) min = intArr[i];
		}
		System.out.print("�ּ� ����: "+ min + ", �ִ� ����: " + max + "\n");
	}

	public void test3() {
		int[] intArr = new int[10];
		int sum = 0;
		
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (int)(Math.random()*100 + 1);
			if(intArr[i]%2 ==0)
				sum += intArr[i];
		}
		System.out.println("1~100���� ¦���������� ��: " + sum);
	}
	
	public void test4() {
		System.out.print("���ڷε� ���ڿ� �Է�: ");
		String numStr = CONSOLE.nextLine();
		int sum = 0;
		
		for(int i =0; i<numStr.length(); i++) 
			sum += Integer.valueOf(numStr.substring(i, i+1));
			
		System.out.println("�հ�: " + sum);
	}
	
	public void test5() {
		System.out.print("���ڷε� ���ڿ� �Է�: ");
		String numStr = CONSOLE.nextLine();
		int sum = 0;
		
		for(int i =0; i<numStr.length(); i++) {
//			sum += Integer.valueOf(numStr.substring(i, i+1));
			sum += numStr.charAt(i) - '0';
		}
		System.out.println("�հ�: " + sum);
	}
	
	public void test6() {
		String personID = "881225-1234567";
		//�������
		int birthYear = Integer.valueOf("19" + personID.substring(0, 2));
		int birthMonth = Integer.valueOf(personID.substring(2, 4));
		int birthDay = Integer.valueOf(personID.substring(4, 6));

		//����
		Date dt1 = new Date();
		try {
			dt1 = new SimpleDateFormat("yyMMdd")
					.parse(personID.substring(0, 6));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dayOfWeek = new SimpleDateFormat("EEEE").format(dt1);

		//����
		char gender = personID.substring(7, 8).equals("1")? '남':'여';

		//����
		int age = Calendar.getInstance().get(Calendar.YEAR) - birthYear + 1;
		
		System.out.println("===== ���� ���� =====");
		System.out.println("����: " + birthYear);
		System.out.println("��: " + birthMonth);
		System.out.println("��: " + birthDay);
		System.out.println("����: " + dayOfWeek);
		System.out.println("����: " + gender + "��");
		System.out.println("����: " + age);
	}
}
