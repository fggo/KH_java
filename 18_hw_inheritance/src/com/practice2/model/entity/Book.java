package com.practice2.model.entity;

public class Book {
	private String title;
	private String author;
	private int price;

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	// Object 클래스의 toString() 메소드 오버라이딩함
//		=> 객체의 모든 필드값 문자열 합치기해서 리턴함
//	// Object 클래스의 equals() 메소드 오버라이딩함
//		=> 두 객체의 모든 필드값이 일치하는지를 물어서
//			모두 일치하면 true, 
//		   	하나라도 다르면 false를 리턴함
//	// Object 클래스의  clone() 메소드 오버라이딩함
//		=> 접근제한자는 public 으로 변경함
//		=> 예외처리는 삭제함
//		=> this 로 전달된 위치의 객체가 가진 값을 복사한 새 객체 생성하고
//		    주소 리턴함
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
}
