package com.kh.day4.func;

import java.util.Scanner;

public class OperatorTest {
	public static Scanner sc = new Scanner(System.in);

	public void cal() {
		int num = 10;
		int num2 = 20;
		int num3 = 30;
		
		System.out.println(num2+ num3);
		System.out.println(num2 - num3);
		System.out.println(num2 * num3);
		System.out.println(num2/num3);
		System.out.println((double)num2/num3);
		System.out.println((double)(num2/num3));
		System.out.println(2.0/3);
		System.out.println(num2 % num3);

		int result = num2 /num3;
		double result2 = num2/num3; //integer.0
//		int total = result + result2; //ERROR

		}
	public void compare() {
		//비교연산자: 기본자료형만 비교 가능
		//String은 비교 불가, char는 int로 인식하여 비교가능
		int a = 25;
		int b = 20;
		int c = 25;
		
		//정수비교
		System.out.println(a == b);
		System.out.println(a != b);
		System.out.println(a == c);
		System.out.println(a != c);
		System.out.println(a > b);
		System.out.println(a <= c);
		System.out.println(a >= b);
		
		//실수비교
		double dnum = 12.34, dnum2 = 34.5;
		System.out.println(dnum != dnum2);
		System.out.println(dnum > dnum2);
		
		//단일문자비교
		char ch = 'a', ch2 = 'b', ch3= 'c';
		System.out.println(ch < ch2);
		System.out.println(ch > ch2);
		System.out.println(ch+ ch2);

		System.out.println((int)ch);
		System.out.println((int)ch2);
		
		//문자열 비교??
		String name = "라라라";
		String name2 = "가나다";
//		System.out.println(name > name2);
	}

	public void bitOper()
	{
		int a=10, b=22;
		String basic="00000000000000000000000000000000";
		String bit=basic+Integer.toBinaryString(a);

		//a비트값
		bit=bit.substring(bit.length()-32);
		System.out.println("a비트값 : "+bit);

		//b비트값
		bit=basic+Integer.toBinaryString(b);
		bit=bit.substring(bit.length()-32);
		System.out.println("b비트값 : "+bit);
		
		//a&b결과값
		bit=basic+Integer.toBinaryString(a&b);
		bit=bit.substring(bit.length()-32);
		System.out.println("a&b비트값 : "+bit);
		//a|b결과값
		bit=basic+Integer.toBinaryString(a|b);
		bit=bit.substring(bit.length()-32);
		System.out.println("a|b비트값 : "+bit);
		//a^b결과값
		bit=basic+Integer.toBinaryString(a^b);
		bit=bit.substring(bit.length()-32);
		System.out.println("a^b비트값 : "+bit);
		//~a결과값
		bit=basic+Integer.toBinaryString(~a);
		bit=bit.substring(bit.length()-32);
		System.out.println("~a비트값 : "+bit);
		//a<<2
		bit=basic+Integer.toBinaryString(a<<2);
		bit=bit.substring(bit.length()-32);
		System.out.println("a<<2비트값 : "+bit);
		//a>>2
		bit=basic+Integer.toBinaryString(a>>2);
		bit=bit.substring(bit.length()-32);
		System.out.println("a>>2비트값 : "+bit);
	}
	
	public void complexTest() {
		int a = 10, b = 20, c = 30;
		double d =0;
		a+=3;
		System.out.println(a);
		a+=b;
		System.out.println(a);
		a-=c;
		System.out.println(a);
		a/=b;
		System.out.println(a);
		a%=b;
		System.out.println(a);
		
		//사용자에게 정수3개를 입력받고, 총합을 구하는 프로그램
		int sum = 0;
		System.out.print("1번정수 입력: ");
		sum += sc.nextInt(); sc.nextLine();
		System.out.print("2번정수 입력: ");
		sum += sc.nextInt(); sc.nextLine();
		System.out.print("3번정수 입력: ");
		sum += sc.nextInt(); sc.nextLine();
		
		System.out.println(sum);
	}
	
	public void thirdOper() {
		int a = 20;
		int b = 30;
		String msg = 
			a > b? "첫번째수가 커.": "두번째수가 커.";
		System.out.println(msg);
		
		System.out.print("첫번째 수 입력(>=10): ");
		int first = sc.nextInt(); sc.nextLine();
		System.out.print("두번째 수 입력(>=10): ");
		int second = sc.nextInt(); sc.nextLine();

		String msg2 = first>=10 && second>=10? 
				first > second? "첫번째수가 커": "두번째수가 커" : "10이상의 숫자입력 해야함!!";
		System.out.println(msg2);
	}
	
	public void compareString() {
		String name = "aaa";
		System.out.println(name.equals("aaa"));

	}
}
