package com.oop.contoller;

import com.oop.model.vo.Book;

public class BookController {
	public static void main(String[] args) {
		Book b = new Book("자바", "가나다", 2500);
		Book b1 = new Book("자바", "바바", 12500);
		Book b2 = new Book("자바", "가나다", 2500);
		
		System.out.println(b.equals(b2));
		System.out.println(b1.equals(b2));
	}
}
