package test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("T : ");
		int T = sc.nextInt();
		int num = 0;
		int[] sums = new int[T];

		String[] str = {"3 17 1 39 8 41 2 32 99 2",
			"22 8 5 123 7 2 63 7 3 46",
			"6 63 2 3 58 76 21 33 8 1"};
		String[][] nums = new String[T][10];

		for(int i =0; i<T; i++) {
			nums[i] = str[i].split(" ");
			for(int j =0; j<10; j++) {
				if(Integer.valueOf(nums[i][j])%2 ==1) sums[i] += Integer.valueOf(nums[i][j]);
			}
		}

		for(int i =0; i<T; i++) {
			System.out.println("#" + (i+1) + " "+ sums[i]);
		}
	}
}
