package EX_Condition_Control;

import java.util.Scanner;

public class EX4 {

	public static void main(String[] args)
	{
		int su;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수입력 : ");
		su=sc.nextInt();
		if(0<su && su<=10)
		{
			if(su%2==0)
			{
				System.out.println("짝수다");
			}
			else
			{
				System.out.println("홀수다");
			}
		}
	}
}
