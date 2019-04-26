package kh.java.operator;

import java.util.Scanner;

public class TestOperator {
	public Scanner sc = new Scanner(System.in);

	public void operFunc1() {
		System.out.print("숫자 입력: ");
		int num = sc.nextInt(); sc.nextLine();
		num /= 100;
		num *= 100;
		
		System.out.println("결과: " + num);
	}
	
	public void operFunc2() {
		System.out.print("과일  갯수: ");
		int fruit = sc.nextInt();
		System.out.print("바구니 과일 수: ");
		int fruitPerBox = sc.nextInt(); sc.nextLine();
		
		int boxNum = fruit/fruitPerBox + 1;
		int lastBoxFruit = fruit % fruitPerBox;
		
		System.out.printf("%d개의 과일을 담으려면 %d개가 필요합니다.\n"
				+ "마지막 바구니에는 %d개의 과일이 있습니다.", 
				fruit, boxNum, lastBoxFruit);
	}
	
	public void operFunc3() {
		System.out.print("문자 입력: ");
		char ch = sc.nextLine().charAt(0);
		int unicode = (char)ch;

		unicode = unicode > 90? unicode -32: unicode +32;
		System.out.println(ch + " -> " + (char)unicode);
	}
}
