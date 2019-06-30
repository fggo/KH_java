package EX_ForinFor;

import java.util.Scanner;

public class EX2 {
	public static void main(String[] args)
	{

		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num=sc.nextInt();
		if(num>0)
		{
			for(int i=1; i<=num;i++)
			{
				for(int j=1;j<=i;j++)
				{
						System.out.print("*");
				}
				System.out.println();
			}
		}
		else if(num<0)
		{
			num*=-1;
			for(int i=1; i<=num;i++)
			{
				for(int j=1;j<=num;j++)
				{
					if(j<i) System.out.print(" ");
					else System.out.print("*");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("출력기능이 없습니다.");
		}
		
	}
}
