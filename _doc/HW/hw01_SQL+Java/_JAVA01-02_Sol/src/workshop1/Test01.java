package workshop1;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type TWO Integers(1~10) >> ");
		double n1 = (double)sc.nextInt();
		double n2 = (double)sc.nextInt(); 
		try {
			if(n1 % n2 > 1)
				System.out.println("나머지가 1보다 크다!");
			else
				System.out.println("나머지가 1보다 작거나 같다!");
		} catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Can't divide by zero!");
		}
	}
}
