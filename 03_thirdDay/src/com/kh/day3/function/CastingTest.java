package com.kh.day3.function;

public class CastingTest {
	public void castingTest() {
		//자동형변환 implicit
		int account = 1000;
		long accountVip = account;  // int->long
		// account (int 4b) -> accountVip (long 8b)
//		account = accountVip; ERROR
		account = (int)accountVip; //explicit

		int su = 10;
		double height = 180.5;
		double result = su+height; // int->double
//		int result = su+height; // ERROR
		System.out.println(result);
		
		char ch = 'A';
		int character = ch; //char -> int
		System.out.println((char)(character+1));
		
		byte bnum = 100;
		byte bnum2 = 100;
//		byte bresult = bnum + bnum2; //ERROR
		byte bresult = (byte)(bnum + bnum2); //data loss
		int a = 19, b= 20;
		int iresult = a + b;
		System.out.println((double)a/b);
		
		double d = 18.7;
		double e = 20.0;
		double f = d+e;
		int cast = (int)d;
		System.out.println(cast);

//		static 어디서든 사용가능
//		heap 사용자 지정 new object(); gc에 의해 소명 안됨 
//		stack 지역변수 등 알아서 메모리 할당/소멸
		
		System.out.printf("%d값 %d이야. %f", 
				character, bresult, (double)a/b);
		String name = "lalala";
		int age = 19;
		char gender = 'M';
		double weight = 65.5;
		System.out.printf("\nMy name is %s, age is %d.\n"
				+ "gender is %c, weight is %.2f", name, age, gender, weight);

		System.out.println("\n\n\"name\"\tage\tgender\tweight");
		System.out.printf("%-5s\t%d\t%c\t%.2f", name, age, gender, weight);
		//%-5s : left align with 5 whitespaces
		
	}
}
