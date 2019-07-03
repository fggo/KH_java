package com.kh.array.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayController {
	public static final Scanner CONSOLE= new Scanner(System.in);

	public void arrayTest() {
		//intArr(reference Ÿ�� ����): stack�� �ּҰ� ����
		//������ �ʱ�ȭ ��(�迭)�� heap�� �޸� ���� (�迭 = ��ü)
		int[] intArr = new int[5]; //default 0
		for(int i =0; i<intArr.length; i++) 
			System.out.print(intArr[i] + " ");

		//�ּҰ� ���
		System.out.println("\n" + intArr);

		//�迭�� ����� �� ����
		intArr[0] = 111;
		intArr[intArr.length - 1] = 123;
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (i+1)*10; //array element ������
			System.out.println(++intArr[i]); //array element ������; 1����
		}

		//����� ���ÿ� �ʱ�ȭ
		char[] ch = {'가', '나', '다'};
		for(int i =0; i< ch.length; i++) 
			if(ch[i] == '나') ch[i] = '너';

		System.out.println(ch);
		
		//�Է°����� �迭 �ʱ�ȭ
		for(int i =0; i<intArr.length; i++) {
			System.out.print("�迭�� ������ ���� �Է�:  ");
			intArr[i] = CONSOLE.nextInt(); CONSOLE.nextLine();
		}
	}

	public void changeArraySize() {
		int[] arr2 = new int[10];
		for(int i =0; i<10; i++)
			arr2[i] = i+1;
		
		arr2 = new int[100];
		for(int i =0; i< arr2.length; i++) {
			arr2[i] = i +1 ;
		}
		for(int i =0; i <arr2.length; i++) {
			System.out.print(arr2[i] + " ");
			if(i==arr2.length-1) System.out.println();
		}
	}
	
	public void findFruit() {
		String [] fruits = {"����", "�ٳ���", "������", "Ű��", "���"};
		for(int i =0 ;i <fruits.length; i++) {
			if(fruits[i].equals("������")) {
				System.out.println(fruits[i] 
						+ " has index " + i);
			}
		}
		//���� ���� ���� ����Ʈ ����
		ArrayList<Integer> list = new ArrayList<Integer>(fruits.length);
		String[] fruits2 = new String[5];

		int rand = 0, index =0;
		while(list.size() < 5) {
			rand = (int)(Math.random()*5);
			if(!list.contains(rand)) {
				list.add(rand);
				fruits2[rand] = fruits[index++];
			}
		}
		
		for(int i =0; i<fruits2.length; i++)
			System.out.print(fruits2[i] + " ");
	}

	public void printArrElement() {
		char [] c = new char[5];
		for(int i =0; i<5; i++) {
			System.out.print((i+1) + "��° �Է�: ");
			c[i] = CONSOLE.next().charAt(0);
		}

		System.out.println(c);
		System.out.println("ù��°: " + c[0]);
		System.out.println("������: " + c[c.length - 1]);
		
		for(int i=c.length -1 ; i>=0; i--)
			System.out.print(c[i]);

		System.out.println();
	}
	
	public void countLetter() {
		System.out.print("���ڿ� �Է�: ");
		String str = CONSOLE.nextLine();
		System.out.print("���� �Է�: ");
		char ch = CONSOLE.nextLine().charAt(0);

		char[] charArr = str.toCharArray();

		int count = 0;
		for(int i =0 ; i<charArr.length; i++) {
			if (charArr[i] == ch)
				count++;
		}
		System.out.println("�Է��Ͻ� ���ڿ� " + str +"����\n"
				+ "ã���ô� ���� \'" + ch + "\'�� " + count + "�� �Դϴ�.");
	}
	
	public void hideID() {
		System.out.print("�ֹε�� ��ȣ �Է� : ");
		String id = CONSOLE.nextLine();

		char[] charArr = id.toCharArray();
		char[] copyArr = new char[id.length()];

		System.arraycopy(charArr, 0, copyArr, 0, charArr.length);
//		copyArr = charArr.clone();

		for(int i =0 ; i<copyArr.length; i++) {
			if (i>=7) copyArr[i] = '*';
			System.out.print(copyArr[i]);
		}
	}
	
	public void makeOddArray() {
		System.out.print("Ȧ���� �Է��ϼ��� (0���� ū): ");
		int length = CONSOLE.nextInt();
		int[] oddArray = new int[length];
		int count = 0;
		
		for(int i =0; i<length; i++) {
			if(i <=length/2)
				oddArray[i] = ++count;
			else
				oddArray[i] = --count;
			System.out.print(oddArray[i] + " ");
		}
	}
	
	public void lottoGenerator() {
		int[] lottoNums = new int[7];
		int random = 0;

		//�ζ� ��ȣ ����
		for(int i =0; i<lottoNums.length; i++) {
			random = (int)(Math.random()*45 + 1);

			lottoNums[i] = random;

			for (int j= 0; j<i; j++) {
				if (lottoNums[j] == random) {
					i--;
					break;
				}
			}
		}
		
		//�ζ� ��ȣ �������� ����
		int temp = 0;
		for(int i = 0; i<lottoNums.length; i++) {
			for(int j = i ; j < lottoNums.length; j++) {
				if (lottoNums[j] < lottoNums[i]) {
					temp = lottoNums[i];
					lottoNums[i] = lottoNums[j];
					lottoNums[j] = temp;
				}
			}
		}

		System.out.println("�ζ� ��ȣ ��÷��� : ");
		for(int i =0; i<lottoNums.length; i++)
			System.out.print(lottoNums[i] + " ");
	}
}
