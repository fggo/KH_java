package cast.practice;

import java.util.Scanner;

public class CastingSample {
	public Scanner sc = new Scanner(System.in);

	public void printUniCode() {
		System.out.print("문자 입력: ");
		char ch = sc.nextLine().charAt(0);
		System.out.println(ch + " is unicode: " + (int)ch);
	}
	
	public void calculatorScore() {
		System.out.print("국어: ");
		double kor = sc.nextDouble(); 
		System.out.print("영어: ");
		double eng = sc.nextDouble();
		System.out.print("수학: ");
		double math = sc.nextDouble(); sc.nextLine();
		
		int total = (int)(kor+eng+math);
		int avg = total/3;
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
	}
	
	public void printBitCount() {
		System.out.print("정수 입력: ");
		int num = sc.nextInt(); sc.nextLine();
		

		System.out.printf("%d의 2진수에 포함된 1의 갯수: %d", 
				num, Integer.bitCount(num));
	}
}
