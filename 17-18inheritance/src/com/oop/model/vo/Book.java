package com.oop.model.vo;

public class Book {
	private String title;
	private String author;
	private int price;

	public Book() {}
	
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		Book temp = (Book)obj;
		boolean equals = 
				this.title.equals(temp.getTitle())
				&& this.author.equals(temp.getAuthor());
				
		return equals;
	}

	//deep copy
	public Object clone() {
		//shallow copy
		//Book b = this;
		return new Book(this.title, this.author, this.price);
	}

	@Override
	public String toString() {
		return "책제목: " + title + " 책저자: " + author
				+ " 가격: " + price;
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
}
