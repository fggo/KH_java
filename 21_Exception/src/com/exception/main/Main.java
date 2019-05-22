package com.exception.main;

import java.io.FileNotFoundException;

import com.exception.controller.ExceptionController;

public class Main {
	public static void main(String[] args) {
//	public static void main throws FileNotFoundException (String[] args) {
		//main throws -> JVM
		/*
		try {
			new ExceptionController().basicTest();
		}
		catch(ArithmeticException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch(NegativeArraySizeException e) {
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Exception 발생 여부와 상관 없이, 반드시 실행됨");
		}*/
		
		//test1();
		/*try {
			new ExceptionController().test1();
		}
		catch(FileNotFoundException e) {
//			System.out.println(e.getMessage() + " 에러 처리됨!!!");
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Main에서 Array index out of Bounds 에러 처리");
			e.printStackTrace();
		}
		finally {
			System.out.println("예외 처리 후 코드 진행");
		}*/

//		new ExceptionController().fileException();
//		new ExceptionController().readFile2();
//		new ExceptionController().overrideException();

		new ExceptionController().myExceptionTest();
	}
}
