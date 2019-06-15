package com.kh.oop.model.vo;

public class Person {
	private static int pNum = 0;
	public static String name;
	private final static int AGE = 19;

	private int num;
	private String memberId="p001";
	private char gender = '남';
	private double height;
	private String[] hobby;
	
	public Person() {}
	
	public Person(String name, String memberId) {
		Person.name = name;
		this.memberId = memberId;
	}
	
	static {
		//num = 10; //ERROR
		pNum = 10;
		if(pNum == 11) name= "바바바";
		else name = "가가";
	}

	{
		num = pNum++;
		memberId = "000" + pNum;
		gender ='여';
		switch(pNum%2) {
			case 0: gender ='M'; break;
			case 1: gender ='F'; break;
		}
	}

	//setter, getter占쌨소듸옙!
	public static String getName() { return Person.name; }
	public void setMemberId(String id) { this.memberId = id; }
	public String getMemberId() { return memberId; }
	public static int getAge() { return Person.AGE; }
	
	public void printPerson() {
		System.out.println(Person.pNum + num+ Person.name + Person.AGE
				+gender+hobby+height);
	}
}
