package com.kh.day2;

/* 실행 클래스 */
public class Run {
	public static void main(String[] args) {
		//변수 선언 (method, class)
		//논리형 선언
		//메모리ram안에 공간 생성됐다가 프로그램 끝나면 사라짐.
		boolean flag; //기준
	
		//단일문자
		//이름: char
		char gender;

		//문자열
		//이름: String
		String name;
		
		//정수
		//byte, short, int, long
		byte data;
		short num;
		int i; // default data type
		long account;
	
		//실수(소수점이 있는 숫자)
		float fnum;
		double dnum;

		//회원가입 정보 예시
		String id;
		String password;
		String memberName;
		int age;
		char memberGender;
		
		String address;
		double memberHeight;
		double memberWeight;
		boolean isMarried;
		
		//변수이름으로 첫번째자리 숫자 사용할수 없음!
//		int 1num; ERROR!
		int num1; //OK
		float w3ight;
		//특수문자는 _ $ 만 변수이름으로 가능
		String name_member;
		int _height;
		int height_;
		String name$member;
		int $price;
		int $height;
		double weight$;

//		String name*member; ERROR
//		int *height ; //ERROR
//		double (weight);// EEROR

		/* 한글변수이름 가능, 권장하지 않음
		String 가나다;
		int 나이; */
		
		//예약어'Reserved' words are prevented
		
		new DeclareVariable().addValue();
	}
}