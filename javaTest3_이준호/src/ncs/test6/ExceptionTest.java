package ncs.test6;

import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("2~5까지의 수 입력 : ");
		int num = sc.nextInt();
		Calculator cal = new Calculator();
		System.out.println("결과 값: " + cal.getSum(num));
	}
}
