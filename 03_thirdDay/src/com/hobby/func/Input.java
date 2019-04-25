package com.hobby.func;

import java.util.Scanner;

public class Input {
	public void inputTest() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이: ");
		int age = sc.nextInt(); sc.nextLine();
		
		System.out.print("취미(다중 값은 ,로 구분) ");
		String hobby = sc.nextLine();
		
		System.out.print("사는곳: ");
		String address = sc.nextLine();

		System.out.print("키: ");
		double height = sc.nextDouble(); sc.nextLine();

		System.out.print("몸무게: ");
		double weight = sc.nextDouble(); sc.nextLine();
		
		System.out.printf("\n나이 : %d\n"
				+ "취미: %s\n"
				+ "사는곳: %s\n"
				+ "키: %f\n"
				+ "몸무게: %f\n",
				age, hobby, address, height, weight);
	}
}
