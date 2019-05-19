package inherit.polymorphism.contoller;

import inherit.polymorphism.model.Circle;
import inherit.polymorphism.model.IShape;
import inherit.polymorphism.model.Rectangle;
import inherit.polymorphism.model.Triangle;

public class TestPolyPractice3 {
	public static void main(String[] args) {
		
		IShape [] iarr = new IShape[5];
		iarr[0] = new Circle(15.5);
		iarr[1] = new Rectangle(34.5, 42.7);
		iarr[2] = new Circle(3.0);
		iarr[3] = new Triangle(5, 5.74);
		
		for(int i=0; i<iarr.length; i++) {
			if(iarr[i] instanceof Circle) {
				System.out.printf("원면적 : %.2f\n", iarr[i].area());
				System.out.printf("원둘레 : %.2f\n", iarr[i].perimeter());
			}
			else if (iarr[i] instanceof Rectangle) {
				System.out.printf("사각형면적 : %.2f\n", iarr[i].area());
				System.out.printf("사각형둘레 : %.2f\n", iarr[i].perimeter());
			}
			else if (iarr[i] instanceof Triangle) {
				System.out.printf("삼각형면적 : %.2f\n", iarr[i].area());
				System.out.printf("삼각형둘레 : %.2f\n", iarr[i].perimeter());
			}
		}
	}
}
