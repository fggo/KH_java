package com.kh.array.controller;

import java.util.Scanner;

public class ArrayController {
	public static final Scanner CONSOLE= new Scanner(System.in);

	public void arrayTest() {
		//intArr(reference 타입 변수): stack에 주소값 저장
		//오른쪽 초기화 값(배열)은 heap에 저장
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
		System.out.println(intArr);

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
			if(i==arr2.length-1)
				System.out.println();
		}
	
		String [] strArr = {"딸기", "바나나", "복숭아", "키위", "사과"};
		for(int i =0 ;i <strArr.length; i++) {
			if(strArr[i].equals("복숭아")) {
				System.out.println(strArr[i] 
						+ " has index " + i);
			}
		}

		char [] c = new char[5];
		for(int i =0; i<5; i++) {
			System.out.print((i+1) + "번째 입력: ");
			c[i] = CONSOLE.nextLine().charAt(0);
		}

		System.out.println(c);
		System.out.println("첫번째: " + c[0]);
		System.out.println("마지막: " + c[c.length - 1]);
		
		
		int [] intArr2 = new int[5];
		for(int i =0; i<5; i++) {
			System.out.print("길이 5 배열에 들어갈 정수 입력: " );
			intArr2[i] = CONSOLE.nextInt();
		}
		
		int sum = 0;
		for(int i =0; i<intArr2.length; i++) {
			System.out.print(intArr2[i]+ " ");
			sum += intArr2[i];

			if(i == intArr2.length - 1) System.out.println();
		}
		System.out.println("합계: " + sum);
	}
	
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
}
