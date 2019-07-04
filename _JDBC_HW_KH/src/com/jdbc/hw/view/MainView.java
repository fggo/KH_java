package com.jdbc.hw.view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			System.out.println("1. Search ALL EMP");
			System.out.println("2. Search EMP BY ");
			System.out.println("3. Insert EMP");
			System.out.println("4. Update EMP");
			System.out.println("5. Delete EMP");
			System.out.println("6. Department Menu");
			System.out.println("7. Job Menu");
			System.out.println("0. Exit");

			System.out.print("Menu Choice >> ");
			cho = sc.nextInt();
			
			switch(cho) {
				case 1: controller.searchAll(); break;
				case 2: subMenuEmp(); break;
				case 3: controller.insertEmp(); break;
				case 4: controller.deleteEmp(); break;
				case 0: System.out.println("TEMINATING PROGRAM...");
					return;
			}

		} while(cho != 0);
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
	public String searchViewById() {
		Scanner sc = new Scanner(System.in);
		System.out.print("SEARCH ID : ");
		String emp_id = sc.nextLine();
		return emp_id;
	}
	
	public String searchViewByName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("SEARCH NAME : ");
		String emp_name = sc.nextLine();
		return emp_name;
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
		emp.setEmp_id(emp_id);

		System.out.print("NAME : ");
		String emp_name = sc.nextLine();
		emp.setEmp_name(emp_name);

		System.out.print("EMP NO : ");
		String emp_no = sc.nextLine();
		emp.setEmp_no(emp_no);

		System.out.print("EMAIL :  ");
		String email = sc.nextLine();
		emp.setEmail(email);

		System.out.print("PHONE :  ");
		String phone = sc.nextLine();
		emp.setPhone(phone);

		System.out.print("DEPT CODE : ");
		String dept_code = sc.nextLine();
		emp.setDept_code(dept_code);

		System.out.print("JOB CODE : ");
		String job_code = sc.nextLine();
		emp.setJob_code(job_code);

		System.out.print("SAL LEVEL : ");
		String sal_level = sc.nextLine();
		emp.setSal_level(sal_level);

		System.out.print("SALARY : ");
		int salary = sc.nextInt(); sc.nextLine();
		emp.setSalary(salary);

		System.out.print("BONUS : ");
		Double bonus = sc.nextDouble(); sc.nextLine();
		emp.setBonus(bonus);

		System.out.print("MANAGER ID : ");
		String manager_id = sc.nextLine();
		emp.setManager_id(manager_id);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date hire_date = null, ent_date = null;
		try {
			System.out.print("HIRE DATE (yyyy-MM-dd) : ");
			hire_date = sdf.parse(sc.nextLine());
			emp.setHire_date(hire_date);

		} catch(ParseException e) {
			e.printStackTrace();
		}

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
		
	}
	
	public void subMenuJob() {
		
	}
	
}
