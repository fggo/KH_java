package oop.practice.model;

public class Book {
	private String title;
	private String author;
	private int price;

	private Book() {}
	public Book(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	public static Book createBook() {
		return new Book();
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
}
