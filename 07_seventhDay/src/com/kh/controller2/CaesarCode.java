package com.kh.controller2;

import java.util.Scanner;

public class CaesarCode {
	public void caesarEncode() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type a String to encode : ");
		String str = sc.nextLine();

		System.out.print("Type Number for encoding : ");
		int move = sc.nextInt();
		move = move % 26;

		String newStr = "";
		for (int i =0 ; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)) {
				if(ch + move > 90) {
					newStr += (char)(ch+move-26);
				}
				else {
					newStr += (char)(ch+move);
				}
			}
			else if(Character.isLowerCase(ch)){
				if(ch+move > 122) {
					newStr += (char)(ch+move-26);
				}
				else {
					newStr += (char)(ch+move);
				}
			}
			else {
				System.out.println("Non-alphabet character was typed!! Terminating...");
				break;
			}
		}
		System.out.println(newStr);
	}
}
