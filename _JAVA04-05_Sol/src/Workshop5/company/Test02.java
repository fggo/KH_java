package Workshop5.company;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("월기본급: ");
		double salary = sc.nextDouble();
		Company c = new Company(salary);
		c.showCompanyInfo();
	}
}
