package kh.java.operator;

import java.util.Scanner;

public class TestOperator {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void operFunc1() {
		System.out.print("숫자 입력: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		num /= 100;
		num *= 100;
		
		System.out.println("결과: " + num);
	}
	
	public void operFunc2() {
		System.out.print("과일  갯수: ");
		int fruit = CONSOLE.nextInt();
		System.out.print("바구니 과일 수: ");
		int fruitPerBox = CONSOLE.nextInt(); CONSOLE.nextLine();
		
		int boxNum = fruit/fruitPerBox + 1;
		int lastBoxFruit = fruit % fruitPerBox;
		
		System.out.printf("%d개의 과일을 담으려면 %d개가 필요합니다.\n"
				+ "마지막 바구니에는 %d개의 과일이 있습니다.", 
				fruit, boxNum, lastBoxFruit);
	}
	
	public void operFunc3() {
		System.out.print("문자 입력: ");
		char ch = CONSOLE.nextLine().charAt(0);

//		char result = (char)(ch ^32);
		
		char result = (ch >='a' && ch <='z')? (char)(ch-32): 
			(ch>='A' && ch<='Z')? (char)(ch+32): 'X';
		System.out.println(result);
		
		if(ch >='a' && ch <= 'z')
			ch = (char)(ch-32);
		else if( ch>='A' && ch <='Z')
			ch = (char)(ch+32);
		else
			ch = '?';
		
		System.out.println(ch);
	}
}
