package ncs.test10;

public class Company {
	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		employees[1] = new Sales("Clinten", 2, "sales", 1200);
		
		System.out.println("name\tdepartment\tsalary");
		System.out.println("------------------------------");
		for(int i =0; i<employees.length; i++) {
			System.out.println(employees[i]);
			if(employees[i] instanceof Secretary) ((Secretary)employees[i]).incentive(100);
			if(employees[i] instanceof Sales) ((Sales)employees[i]).incentive(100);
		}
		
		

		System.out.println("\nname\tdepartment\tsalary");
		System.out.println("------------------------------");
		for(int i =0; i<employees.length; i++)
			System.out.println(employees[i]);
	}
}
