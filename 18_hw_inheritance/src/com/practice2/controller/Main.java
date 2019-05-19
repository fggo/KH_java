package com.practice2.controller;

import com.practice2.model.entity.Circle;
import com.practice2.model.entity.Point;
import com.practice2.model.entity.Rectangle;

public class Main {
	public static void main(String[] args) {
		Circle[] cirArr = {new Circle(1,2, 4),
					new Circle(4, 4, 8),
					new Circle(2,7, 6)};
		for(Circle cir : cirArr)
			cir.draw();

		Rectangle[] recArr = {new Rectangle(1, 1, 5, 7),
					new Rectangle(1, 6, 2, 4),
					new Rectangle(2, 6, 2, 1)};
		for(Rectangle rec : recArr)
			rec.draw();

		Point[] ptArr = {new Point(1,2), new Point(2,3), new Point(6,3),
					new Point(7,7), new Point(4,6)};
		for(Point pt : ptArr)
			pt.draw();
	}
}
