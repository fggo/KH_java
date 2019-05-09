package circle.model.vo;

public class Circle {
	private static final double PI = 3.14;
	private int radius;
	private int number;
	
	public Circle() {
		radius = 1;
		number = 1;
	}
	
	public void incrementRadius() {
		radius += 1;
	}
	
	public void incrementNumber() {
		number += 1;
	}

	public void setRadius(int r) {
		radius = r;
	}
	public int getRadius() {
		return radius;
	}
	public void setNumber(int n) {
		number = n;
	}
	public int getNumber() {
		return number;
	}
}
