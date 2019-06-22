package ncs.test9;

abstract public class Plane {
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		// TODO Auto-generated constructor stub
	}

	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	public void refuel(int fuel) {
		fuelSize+=fuel;
	}

	abstract public void flight(int distance); //¿îÇ×(Abstract method)
	abstract public void showPlane();


	public String getPlaneName() { return planeName; } 
	public void setPlaneName(String planeName) { this.planeName = planeName; } 
	public int getFuelSize() { return fuelSize; } 
	public void setFuelSize(int fuelSize) { this.fuelSize = fuelSize; }

}
