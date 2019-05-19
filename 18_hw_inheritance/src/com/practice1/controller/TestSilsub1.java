package com.practice1.controller;

import com.practice1.model.vo.Book;

public class TestSilsub1 {
	public static void main(String[] args) {
		Book b1 = new Book("가가가", "저자1", 20000);
		Book b2 = (Book)b1.clone();
		
		if(b1.equals(b2))
			System.out.println("b1과 b2는 같은책 입니다.");
		else
			System.out.println("b1과 b2는 다른책 입니다.");
			
		if(b1 == b2)
			System.out.println("b1과 b2는 주소값이 같습니다.");
		else
			System.out.println("b1과 b2는 주소값이 다릅니다.");
	}
}
