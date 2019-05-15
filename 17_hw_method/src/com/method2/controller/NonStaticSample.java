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
	
	public char alphabette() {
		int shift = (int)(Math.random()*26);
		char a = 'a'; //65
		char A = 'A';// 97
		shift = (int)(Math.random()*52);
		if(shift/26 >0)
			return (char)(a +(shift%26));
		else
			return (char)(A+shift);
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
	
	public int[] intArrayAllocation(int length) {
		int[] arr = new int[length];
		for(int i =0; i<arr.length; i++)
			arr[i] = (int)(Math.random()*100 + 1);
		return arr;
	}

	public void display(int[] arr) {
		for (int i =0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
		
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sortDescending(int[] arr) {
		for(int i =0; i<arr.length; i++) {
			for(int j =i; j<arr.length; j++) {
				if(arr[j] > arr[i])
					swap(arr,i, j);
			}
		}
	}
	
	public void sortAscending(int[] arr) {
		for(int i =0; i<arr.length; i++) {
			for(int j =i; j<arr.length; j++) {
				if(arr[j] < arr[i])
					swap(arr,i, j);
			}
		}
	}
	
	public int countChar(String str, char c) {
		int count = 0;
		for(int i =0; i<str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}
		return count;
	}
	
	public int totalValue(int a, int b) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		int sum = 0;
		for(int i =min; i<=max; i++) {
			sum += i;
		}
		return sum;
	}
	
	public char pCharAt(String str, int i) {
		return str.charAt(i);
	}
	
	public String pConcat(String s1, String s2) {
		return s1+s2;
	}
}
