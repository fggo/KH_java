package com.kh.array.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayController {
	public static final Scanner CONSOLE= new Scanner(System.in);

	public void arrayTest() {
		//intArr(reference 타입 변수): stack에 주소값 저장
		//오른쪽 초기화 값(배열)은 heap에 메모리 생성 (배열 = 객체)
		int[] intArr = new int[5]; //default 0
		for(int i =0; i<intArr.length; i++) 
			System.out.print(intArr[i] + " ");

		//주소값 출력
		System.out.println("\n" + intArr);

		//배열에 저장된 값 변경
		intArr[0] = 111;
		intArr[intArr.length - 1] = 123;
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (i+1)*10; //array element 값변경
			System.out.println(++intArr[i]); //array element 값변경; 1증가
		}

		//선언과 동시에 초기화
		char[] ch =  {'가', '나', '다', '라', '마', '바'};
		
		for(int i =0; i< ch.length; i++) 
			if(ch[i] == '다') ch[i] = '하';

		System.out.println(ch);
		
		//입력값으로 배열 초기화
		for(int i =0; i<intArr.length; i++) {
			System.out.print("배열에 저장할 정수 입력:  ");
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
		String [] fruits = {"딸기", "바나나", "복숭아", "키위", "사과"};
		for(int i =0 ;i <fruits.length; i++) {
			if(fruits[i].equals("복숭아")) {
				System.out.println(fruits[i] 
						+ " has index " + i);
			}
		}
		//과일 순서 랜덤 리스트 생성
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
			System.out.print((i+1) + "번째 입력: ");
			c[i] = CONSOLE.next().charAt(0);
		}

		System.out.println(c);
		System.out.println("첫번째: " + c[0]);
		System.out.println("마지막: " + c[c.length - 1]);
		
		for(int i=c.length -1 ; i>=0; i--)
			System.out.print(c[i]);

		System.out.println();
	}
	
	public void countLetter() {
		System.out.print("문자열 입력: ");
		String str = CONSOLE.nextLine();
		System.out.print("문자 입력: ");
		char ch = CONSOLE.nextLine().charAt(0);

		char[] charArr = str.toCharArray();

		int count = 0;
		for(int i =0 ; i<charArr.length; i++) {
			if (charArr[i] == ch)
				count++;
		}
		System.out.println("입력하신 문자열 " + str +"에서\n"
				+ "찾으시는 문자 \'" + ch + "\'은 " + count + "개 입니다.");
	}
	
	public void hideID() {
		System.out.print("주민등록 번호 입력 : ");
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
		System.out.print("홀수를 입력하세요 (0보다 큰): ");
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

		//로또 번호 생성
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
		
		//로또 번호 오름차순 정렬
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

		System.out.println("로또 번호 당첨결과 : ");
		for(int i =0; i<lottoNums.length; i++)
			System.out.print(lottoNums[i] + " ");
	}
}
