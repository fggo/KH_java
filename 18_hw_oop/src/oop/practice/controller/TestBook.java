package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {
	public static void main(String[] args) {
		Book book = Book.createBook();
		book.setTitle("자바");
		book.setAuthor("부처님");
		book.setPrice(35000);
		book.setDiscountRate(.1);

		book.bookInformation();

		System.out.print("할인된 가격: " + (int)(book.getPrice()*(1-book.getDiscountRate())));
	}
}
