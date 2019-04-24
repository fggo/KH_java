package emp.run;

import emp.model.vo.Employee;
import product.model.vo.Products;

public class TestEmp {
	public static void main(String[] args) {
		new Employee().printEmployee();
		Products.printProduct(); // static method
	}
}