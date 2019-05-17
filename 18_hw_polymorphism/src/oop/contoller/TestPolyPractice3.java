package oop.contoller;

import inherit.polymorphism.model.Circle;
import inherit.polymorphism.model.IShape;
import inherit.polymorphism.model.Rectangle;
import inherit.polymorphism.model.Triangle;

public class TestPolyPractice3 {
	public static void main(String[] args) {
		
		IShape[] iarr = new IShape[5];
		iarr[0] = new Circle(3.144);
		iarr[1] = new Rectangle(22.1, 32.1);
		iarr[2] = new Triangle(22.1, 11.1);
		iarr[3] = new Circle(2.11);
		iarr[4] = new Rectangle(22.1, 11.2);
 
		for(int i =0 ; i<iarr.length; i++) {
			System.out.println("³ÐÀÌ: " + iarr[i].area());
			System.out.println("µÑ·¹ : " + iarr[i].perimeter());
			if (iarr[i] instanceof Triangle) {
				System.out.println("Hypthenuse: " + ((Triangle)iarr[i]).getHypotenuse());
			}
		}
	}
}
