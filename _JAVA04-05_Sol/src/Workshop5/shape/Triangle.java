package Workshop5.shape;

public class Triangle extends Shape implements Resize{

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);
	}
	@Override
	public void setResize(int size) {
		setHeight(getHeight() + size);
	}

	@Override
	public double getArea() {
		return (double)getWidth()*getHeight()/2.0;
	}

	@Override
	public void showShape() {
		System.out.printf("%s\t%.1f\t%s\n", "Triangle", getArea(), getColors());
	}
}
