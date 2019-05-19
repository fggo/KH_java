package com.practice1.model.vo;

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
		Book book = (Book)obj;

		boolean equals = this.title.equals(book.getTitle())
				&& this.author.equals(book.getAuthor())
				&& this.price == book.getPrice();
		return equals;
	}

	@Override
	public Object clone() {
		return this;	
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
}
