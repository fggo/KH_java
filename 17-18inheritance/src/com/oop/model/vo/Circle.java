package com.oop.model.vo;

public class Circle extends Shape{
	private double radius;

	public Circle() {}

	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius = radius;
	}

	public void draw() {
		double area = Math.pow(radius, 2) * Math.PI;
		double circumference = 2 * Math.PI * radius;
		System.out.println("원 넚이: " + area);
		System.out.println("원둘레: "  + circumference);
	}

	public double getRadius() { return radius; }
	public void setRadius(double radius) { this.radius = radius; }
}
