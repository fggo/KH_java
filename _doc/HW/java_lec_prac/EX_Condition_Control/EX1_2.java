package EX_Condition_Control;

import java.util.Scanner;

public class EX1_2 {

	public static void main(String[] args)
	{
		int A, B, C, total;
		double avg;
		Scanner sc=new Scanner(System.in);
		System.out.print("A 연봉 : ");
		A=sc.nextInt();
		System.out.print("B 연봉 : ");
		B=sc.nextInt();
		System.out.print("C 연봉 : ");
		C=sc.nextInt();
		
		if(A>500)
		{
			System.out.println("A는 고액연봉자입니다.");
		}
		if(B>500){
			System.out.println("B는 고액연봉자입니다.");
			
		}
		if(C>500){
			System.out.println("C는 고액연봉자입니다.");
		}
	}
	
}
