package oop.practice.model;

public class Book {
	private String title;
	private int price;
	private double discountRate;
	private String author;
	private static Book inst = null;

	public static Book createBook() {
		if (inst == null)
			inst = new Book();
		return inst;
	}

	private Book() {}
	public Book(String title, int price, double discountRate, String author) {
		super();
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}
	
	public void bookInformation() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public double getDiscountRate() { return discountRate; }
	public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
}
