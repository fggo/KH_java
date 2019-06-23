package ncs.test9;

public class Airplane extends Plane{

	public Airplane() {
	}

	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		super.setFuelSize(super.getFuelSize() - distance *3);
	}

	@Override
	public void showPlane() {
		System.out.println(super.getPlaneName() + "\t" + getFuelSize());
	}

}
