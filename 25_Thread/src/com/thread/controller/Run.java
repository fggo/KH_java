package com.thread.controller;

import common.thread.CharacterThread;
import common.thread.MyThread;

public class Run {
	public static void main(String[] args) {
		//1. 쓰레드를 생성할 때는 Thread클래스를 이용
		//쓰레드를 구현할 클래스를 만들고 Thread 객체를 상속
		//run 메소드를 Override
		
//		for(int i =0; i<5; i++) {
//			System.out.println("메인" + i);
//		}
//
//		MyThread th1 = new MyThread("th1");
//		th1.start(); //쓰레드시작! run메소드가구현! main과는 다른 작업공간에서 별도실행
//		MyThread th2 = new MyThread("th2");
//		th2.start();
//		
//		try {
//			th1.join();
//			th2.join();
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		//2. Runnable 인터페이스를 이용하는 방법
//		CharacterThread c1 = new CharacterThread("지존준영", 100);
//		CharacterThread c2 = new CharacterThread("혀니", 200);
//		Thread cha1 = new Thread(c1);
//		Thread cha2 = new Thread(c2);
//		
//		//setPriority 실행 할당시간을 늘림, 먼저 전부 끝내는건 아님
//		cha1.setPriority(Thread.MAX_PRIORITY); //10
//		cha2.setPriority(Thread.MIN_PRIORITY); //1
//
//		cha1.start();
//		cha2.start();
//		
//		//다른 쓰레드가 끝나면 실행하게 통제해보자
//		//join() join을 호출한 쓰레드가 끝날때까지 대기
////		cha1, cha2 쓰레드가 끝날떄 까지 다른 쓰레드(main thread)는 대기
//		try {
//			cha1.join();
//			cha2.join();
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//
////		메인쓰레드를 마지막에 종료
//		for(int i =0 ;i<5; i++)
//			System.out.println("main");
//		
//		System.out.println("메인 쓰레드 종료");
		
		new CountDown();
	}
}
