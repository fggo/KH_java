package com.practice2.model.entity;

public class Circle extends Point {
	private int radius;
	private final static double PI = Math.PI;

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public void draw() {
		super.draw();
		System.out.printf("면적: .1f\n", PI * radius * radius);
		System.out.printf("둘레: .1f\n", 2 * PI * radius);
	}

	public int getRadius() { return radius; }
	public void setRadius(int radius) { this.radius = radius; }
	public static double getPi() { return PI; }
}
