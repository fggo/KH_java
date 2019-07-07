package Workshop4;

import java.util.Random;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1=0,n2=0;
		System.out.print("두개의 정수입력(1~5): ");
		n1=sc.nextInt();
		n2=sc.nextInt();
		if(n1<1 || n1>5 || n2<1 || n2>5) {
			System.out.println("숫자를 확인하세요.");
			return;
		}
		double sum=0;
		int [][]arr = new int[n1][n2];
		for(int i =0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = (new Random()).nextInt(5)+1;
				sum+=arr[i][j];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.printf("sum=%.1f\n", sum);
		System.out.printf("avg=%.1f\n", sum/(n1*n2));
	}
}
