package com.kh.array.controller;

import java.util.Scanner;

public class ArrayController {
	public static final Scanner CONSOLE= new Scanner(System.in);

	public void arrayTest() {
		//intArr(reference 타입 변수): stack에 주소값 저장
		//오른쪽 초기화 값(배열)은 heap에 저장
		//array는 객체
		int[] intArr = new int[5]; //heap 메모리에 생성

		//0 if not initialized
		for(int i =0; i<intArr.length; i++) 
			System.out.print(intArr[i] + " ");

		//주소값 출력
		System.out.println("\n" + intArr);

		//배열에 저장된 값 변경
		intArr[0] = 111;
		intArr[1] = 123;
		intArr[2] = 155;
		for(int i =0; i<intArr.length; i++) 
			System.out.println(++intArr[i]);

		for(int i =0; i<intArr.length; i++) 
			intArr[i] = (i+1)*10;
		
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

	/*실습1*/
	public void changeArraySize() {
		/* 배열 크기 변경 */
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
	
	/*실습2*/
	public void findFruit() {
		String [] fruitArr = {"딸기", "바나나", "복숭아", "키위", "사과"};
		for(int i =0 ;i <fruitArr.length; i++) {
			if(fruitArr[i].equals("복숭아")) {
				System.out.println(fruitArr[i] 
						+ " has index " + i);
			}
		}
	}

	/*실습3*/
	public void printArrElement() {
		char [] c = new char[5];
		for(int i =0; i<5; i++) {
			System.out.print((i+1) + "번째 입력: ");
			c[i] = CONSOLE.nextLine().charAt(0);
		}
		System.out.println(c);
		System.out.println("첫번째: " + c[0]);
		System.out.println("마지막: " + c[c.length - 1]);
	}
	
	/*shallow copy*/
	public void shallowCopy() {
		int[] intArr = {1, 2, 3, 4};
		int[] intCopy = intArr;
		
		System.out.println(intArr);
		System.out.println(intCopy);
		
		for(int i = 0; i<intArr.length; i++) 
			System.out.print(intArr[i] + " ");

		intArr[2] = 2323;

		for(int i = 0; i<intArr.length; i++)
			System.out.print(intCopy[i] + " ");

		System.out.println();
	}
	
	/*실습4*/
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
