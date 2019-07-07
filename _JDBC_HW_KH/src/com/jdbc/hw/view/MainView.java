package com.jdbc.hw.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc.hw.controller.DeptController;
import com.jdbc.hw.controller.EmpController;
import com.jdbc.hw.controller.JobController;
import com.jdbc.hw.model.vo.Department;
import com.jdbc.hw.model.vo.Employee;
import com.jdbc.hw.model.vo.Job;

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
	private EmpController empController = new EmpController();
	private DeptController deptController = new DeptController();
	private JobController jobController = new JobController();

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
				case 1: empController.searchAll(); break;
				case 2: this.subMenuEmp(); break;
				case 3: empController.insertEmp(); break;
				case 4: empController.updateEmp(); break;
				case 5: empController.deleteEmp(); break;
				case 6: this.subMenuDept(); break;
				case 7: this.subMenuJob(); break;
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
			case 1: empController.searchById(); break;
			case 2: empController.searchByName(); break;
			case 3: empController.searchByDept(); break;
			case 4: empController.searchBySal(); break;
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
		
		System.out.println("=== INSERT EMPLOYEE ===");

		System.out.print("ID : ");
		String empId = sc.nextLine();

		System.out.print("NAME : ");
		String empName = sc.nextLine();

		System.out.print("EMP PERSONAL NO : ");
		String empNo = sc.nextLine();

		System.out.print("EMAIL :  ");
		String email = sc.nextLine();

		System.out.print("PHONE :  ");
		String phone = sc.nextLine();

		System.out.print("DEPT CODE : ");
		String deptCode = sc.nextLine();

		System.out.print("JOB CODE : ");
		String jobCode = sc.nextLine();

		System.out.print("SAL LEVEL : ");
		String salLevel = sc.nextLine();

		System.out.print("SALARY : ");
		int salary = sc.nextInt(); sc.nextLine();

		System.out.print("BONUS : ");
		Double bonus = sc.nextDouble(); sc.nextLine();

		System.out.print("MANAGER ID : ");
		String managerId = sc.nextLine();

		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpNo(empNo);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setDeptCode(deptCode);
		emp.setJobCode(jobCode);
		emp.setSalLevel(salLevel);
		emp.setSalary(salary);
		emp.setBonus(bonus);
		emp.setManagerId(managerId);

		return emp;
	}
	
	public Employee updateViewEmp() {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		
		System.out.println("=== UPDATE EMPLOYEE ===");

		System.out.print("EMP ID FOR UPDATE : ");
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
		
		System.out.println("=== DELETE EMPLOYEE ===");

		System.out.print("ID : ");
		String emp_id = sc.nextLine();

		return emp_id;
	}

	public void subMenuDept() {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== DEPARTMENT SUBMENU ===");
		System.out.println("1. SEARCH ALL DEPT");
		System.out.println("2. INSERT DEPT");
		System.out.println("3. UPDATE DEPT");
		System.out.println("4. DELETE DEPT");
		System.out.print("DEPT MENU Choice >> ");

		int cho = sc.nextInt();
		switch(cho) {
			case 1: deptController.searchAll(); break;
			case 2: deptController.insertDept(); break;
			case 3: deptController.updateDept(); break;
			case 4: deptController.deleteDept(); break;
		}
	}
	
	public Department insertViewDept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("DEPT ID : ");
		String deptId = sc.nextLine();
		
		System.out.print("DEPT TITLE : ");
		String deptTitle = sc.nextLine();

		System.out.print("LOCATION ID : ");
		String locationId = sc.nextLine();
		
		Department dept = new Department();
		dept.setDeptId(deptId);
		dept.setDeptTitle(deptTitle);
		dept.setLocationId(locationId);
		
		return dept;
	}

	public Department updateViewDept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("DEPT ID FOR UPDATE : ");
		String deptId = sc.nextLine();
		
		System.out.print("DEPT TITLE : ");
		String deptTitle = sc.nextLine();

		System.out.print("LOCATION ID : ");
		String locationId = sc.nextLine();
		
		Department dept = new Department();
		dept.setDeptId(deptId);
		dept.setDeptTitle(deptTitle);
		dept.setLocationId(locationId);
		
		return dept;
	}

	public String deleteViewDept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("DEPT ID : ");
		String deptId = sc.nextLine();
		
		return deptId;
	}

	public void subMenuJob() {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== JOB SUBMENU ===");
		System.out.println("1. SEARCH ALL JOB");
		System.out.println("2. INSERT JOB");
		System.out.println("3. UPDATE JOB");
		System.out.println("4. DELETE JOB");
		System.out.print("JOB MENU Choice >> ");
		int cho = sc.nextInt();
		
		switch(cho) {
			case 1: jobController.searchAll(); break;
			case 2: jobController.insertJob(); break;
			case 3: jobController.updateJob(); break;
			case 4: jobController.deleteJob(); break;
		}
	}
	
	public Job insertViewJob() {
		Scanner sc = new Scanner(System.in);
		System.out.print("JOB CODE : ");
		String jobCode = sc.nextLine();
		
		System.out.print("JOB NAME : ");
		String jobName = sc.nextLine();

		Job job = new Job();
		job.setJobCode(jobCode);
		job.setJobName(jobName);
		
		return job;
	}

	public Job updateViewJob() {
		Scanner sc = new Scanner(System.in);
		System.out.print("JOB CODE FOR UPDATE : ");
		String jobCode = sc.nextLine();
		
		System.out.print("JOB NAME : ");
		String jobName = sc.nextLine();

		Job job = new Job();
		job.setJobCode(jobCode);
		job.setJobName(jobName);
		
		return job;
	}

	public String deleteViewJob() {
		Scanner sc = new Scanner(System.in);
		System.out.print("JOB CODE : ");
		String jobCode = sc.nextLine();
		
		return jobCode;
	}

	public <T> void display(T obj) {
		System.out.println(obj);
	}

	public <T> void displayList(List<T> list) {
		for(T obj : list)
			System.out.println(obj);
	}

	public void displayMsg(String msg) {
		System.out.println(msg);
	}
}
