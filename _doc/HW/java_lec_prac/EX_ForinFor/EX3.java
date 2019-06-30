package EX_ForinFor;

import java.util.Scanner;

public class EX3 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num=sc.nextInt();
		int num2=num;
			for(int i=1; i<=num;i++)
			{
				for(int j=1;j<=i;j++)
				{
						System.out.print("*");
				}
				System.out.println();
			}

			
			for(int i=1; i<=num2;i++)
			{
				for(int j=1;j<=num2;j++)
				{
					if(j<=i) System.out.print(" ");
					else System.out.print("*");
				}
				System.out.println();
			}
	}
}
