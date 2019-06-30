package EX_Operate;

import java.util.Scanner;

public class EX7 {
	
	public static void main(String[] args)
	{
		int A,B,C, sum;
		double avg;
		Scanner sc= new Scanner(System.in);
		System.out.print("A의 연봉을 입력하세요 : ");
		A=sc.nextInt();
		System.out.print("B의 연봉을 입력하세요 : ");
		B=sc.nextInt();
		System.out.print("C의 연봉을 입력하세요 : ");
		C=sc.nextInt();
		sum=A+B+C;
		avg=sum/3.0;
		//System.out.println("회사 연봉의 총 합은 : "+(A+B+C));
		//System.out.println("회사 연봉의 총 합은 : "+(A+B+C)/3.0);
		System.out.println("회사 연봉의 총 합은 : "+sum+"만원");
		System.out.printf("회사 연봉의 총 합은 : %.2f만원\n",avg);
		
		A+=A*0.05;
		C+=C*0.1;
		System.out.println("A의 인센티브포함한 급여는 : "+A+"만원");
		System.out.println("B의 인센티브포함한 급여는 : "+B+"만원");
		System.out.println("C의 인센티브포함한 급여는 : "+C+"만원");
		sc.close();
		
	}
	
	
}
