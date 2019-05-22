package com.exception.common;

//나만의 예외클래스 만들기
public class MyException extends RuntimeException{
	public MyException() {
		super();
	}
	
	public MyException(String msg) {
		super(msg);
	}

}
