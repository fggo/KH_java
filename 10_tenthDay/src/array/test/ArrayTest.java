package array.test;

import java.util.Scanner;

public class ArrayTest {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void test1() {
		int[] intArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[intArr.length];

		//shallow copy
		copyArr = intArr;
		
		System.out.println("=== Shallow Copy ===");
		System.out.println(intArr.hashCode());
		System.out.println(copyArr.hashCode());
		
		intArr[3] = 99;
		
		printArray(intArr);
		printArray(copyArr);

		//deep copy
		System.out.println("=== Deep Copy ===");
		int[] copyArr2 = new int[intArr.length];
		for(int i =0; i<intArr.length; i++) 
			copyArr2[i] = intArr[i];

		//deep copy(whole)
		copyArr2 = intArr.clone();
		
		//deep copy(whole or part of array)
		int beginIndex =3;
		System.arraycopy(intArr, beginIndex, 
				copyArr2, 0, intArr.length -beginIndex);
		intArr[2] = 1111;
		printArray(intArr);
		printArray(copyArr2);

		// copyArr의 2~4 위치에 "ppl" 초기화하기
		char[] arr = "apple".toCharArray();
		char[] copyArr3 = new char[arr.length];
		System.arraycopy(arr, 1, copyArr3, 2, 3);
		printArray(arr);
		printArray(copyArr3);
	}
	
	public void printArray(int [] arr) {
		for(int i =0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void printArray(char [] arr) {
		for(int i =0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void test2() {
		for(int i =9; i>= 2; i--) {
			System.out.println("===== " + i + "단 =====");
			for(int j =9;j>=1; j--) { 
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
	}
	
	//for each: 배열, 컬렉션(List , Set, HashMap)에 유용
	public void test3() {
		char[] arr = "abcdefe".toCharArray();
		char val = '\u0000';
		int count = 0;
		
		for(int i =0; i<arr.length; i++) {
			count = 0;
			val = arr[i];
			for(int j= 0; j<arr.length; j++) {
				if(val ==arr[j])
					count++;
			}
			System.out.println(arr[i] + " count : " + count);
		}

		for (int val1 : arr) {
			count = 0;
			for(int val2 : arr) {
				if(val1 == val2)
					count++;
			}
			System.out.println();
		}
	}
}
