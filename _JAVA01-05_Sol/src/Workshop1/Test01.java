package Workshop1;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type TWO Integers(1~10) >> ");
		double n1 = (double)sc.nextInt();
		double n2 = (double)sc.nextInt(); 
		try {
			if(n1 % n2 > 1)
				System.out.println("�������� 1���� ũ��!");
			else
				System.out.println("�������� 1���� �۰ų� ����!");
		} catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Can't divide by zero!");
		}
	}
}
