package com.exception.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.exception.common.MyException;

public class ExceptionController {
	private int[] nums = new int[3];

	public void basicTest()
			throws IOException{
			//ArithmeticException, NullPointerException,
			//	NegativeArraySizeException, ArrayIndexOutOfBoundsException {
		int su1 = 10;
		int su2 = 0;
//		System.out.println(su1/su2);
		
		String name = null;
//		System.out.println(name.charAt(0));
		
		int arrSize = -1;
//		int[] arr = new int[arrSize];
		
		int[] arr = new int[5];
		try {
			arr[5] = 10;
		}catch(ArrayIndexOutOfBoundsException e) {
			int[] copy = new int[10];
			//deep copy
			System.arraycopy(nums, 0, copy, 0, nums.length);
			nums = copy;
		}
		
		try {
			nums[5] = 10;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of bounds 에러 발생");
			e.printStackTrace();
		}
		finally {
			System.out.println(nums.length);
		}
	}
	
	public void test1() throws IOException{
	//ArrayIndexOutOfBoundsException, FileNotFoundException{
		System.out.println("test1 실행");
		test2();
	}
	
	public void test2() throws FileNotFoundException{
		System.out.println("test2 실행");
//		int[] nums = new int[3];
//		int a =nums[4];
		//강제로 에러 발생
		throw new FileNotFoundException();
	}
	
	public void fileException() {
		FileInputStream is =null;
		try {
			is = new FileInputStream(new File("test.txt"));
			System.out.println("안녕");
		}
//FileNotFoundException: child
//IOException: parent class
//모든 예외 클래스의 부모 Exception
//		catch(FileNotFoundException e) { //checked exception
//			e.printStackTrace();
//			System.out.println("파일이 없습니다.");
//		}
		//IOException(부모)이 FileNotFound(자식) 보다
		//위에 나오면 ERROR
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("안녕 이거!");
			try {
				is.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			//Exception 발생
		} catch(Exception e) {
			System.out.println("모든 Exception 은 여기로");
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
			//parsing해서 어떤 에러인지 알수 있지만,
			//편의성 떨어짐
//			e.getClass().toString()
		}
		finally {
			System.out.println("finally 문");
		}
	}
	
	public void readFile1() {
//		BufferedReader in = null;
//		try {
//			in = new BufferedReader(new FileReader("C:\\Users\\user1\\KH\\KH_java"));
//			String s;
//			while((s=in.readLine()) != null) {
//				System.out.println(s);
//			}
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	public void readFile2() {
		try(FileReader fr = new FileReader(new File("test.txt"));
			BufferedReader br = new BufferedReader(fr)) {
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
	}
	
	//throws Exception 있는 메소드 오버라이드 시,
	//throws Exception, ChildException ,... etc()
	public void overrideException() {
	}
	
	//사용자 정의 예외처리
	public void myExceptionTest() {
		try {
			//에러 발생시킴
			throw new MyException("나의 예외처리");
		} catch(MyException e) {
			//에러 받아서 처리
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
}
