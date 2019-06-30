package EX_While;

import java.util.Scanner;

public class EX2 {
	
	public static void main(String[] args)
	{
		int choice, i=1;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		choice=sc.nextInt();
		
		while(i<=choice)
		{
			if(i%2==0) System.out.print("박");
			else System.out.print("수");
			i++;
		}
	}

}
