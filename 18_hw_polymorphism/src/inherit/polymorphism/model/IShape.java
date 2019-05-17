package inherit.polymorphism.model;

public interface IShape {
	public final static double PI =Math.PI;

	public double area(); //면적 계산 리턴용
	public double perimeter(); //둘레 계산 리턴용
}
