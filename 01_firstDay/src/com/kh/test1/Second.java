package com.kh.test1;

//없으면 ERROR!
//다른 package class를 import
import com.kh.test.Function;

//실행용 클래스
public class Second {
	//프로그램이 시작되려면 반드시 main
	//메소드를 가지고 있는 클래스가 있어야 한다.
	//main메소드를 먼저 찾음.
	//프로그램 시작 포인트
	
	public static void main(String[] args) {
//		System.out.println("안녕 두번째야!");
//		System.out.println("안녕 난 두번째 밑에야!");
		new Function().printMsg();
	}
}