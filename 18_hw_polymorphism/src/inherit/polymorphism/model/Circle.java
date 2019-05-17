package inherit.polymorphism.model;

public class Circle implements IShape{
	private double radius;

	public Circle() {}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double area() {
		return PI*radius*radius;
	}

	@Override
	public double perimeter() {
		return 2*PI*radius;
	}

	public double getRadius() { return radius; }
	public void setRadius(double radius) { this.radius = radius; }
}
