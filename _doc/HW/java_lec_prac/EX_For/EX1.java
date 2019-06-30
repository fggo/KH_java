package EX_For;

import java.util.Scanner;

public class EX1 {

	public static void main(String[] args)
	{
		int su, sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수입력 : ");
		su=sc.nextInt();
		for(int i=0;i<=su;i++)
		{
			if(su%2==0)
			{
				sum+=i;
			}
		}
		System.out.println("짝수의 합 : "+sum);
	}
	
}
