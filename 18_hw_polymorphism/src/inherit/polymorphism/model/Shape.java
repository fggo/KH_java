package inherit.polymorphism.model;

abstract public class Shape {
	public final static double PI =Math.PI;

	abstract public double area(); //면적 계산 리턴용
	abstract public double perimeter(); //둘레 계산 리턴용
}
