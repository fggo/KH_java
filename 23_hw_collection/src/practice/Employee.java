package practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Employee {
	private String name;
	private int age;
	private String job;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, int age, String job, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return name + " " + age + " " + job + " " + salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee e = (Employee)obj;
			if(this.name.equals(e.getName())
					&& this.age==e.getAge()
					&& this.job.equals(e.getJob())
					&& this.salary == e.getSalary())
					return true;
			else
				return false;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age,job,salary);
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getJob() { return job; }
	public void setJob(String job) { this.job = job; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	
//	홍길동 29 대리 300
//	이순신 30 과장 500
//	유병승 18 사장 1000
//	장길산 85 고문 10
//	용석 26 인턴 1

//	1. arrayList를 이용한 사원들을 관리해보자
//	   위의 데이터를 넣고 출력해보자
//	2. set을 이용하여 사원관리를 해보자
//	   위의 데이터를 넣고 출력해보자
//	   출력 후 유병승 18 사장 1000을 다시 넣고 출력해보자(안들어가야겠죠?)
//	3. HashMap을 이용하여 데이터를 넣고 출력해보자

	public static void main(String[] args) {
//		List<Employee> list = new ArrayList<Employee>();
		Set<Employee> set = new HashSet<Employee>();
		set.add(new Employee("홍길동", 29, "대리", 300));
		set.add(new Employee("이순신", 30, "과장", 500));
		set.add(new Employee("유병승", 18, "사장", 1000));
		set.add(new Employee("장길산", 85, "고문", 10));
		set.add(new Employee("용석", 26, "인턴", 1));
		

		Iterator<Employee> itr = set.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println();

		set.add(new Employee("유병승", 18, "사장", 1000));

		itr = set.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
