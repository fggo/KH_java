package com.more.contoller;

import com.more.model.vo.Book;
import com.more.model.vo.Point;

public class TestSilsub1 {
	public static void main(String[] args) {
		Book b1 = new Book("자바책", "abc", 20000);
		Book b2 = new Book("1자바", "ㅁㅁㅁabc", 50000);
		
		System.out.println(b1);
		System.out.println(b2);
		
		if(b1.equals(b2))
			System.out.println("같은 책입니다.");
		else
			System.out.println("다른 책입니다.");

		b2 =  (Book)b1.clone();
		if(b1.equals(b2)) 
			System.out.println("같습니다.");
		else
			System.out.println("다릅니다.");
		//deep copy
		System.out.println(b1 + " : " + b1.hashCode());
		System.out.println(b2 + " : " + b2.hashCode());

		Point p1 = new Point(1,2);
		Point p2 = new Point(3,4);

		System.out.println(p1);
		System.out.println(p2);

//		if(p1.equals(p2))
//			System.out.println("두 포인트가 일치합니다.");
//		else
//			System.out.println("두 포인트가 일치하지 않습니다.");
//
//		=> 첫번째 객체를 복제한 객체 생성함 : clone() 사용
//		=> 첫번째 객체와 복제 객체의 주소가 같은지 출력
//		=> 첫번째 객체와 복제 객체의 내용이 같은지 출력

	}
}
