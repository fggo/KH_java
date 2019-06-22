package ncs.test9;

public class PlaneTest {
	public static void main(String[] args) {
		Plane airPlane = new Airplane("L747", 1000);
		Plane cargoPlane = new Cargoplane("C40", 1000);
		
		System.out.println("Plane\tfuelSize");
		System.out.println("------------------");
		airPlane.showPlane();
		cargoPlane.showPlane();

		System.out.println("100 운항");

		airPlane.flight(100);
		cargoPlane.flight(100);

		System.out.println("Plane\tfuelSize");
		System.out.println("------------------");
		airPlane.showPlane();
		cargoPlane.showPlane();
		
		System.out.println("200 주유");

		airPlane.refuel(200);
		cargoPlane.refuel(200);

		System.out.println("Plane\tfuelSize");
		System.out.println("------------------");
		airPlane.showPlane();
		cargoPlane.showPlane();

	}
}
