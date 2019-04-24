package com.kh.day2;

public class DeclareVariable {
	//변수선언: memory 공간확보
	//데이터 주소값을 컴퓨터가 알수 없음 -> 데이터 이름 정의
	//변수 선언 & 데이터 값 assign시 오른쪽 literal에 default 자료형 내재
	//''	char
	//""	String
	//123	int
	//3.14	double
	public void addValue() {
		//논리형
		boolean flag;
		flag = true;
		System.out.println(flag);
		flag = false;
//		flag = 1000; ERROR assigning int to boolean!
		System.out.println(flag);

		//문자형(문자, 문자열)
		//단일문자
		char gender;
		gender = 'M';
		gender = '남';
//		gender = "M"; ERROR
//		gender = 'AB'; ERROR
//		gender = 남; ERROR it looks for 남 variable
		System.out.println(gender);
		
		//문자열 ""
		String name = "바바";
		String msg = "안녕하세요 저는" + name + " 입니다.";
		System.out.println(msg);
		
		//숫자형(정수, 실수)
		byte bnum = 100; // int -> byte
//		bnum = 128;  ERROR; 범위(-128~127) 벗어남
		//90000 short가 표현할수 있는 범위를 벗어나는 literal값이기
		//때문에, 자동형변환 일어나지 않음.
		short snum = 10000; //int->short 자동형변환
		int intNum = 90000;
		long longNum = 900000; // int->long 자동형변환
//		longNum = 900000000000; //ERROR int 범위초과
		longNum = 900000000000L;

		System.out.println(bnum);
		System.out.println(snum);
		System.out.println(intNum);
		System.out.println(longNum);
		
		//실수 (float, double)
		float fnum;
		double dnum;
		fnum = 180.5f; //ERROR if 180.5
		// double-> float 자동형변환 불가
		dnum = 65.5;
		System.out.println(fnum);
		System.out.println(dnum);
		System.out.println(65.5); // 자동 double 형 메모리공간에 저장
		
		long num = 9000000;
		System.out.println(num*10);
		System.out.println(num*20);
		System.out.println(num*30);
		
		//상수의 선언 및 대입
		final int AGE;
		AGE = 19;
		System.out.println(AGE);
//		AGE = 20;// ERROR
		
		//문자 + 숫자 = > 문자
		//솟자+숫자 + 문자 = > 숫자합 + 문자
		String msg2 = "안녕! 나는 ...";
		System.out.println(msg2);
		msg2 = new String("안녕 난 아아ㅏ");
		System.out.println(msg2);
		
		//문자열에서 +기호는 연결연산으로 사용
		msg2 += "라라라는 " + 19 + 1+ " 살 입니다."; //191
		msg2 += "라라라는 " + (19 + 1)+ " 살 입니다."; //20
		msg2+= 19+1 + "살 입니다."; //20
		System.out.println(msg2);

		String nameOfStudent = "나나나";
		int age = 19;
		String address = "서울시 관악구";

		String msg3 = "나는 " + nameOfStudent + " 이다."
					+ ",\n나는 " + age+ " 살이다.\n"
					+ address + "에 살고있다.";
		System.out.println(msg3);

		String memberName = name;
		System.out.println(memberName);
		int plusAge = age+ 2;
		System.out.println(plusAge);
		
		//byte data overflow Test: -128~127 
		byte bnum1 = 127;
		for(int i=0 ;i <300; i++) {
			System.out.println(bnum1++);
		}
	}
}
