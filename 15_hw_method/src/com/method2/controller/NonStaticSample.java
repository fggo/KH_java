package com.method2.controller;

public class NonStaticSample {
	public NonStaticSample() {}
	
	public void printLottoNumber() {
		int[] lottoResult = new int[6];
		int lottoNum = 0, count = 0;
		boolean duplicate = false;
		do {
			lottoNum = (int)(Math.random()*45+1);
			for(int i =0; i<count; i++) {
				if(lottoNum == lottoResult[i]) {
					duplicate = true;
					break;
				}
			}
			if(!duplicate) {
				lottoResult[count++] = lottoNum;
				System.out.print(lottoNum);
				if(count ==6) System.out.println();
				else System.out.print(" ");
			}
		}while(count < 6);
	}
	
	public void outputChar(int num, char ch) {
		for(int i =0; i<num; i++) {
			System.out.print(ch + " ");
			if (i == num -1)
				System.out.println();
		}
	}
	
	//TODO
	public char alphabette() {
		int shift = (int)(Math.random()*26);
		char a = 'a';
//		char A = 'A';

		return (char)(a+shift);
	}
	
	public String mySubstring(String str, int begin, int end) {
		if(begin >= 0 && begin <str.length()
				&& begin <= end && end <str.length()) {
			return str.substring(begin, end);
		}
		else {
			return null;
		}
	}
	
	//TODO
	//int 한개의 전달값을 받아서, 배열의 주소를 리턴하는 메소드
	//처리할 내용 : 전달받은 정수 갯수만큼의 배열공간을 할당하여, 
	//         임의의 1부터 100사이의 값으로 값 기록하고 주소 리턴함
	//메소드 명 : intArrayAllocation
	//매개변수도 있고 반환값도 있는 메소드
	public int intArrayAllocation(int length) {
		return 0;
	}

	//메소드 명 : display
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : 배열을 전달받아 화면에 출력함
	public void display(int[] arr) {
		for (int i =0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
		
	//메소드명 : swap
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : 배열과, 두 정수의 인덱스를 전달받아 두 인덱스의 값을 교환함
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//TODO
	//메소드명 : sortDescending
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : 위에서 작성한 swap 메소드를 이용하여 배열의 값 들을 내림차순 정렬 처리함
	public void sortDescending(int[] arr) {
		
	}
	
	//TODO
	//메소드명 : sortAscending
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : swap 메소드를 이용하여 배열의 값들을 오름차순 정렬함
	public void sortAscending(int[] arr) {
		
	}
	
	
	//1. 문자열과 문자 하나를 전달받아, 문자열에 포함된 문자의 갯수를 리턴하는 메소드
	//포함된 문자가 없으면 0 리턴함
	//메소드명 : countChar
	public int countChar(String str, char c) {
		int count = 0;
		for(int i =0; i<str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}
		return count;
	}
	
	
	//2. 정수 두 개를 전달받아, 두 수중 작은 값에서 큰 값사이의 정수들의 합계를 구해서
	//리턴하는 메소드
	//메소드명 : totalValue
	public int totalValue(int a, int b) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		int sum = 0;
		for(int i =min; i<=max; i++) {
			sum += i;
		}
		return sum;
	}
	
	
	//문자열과 인덱스를 전달받아, 그 위치의 문자를 리턴하는 메소드
	//메소명명 : pCharAt
	public char pCharAt(String str, int i) {
		return str.charAt(i);
	}
	
	//두 개의 문자열을 전달받아, 하나의 문자열로 합쳐서 리턴하는 메소드
	//메소드명 : pConcat
	public String pConcat(String s1, String s2) {
		return s1+s2;
	}
}
