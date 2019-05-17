package com.kh.oop.model.vo;

public class Person {
	private static int pNum = 0;
	public static String name;
	private final static int AGE = 19;

	private int num;
	private String memberId="p001";
	private char gender = '여';
	private double height;
	private String[] hobby;
	
	public Person() {}
	
	public Person(String name, String memberId) {
		Person.name = name;
		this.memberId = memberId;
	}
	
	//static 초기화블록static
	static {
		//num = 10; //ERROR
		pNum = 10;
		if(pNum == 11) name= "하이";
		else name = "홍길동";
	}
	//초기화블록
	{
		num = pNum++;
		memberId = "000" + pNum;
		gender ='남';
		switch(pNum%2) {
			case 0: gender ='남'; break;
			case 1: gender ='F'; break;
		}
	}

	//setter, getter메소드!
	public static String getName() { return Person.name; }
	public void setMemberId(String id) { this.memberId = id; }
	public String getMemberId() { return memberId; }
	public static int getAge() { return Person.AGE; }
	
	public void printPerson() {
		System.out.println(Person.pNum + num+ Person.name + Person.AGE
				+gender+hobby+height);
	}
}
