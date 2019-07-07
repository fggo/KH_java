package Workshop5.shape;

public class Rectangle extends Shape implements Resize{
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
	}

	@Override
	public void setResize(int size) {
		setWidth(getWidth() + size);
	}

	@Override
	public double getArea() {
		return (double)getWidth()*getHeight();
	}
	
	@Override
	public void showShape() {
		System.out.printf("%s\t%.1f\t%s\n", "Rectangle", getArea(), getColors());
	}
}
