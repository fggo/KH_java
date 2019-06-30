package EX_While;

import java.util.Scanner;

public class EX4 {
	
	public static void main(String[] args)
	{
		int i=0,count=0;
		String str;
		char ch;
		Scanner sc=new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		str=sc.nextLine();
		System.out.print("검색 문자입력 : ");
		ch=sc.nextLine().charAt(0);
		
		while(i<str.length())
		{
			if('A'<=str.charAt(i) && str.charAt(i)<='z')
			{
				if(str.charAt(i) == ch) count++;
			}
			else
			{
				System.out.println("영문자가 아닙니다.");
				i=str.length();
			}
			i++;
		}
		if(i!=str.length()+1) System.out.println("포함된 갯수 : "+count+"개");
	}
}
