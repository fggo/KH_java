package ncs.test10;

public class Secretary extends Employee implements Bonus{
	
	public Secretary() {
		// TODO Auto-generated constructor stub
	}

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public String toString() {
		return getName() + "\t" + getDepartment()+ "\t" + getSalary() + "\t" + tax();
	}

	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(.8*pay));
	}

	@Override
	public double tax() {
		return getSalary()*.1;
	}

}
