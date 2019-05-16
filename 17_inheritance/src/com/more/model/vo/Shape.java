package com.more.model.vo;

public class Shape {
	private int x;
	private int y;
	
	public Shape() {}
	
	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double CircleCal(Circle c) {
		return c.getX() * c.getY();
	}
	
	public double RecCal(Rectangle r) {
		return r.getX() * r.getY();
	}
	
	public double calcultor(Shape s ) {
		if(s instanceof Circle) {
			return ((Circle)s).getX() * ((Circle)s).getY();
		}
		else if (s instanceof Rectangle) {
			return ((Rectangle)s).getX() * ((Rectangle)s).getY();
		}
		else {
			return ((Triangle)s).getX() * ((Triangle)s).getY();
		}
	}

	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
}
