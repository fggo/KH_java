package com.method2.controller;

public class StaticMethod {
	private static String value;
	//TODO
	//Constructor  : 필드가 모두 static 일 때는 생성자 필요없음
	public StaticMethod(){}

	public StaticMethod(String value){
		this.value = value;
	}

	public void toUpper() {
		if (value != null)
			value = value.toUpperCase();
	}

	public void setChar(int i, char ch) {
		if(value!=null) {
			if(i < value.length())
				value = value.substring(0,i) + ch + value.substring(i+1);
		}
	}

	public static int valueLength() {
		if (value != null)
			return value.length();
		return -1;
	}

	//4. 반환값 있고 매개변수 있는 static 메소드
	//문자열값을 전달받아, value 필드값과 하나로 합쳐서 리턴 처리
	//메소드명 : valueConcat
	public static String valueConcat(String str) {
		return value.concat(str);
	}
}
