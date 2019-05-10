package com.kh.oop.model.vo;

public class Person {
	private static int pNum = 0;
	private int num;
	private String memberId="p001";
	public static String name;
	private final static int AGE = 19;
	private char gender = '여';
	private String[] hobby;
	private double height;
	private static final double PI = 3.1415;
	
	//default Constructor
	public Person() {}
	
	//constructor
	public Person(String name, String memberId) {
		Person.name = name;
		this.memberId = memberId;
	}
	
	//초기화블록(static/default)
	static {
//		num = 10; //ERROR
		pNum = 10;
		if(pNum == 11) name= "하이";
		else name = "홍길동";
	}
	{
		num = pNum++;
		memberId = "000" + pNum;
		gender ='남';
		switch(pNum%2) {
		case 0: gender ='남'; break;
		case 1: gender ='남'; break;
		}
	}

	//setter메소드!
	public static void setName(String name) {
		Person.name=name;
	}
	//getter메소드!
	public static String getName() {
		return Person.name;
	}
	public void setMemberId(String id) {
		this.memberId = id;
	}
	public String getMemberId() {
		return memberId;
	}
	
	public int getAge() {
		return Person.AGE;
	}
	
	public void printPerson() {
		System.out.println(pNum + " " + num+ Person.name 
				+ Person.AGE+gender+hobby+height);
	}
}
