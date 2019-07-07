package Workshop2;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[3];
		int max =0, min = 0;
		System.out.print("Type THREE Integers(1~9) >> ");
		for(int i =0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
			if(i==0) {
				max = nums[i];
				min = nums[i];
			}
			if(nums[i] > max) max = nums[i];
			if(nums[i] < min) min = nums[i];
		}
		System.out.print("�Է°�: ");
		for(int i =0; i<nums.length; i++) System.out.print(nums[i] + " ");
		System.out.println("\n�ִ밪: " + max);
		System.out.println("�ִ밪: " + min);
	}
}
