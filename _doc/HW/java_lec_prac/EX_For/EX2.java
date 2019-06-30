package EX_For;

import java.util.Scanner;

public class EX2 {

	public static void main(String[] args)
	{
		int su;
		String temp="";
		Scanner sc=new Scanner(System.in);
		System.out.print("정수입력 : ");
		su=sc.nextInt();
		
		for(int i=1;i<=su;i++)
		{
			if(i%2==0) temp+="박";
			else temp+="수";
		}
		System.out.println(temp);
	}
	
}

