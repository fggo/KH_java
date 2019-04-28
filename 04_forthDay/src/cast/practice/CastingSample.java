package cast.practice;

import java.util.Scanner;

public class CastingSample {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void printUniCode() {
		System.out.print("문자 입력: ");
		char ch = CONSOLE.nextLine().charAt(0);
		System.out.println(ch + " is unicode: " + (int)ch);
	}
	
	public void calculatorScore() {
		System.out.print("국어: ");
		double kor = CONSOLE.nextDouble(); 
		System.out.print("영어: ");
		double eng = CONSOLE.nextDouble();
		System.out.print("수학: ");
		double math = CONSOLE.nextDouble(); CONSOLE.nextLine();
		
		int total = (int)(kor+eng+math);
		int avg = total/3;
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
	}
	
	public void printBitCount() {
		System.out.print("정수 입력: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		

		System.out.printf("%d의 2진수에 포함된 1의 갯수: %d", 
				num, Integer.bitCount(num));
	}
}
