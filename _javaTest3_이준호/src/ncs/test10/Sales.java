package ncs.test10;

public class Sales extends Employee implements Bonus{
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public String toString() {
		return getName() + "\t" + getDepartment()+ "\t" + getSalary() + "\t" + tax();
	}

	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(1.2*pay));
	}

	@Override
	public double tax() {
		return getSalary()*.13;
	}

}
