package ncs.test9;

public class Cargoplane extends Plane{

	public Cargoplane() {
		// TODO Auto-generated constructor stub
	}
	
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		super.setFuelSize(super.getFuelSize() - distance *5);
	}

	@Override
	public void showPlane() {
		System.out.println(super.getPlaneName() + "\t" + getFuelSize());
	}

}
