package EX_Array;

import java.util.Scanner;

public class EX2 {
	
	public static void main(String[] args)
	{
		String str[]=new String[5];
		str[0]="바나나";
		str[1]="복숭아";
		str[2]="키위";
		str[3]="사과";
		
		System.out.println(str[0]);
		//for문 이용
		Scanner sc=new Scanner(System.in);
		
		String[] str1=new String[5];
		for(int i=0;i<str.length;i++)
		{
			System.out.print(i+1+"번째 입력값 : ");
			str1[i]=sc.nextLine();
		}
		
		for(String temp : str1)
		{
			System.out.print(temp);
		}
		sc.close();
	}
}
