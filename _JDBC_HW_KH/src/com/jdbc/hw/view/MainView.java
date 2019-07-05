package com.jdbc.hw.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc.hw.controller.EmpController;
import com.jdbc.hw.model.vo.Employee;


//1. 전체사원 조회
//2. 조회
//	-> 서브메뉴: 1.아이디 2.이름 3.부서 4.연봉(이상)
//3. 사원 등록
//4. 사원 수정
//5. 사원 삭제
//6. 부서 관리
//	-> 서브메뉴: 1.등록 2.수정 3.삭제
//7. 직책 관리
//	-> 서브메뉴: 1.등록 2.수정 3.삭제
public class MainView {
	private EmpController controller = new EmpController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		int cho= 0;

		do {
			System.out.println("=== MAIN MENU ===");
			System.out.println("=== E   M   P ===");
			System.out.println("1. Search ALL EMP");
			System.out.println("2. Search EMP BY ");
			System.out.println("3. Insert EMP");
			System.out.println("4. Update EMP");
			System.out.println("5. Delete EMP");
			System.out.println("=== D  E  P  T===");
			System.out.println("6. Department SubMenu");
			System.out.println("=== J   O   B ===");
			System.out.println("7. Job SubMenu");
			System.out.println("0. Exit");

			System.out.print("Menu Choice >> ");
			cho = sc.nextInt();
			
			switch(cho) {
				case 1: controller.searchAll(); break;
				case 2: subMenuEmp(); break;
				case 3: controller.insertEmp(); break;
				case 4: controller.updateEmp(); break;
				case 5: controller.deleteEmp(); break;
				case 0: System.out.println("TEMINATING PROGRAM...");
					return;
			}

		} while(true);
	}
	
	public void subMenuEmp() {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== SEARCH BY ===");
		System.out.println("1. Search By EMP ID");
		System.out.println("2. Search By EMP NAME");
		System.out.println("3. Search By EMP DEPT");
		System.out.println("4. Search By EMP SAL");
		System.out.print("SEACH Menu Choice >> ");
		int cho = sc.nextInt();
		
		switch(cho) {
			case 1: controller.searchById(); break;
			case 2: controller.searchByName(); break;
			case 3: controller.searchByDept(); break;
			case 4: controller.searchBySal(); break;
		}
	}
	public String inputData(String type) {
		Scanner sc = new Scanner(System.in);
		if(type.equals("ID"))
			System.out.print("ID : ");
		else if (type.equals("NAME"))
			System.out.print("NAME : ");

		return sc.nextLine();
	}
	
	public String searchViewByDept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("SEARCH DEPT : ");
		String dept_code = sc.nextLine();
		return dept_code;
	}

	public int searchViewBySalary() {
		Scanner sc = new Scanner(System.in);
		System.out.print("SEARCH SALARY : ");
		int salary = sc.nextInt();
		return salary;
	}

	public Employee insertViewEmp() {
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
	
	public Employee updateViewEmp() {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		
		System.out.println("=== UPDATE EMPLOYEE ===");

		System.out.print("TYPE ID BEFORE UPDATE : ");
		String emp_id = sc.nextLine();
		emp.setEmpId(emp_id);

		System.out.print("NAME : ");
		String emp_name = sc.nextLine();
		emp.setEmpName(emp_name);

		System.out.print("EMAIL :  ");
		String email = sc.nextLine();
		emp.setEmail(email);

		return emp;
	}

	public String deleteViewEmp() {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		
		System.out.println("=== DELETE EMPLOYEE ===");

		System.out.print("ID : ");
		String emp_id = sc.nextLine();

		return emp_id;
	}

	public void subMenuDept() {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== DEPARTMENT SUBMENU ===");
		System.out.println("1. INSERT DEPT");
		System.out.println("2. UPDATE DEPT");
		System.out.println("3. DELETE DEPT");
		System.out.print("DEPT MENU Choice >> ");
		int cho = sc.nextInt();
		
		switch(cho) {
//			case 1: controller.insertDept(); break;
//			case 2: controller.updateDept(); break;
//			case 3: controller.deleteDept(); break;
		}
	}
	
	public void subMenuJob() {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== JOB SUBMENU ===");
		System.out.println("1. INSERT JOB");
		System.out.println("2. UPDATE JOB");
		System.out.println("3. DELETE JOB");
		System.out.print("JOB MENU Choice >> ");
		int cho = sc.nextInt();
		
		switch(cho) {
//			case 1: controller.insertJob(); break;
//			case 2: controller.updateJob(); break;
//			case 3: controller.deleteJob(); break;
		}
	}
	
	public void displayEmp(Employee e) {
		System.out.println(e);
	}

	public void displayEmpAll(List<Employee> list) {
		for(Employee e : list)
			System.out.println(e);
	}

	public void displayMsg(String msg) {
		System.out.println(msg);
	}
}
