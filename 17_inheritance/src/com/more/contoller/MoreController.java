package com.more.contoller;

import java.util.Date;

import com.more.model.vo.Animal;
import com.more.model.vo.Cat;
import com.more.model.vo.Character;
import com.more.model.vo.Circle;
import com.more.model.vo.Dog;
import com.more.model.vo.Rectangle;
import com.more.model.vo.Shape;
import com.more.model.vo.Shield;
import com.more.model.vo.Sword;
import com.more.model.vo.Tiger;
import com.more.model.vo.Triangle;

public class MoreController {
	public void shapeTest() {
		Shape shape=new Shape();
		Circle circle=new Circle();
		Triangle triangle=new Triangle();
		Rectangle rec=new Rectangle();
		
		shape = new Circle();
		System.out.println(shape instanceof Circle);
		System.out.println(shape instanceof Rectangle);
		System.out.println(shape instanceof Shape);
		shape = new Rectangle();
		System.out.println(shape instanceof Circle);
		System.out.println(shape instanceof Rectangle);
		System.out.println(shape instanceof Shape);
		
		Object obj = new Object();
		obj = new Date();
		obj = new String();
		obj = new Circle();
		
		shape=new Circle();
		shape.getX();
		shape.getY();

		((Circle)shape).getRadius();
		Circle c = (Circle)shape;
		shape = new Triangle();
		
//		rec = (Rectangle)shape;// ok but compile error
		rec.getPoint();

		shape.calCircle(new Circle());
		shape.calRec(new Rectangle());

		Shape[] shapes = new Shape[5];
		shapes[0] = new Circle();
		shapes[1] = new Rectangle();
		shapes[2] = new Circle();
		
		System.out.println(shapes[0]); //Circle
		System.out.println(shapes[1]); //Rectangle
		System.out.println(shapes[2]); //Circle

		((Circle)shapes[0]).getRadius();
		shape.calCircle(new Circle());
		shape.calRec(new Rectangle());
	}
	
	public void animalTest() {
		Animal[] ani = new Animal[5];
		ani[0] = new Dog("진도잡종", "알리");
		ani[1] = new Cat("고양이", "치즈");
		ani[2] = new Tiger("호랭이", "바바");

		ani[0].bark();
		ani[1].bark();
		ani[2].bark();
//		ani[0].action(); //ERROR
	}
	
	public void instanceTest() {
		checkObj(new Dog());
		checkObj(new Cat());

	}
	
	public void checkObj(Animal ani) {
		if(ani instanceof Cat)
			((Cat)ani).clean(); //ERROR if ani instanceof Dog
		else if (ani instanceof Dog)
			((Dog)ani).action();
		else if (ani instanceof Tiger)
			((Tiger)ani).attack();
		else
			System.out.println("그런 객체는 없습니다.");
	}
	
	public void createChara() {
		Character c1 = new Character("지짖지", 50, 99, 99, 0, new Sword("광전사검 ", 3000));
		Character c2 = new Character("바바", 50, 99, 99, 0, new Shield("나무방패", 2500));
		
		System.out.println(c1);
		System.out.println(c2);

		((Sword)(c1.getItem())).getAttack();
		((Shield)c2.getItem()).getDefence();
	}
}
