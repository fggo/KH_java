package com.kh.day3.function;

import java.util.Scanner;

public class ScannerTest {
	public void inputTest() {
		//실습예제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Your Name: ");
		String name = sc.nextLine();

		System.out.print("Your age: ");
		int age = sc.nextInt(); sc.nextLine();

		System.out.print("Your address : ");
		String address = sc.nextLine();

		System.out.print("Your height: ");
		double height = sc.nextDouble(); sc.nextLine();

		System.out.print("Your weight: ");
		double weight = sc.nextDouble(); sc.nextLine();
		
		System.out.print("Your gender: ");
		char gender = sc.nextLine().charAt(0);

		System.out.printf("\n이름 : %d\n"
				+ "나이: %d\n"
				+ "주소: %s\n"
				+ "키: %f\n"
				+ "몸무게: %f\n"
				+ "성별: %c\n",
				name, age, address, height, weight, gender);
	}
}
