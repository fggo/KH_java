package Workshop5;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어 입력: ");
		String input = sc.nextLine();
		char[] charArr = input.toCharArray();
		for(int i=charArr.length-1; i>=0; i--) {
			System.out.print(charArr[i]);
		}
	}
}
