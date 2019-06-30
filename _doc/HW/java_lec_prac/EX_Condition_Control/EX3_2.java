package EX_Condition_Control;

import java.util.Scanner;

public class EX3_2 {

	public static void main(String[] args) {
		int a, b;
		char str;
		Scanner sc=new Scanner(System.in);
		System.out.print("첫벌째 피연산자를 입력하세요 : ");
		a=sc.nextInt();
		System.out.print("두벌째 피연산자를 입력하세요 : ");
		b=sc.nextInt();
		sc.nextLine();
		System.out.print("연산자를 입력해주세요(+,-,*,/) :  ");
		str=sc.nextLine().charAt(0);
		if(a<0 && b<0) 
		{
			System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
		}
		else if(str=='+')
		{
			System.out.println(a+"+"+b+"="+a+b);
		}
		else if(str=='-')
		{
			System.out.println(a+"-"+b+"="+(a-b));
		}
		else if(str=='*')
		{
			System.out.println(a+"*"+b+"="+(a*b));
		}
		else if(str=='/')
		{
			System.out.println(a+"/"+b+"="+(a/b));//System.out.println(a+"/"+b+"="+((float)a/b));
		}
		else
		{
			System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
		}
	}
}