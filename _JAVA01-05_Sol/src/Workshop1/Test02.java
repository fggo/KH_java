package Workshop1;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double sum = 0, multi = 1, avg = 0;
		do {
			System.out.print("Type Integer(5~10) >> ");
			double n = (double)sc.nextInt();
			if(n<5 || n >10) {
				System.out.println("�ٽ� �Է��ϼ���.");
				continue;
			}
			for(int i =1; i <= n; i++) {
				sum+= i;
				multi *=i;
			}
			avg = sum/n;

			System.out.println("��: " + sum);
			System.out.println("��: " + multi);
			System.out.println("���: " + avg);
			break;
			
		} while(true);
	}
}
