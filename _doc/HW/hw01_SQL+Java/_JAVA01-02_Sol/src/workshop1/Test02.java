package workshop1;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double sum = 0, multi = 1, avg = 0;
		do {
			System.out.print("Type Integer(5~10) >> ");
			double n = (double)sc.nextInt();
			if(n<5 || n >10) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			for(int i =1; i <= n; i++) {
				sum+= i;
				multi *=i;
			}
			avg = sum/n;

			System.out.println("합: " + sum);
			System.out.println("곱: " + multi);
			System.out.println("평균: " + avg);
			break;
			
		} while(true);
	}
}
