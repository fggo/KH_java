package silsub.sample;

import java.util.Scanner;

public class CaesarCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type a String to encode : ");
		String str = sc.nextLine();

		System.out.print("Type Number for encoding : ");
		int num = sc.nextInt();
		num = num % 26;

		String newStr = "";
		for (int i =0 ; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >=65 && ch <=90) {
				if(ch + num > 90) {
					newStr += (char)(ch+num-90-1 + 65);
				}
				else {
					newStr += (char)(ch+num);
				}
			}
			else if (ch >=97 && ch <= 122) {
				if(ch+num > 122) {
					newStr += (char)(ch+num-122-1 + 97);
				}
				else {
					newStr += (char)(ch+num);
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
