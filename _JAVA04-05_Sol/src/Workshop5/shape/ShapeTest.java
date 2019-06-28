package Workshop5.shape;

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		shapes[0] = new Triangle(7, 5, "Blue");
		shapes[1] = new Rectangle(4, 6, "Blue");
		shapes[2] = new Triangle(6, 7, "Red");
		shapes[3] = new Rectangle(8, 3, "Red");
		shapes[4] = new Triangle(9, 8, "White");
		shapes[5] = new Rectangle(5, 7, "White");
		
		for(int i =0; i<shapes.length; i++) {
			shapes[i].showShape();
			if(shapes[i] instanceof Triangle)
				((Triangle)shapes[i]).setResize(5);
			else if(shapes[i] instanceof Rectangle)
				((Rectangle)shapes[i]).setResize(5);
		}
		System.out.println();

		for(int i =0; i<shapes.length; i++)
			shapes[i].showShape();
	}
}
