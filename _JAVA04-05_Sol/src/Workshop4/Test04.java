package Workshop4;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ÀÔ·Â°ª: ");
		int data =sc.nextInt();
		Calc c = new Calc();
		c.calculate(data);
	}
}
