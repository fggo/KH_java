package EX_Operate;

import java.util.Scanner;

public class EX5 {

	public static void main(String[] args)
	{
		int a,b;
		double c;
		Scanner sc=new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하세요");
		a=sc.nextInt();
		System.out.print("두번째 정수를 입력하세요");
		b=sc.nextInt();
		System.out.print("실수 한개를 입력하세요");
		c=sc.nextDouble();
		
		a+=20;
		b*=3;
		c/=4;
		a%=b;
		c-=a;
		
		System.out.println("a : "+a+"  b : "+b+"  c : "+c);
		sc.close();
		
	}
	
}
