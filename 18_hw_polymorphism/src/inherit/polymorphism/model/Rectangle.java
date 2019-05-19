package inherit.polymorphism.model;

public class Rectangle implements IShape{
	private double width;
	private double height;
	
	public Rectangle() {}

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width*height;
	}

	@Override
	public double perimeter() {
		return 2*(width + height);
	}

	public double getWidth() { return width; }
	public void setWidth(double width) { this.width = width; }
	public double getHeigth() { return height; }
	public void setHeigth(double height) { this.height = height; }
}
