package com.kh.controller2;

import java.util.Scanner;

public class CaesarCode {
	public void encryption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("encrypt할 문자열을 입력하세요: ");
		String str = sc.nextLine();

		System.out.print("encrypt위한 shift 정수를 입력하세요 : ");
		int move = sc.nextInt();
		move = move % 26;

		String newStr = "";
		for (int i =0 ; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)) {
				if(ch + move > 90)
					newStr += (char)(ch+move-26);
				else
					newStr += (char)(ch+move);
			}
			else if(Character.isLowerCase(ch)){
				if(ch+move > 122)
					newStr += (char)(ch+move-26);
				else
					newStr += (char)(ch+move);
			}
			else {
				System.out.println("알파벳이 아닌 문자가 포함되어 있습니다! 프로그램 종료 중...");
				break;
			}
		}
		System.out.println(newStr);
	}
}
