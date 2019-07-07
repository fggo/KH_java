package Workshop3;

import java.util.Scanner;

public class Calc {
	public void calculate() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		do {
			System.out.print("������ �Է��ϼ��� .(5~10) : ");
			int n = sc.nextInt();
			if(n <5 || n>10)
				System.out.println("�ٽ� �Է��ϼ���.");
			for(int i =2; i<n; i++) {
				if (i%2==0) sum += i;
			}
			break;
		}while(true);
		System.out.println("���: " + sum);
	}
}
