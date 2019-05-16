package com.more.model.vo;

public class Rectangle extends Shape{
	private int point;
	
	public Rectangle() {}
	public Rectangle(int point) {
		this.point = point;
	}

	public int getPoint() { return point; }
	public void setPoint(int point) { this.point = point; }
}
