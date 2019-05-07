package array.test;

import java.util.Scanner;

public class ArrayTest {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void test1() {
		int[] intArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[intArr.length];

		//shallow copy
		copyArr = intArr;
		
		intArr[3] = 99;

		System.out.println(intArr.hashCode());
		System.out.println(copyArr.hashCode());
		
		printArray(intArr);
		printArray(copyArr);

		//deep copy
		for(int i =0; i<intArr.length; i++) 
			copyArr[i] = intArr[i];

		int[] copyArr2 = new int[intArr.length];
		
		copyArr2 = intArr.clone(); // deep copy (whole array)
		
		int beginIndex =3;
		System.arraycopy(intArr, beginIndex, 
				copyArr2, 0, intArr.length -beginIndex);
		intArr[2] = 1111;
		System.out.println(copyArr2.hashCode());

		printArray(intArr);
		char[] arr = "apple".toCharArray();

		// copyArr의 2~4 위치에 "ppl"
		char[] copyArr3 = new char[arr.length];
		System.arraycopy(arr, 1, copyArr, 2, 3);
		printArray(copyArr);
		printArray(copyArr2);
	}
	
	public <T> void printArray(T [] arr) {
		for(int i =0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
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
	
	public void printStar() {
		System.out.print("별 출력할 행 갯수 입력: ");
		int d = CONSOLE.nextInt();
		String stars = "";
//		stars = String.format("%", args);

		for(int i =0; i<d; i++) {
			String format = "%" + d + "s";
			String args = String.valueOf(i);
			new String().replace(' ', '*');
		}
	}
	
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
	
	public void test4() {
		//for each
		//array, Collection(List , Set, HashMap)
//		for(int a : 배열)
		int[] intArr = {1,2,3,4,5};
		for(int val : intArr)
			System.out.println(val);
	}
}
