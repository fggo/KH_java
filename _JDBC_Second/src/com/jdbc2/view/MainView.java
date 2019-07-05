package com.jdbc2.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.jdbc2.controller.EmpController;
import com.jdbc2.model.vo.Employee;

public class MainView {

	private EmpController controller = new EmpController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("=== MAIN MENU ===");
			System.out.println("1. SEARCH ALL EMP");
			System.out.println("2. SEARCH BY EMP NO");
			System.out.println("3. SEARCH BY EMP NAME");
			System.out.println("4. INSERT EMP");
			System.out.println("5. DELETE EMP");
			System.out.println("0. TERMINATE PROGRAM");
			System.out.print("MENU CHOICE >> ");
			int cho = sc.nextInt(); sc.nextLine();
			
			switch(cho) {
				case 1: controller.selectAll(); break;
				case 2: controller.selectId(); break;
				case 3: controller.selectName(); break;
				case 4: controller.insertEmp(); break;
				case 5: controller.deleteEmp(); break;
				case 0: this.displayMsg("TERMINATING THE PROGRAM..."); return;
			}
		} while(true);
		
	}
	
	public String inputData(String type) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== " + type + " 입력 ===");
		System.out.print(type + " 입력 : ");
		return sc.nextLine();
	}

	//화면 페이지 보여주는것과 같음
	public void displayMsg(String msg) {
		System.out.println(msg);
	}
	
	public void displayEmployee(Employee e) {
		System.out.println(e);
	}

	public void displayEmployeeAll(List<Employee> list) {
		for (Employee e : list) {
			System.out.println(e);
		}
	}
	
	public Employee inputEmp() {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		
		System.out.println("=== INSERT EMPLOYEE ===");

		System.out.print("ID : ");
		String emp_id = sc.nextLine();
		emp.setEmpId(emp_id);

		System.out.print("NAME : ");
		String emp_name = sc.nextLine();
		emp.setEmpName(emp_name);

		System.out.print("EMP NO : ");
		String emp_no = sc.nextLine();
		emp.setEmpNo(emp_no);

		System.out.print("EMAIL :  ");
		String email = sc.nextLine();
		emp.setEmail(email);

		System.out.print("PHONE :  ");
		String phone = sc.nextLine();
		emp.setPhone(phone);

		System.out.print("DEPT CODE : ");
		String dept_code = sc.nextLine();
		emp.setDeptCode(dept_code);

		System.out.print("JOB CODE : ");
		String job_code = sc.nextLine();
		emp.setJobCode(job_code);

		System.out.print("SAL LEVEL : ");
		String sal_level = sc.nextLine();
		emp.setSalLevel(sal_level);

		System.out.print("SALARY : ");
		int salary = sc.nextInt(); sc.nextLine();
		emp.setSalary(salary);

		System.out.print("BONUS : ");
		Double bonus = sc.nextDouble(); sc.nextLine();
		emp.setBonus(bonus);

		System.out.print("MANAGER ID : ");
		String manager_id = sc.nextLine();
		emp.setManagerId(manager_id);

		return emp;
	}
}
