package EX_Operate;
import java.util.Scanner;
public class EX2 {
	public static void main(String[] args)
	{
		int a,b;
		Scanner sc=new Scanner(System.in);
		System.out.print("첮번째 정수 입력 : ");
		a=sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		b=sc.nextInt();
		
		System.out.println("더하기 결과 : "+a+"+"+b+"="+(a+b));
		System.out.println("빼기 결과 : "+a+"-"+b+"="+(a-b));
		System.out.println("나누기 결과 : "+a+"/"+b+"="+(a/b));
		System.out.println("나머지 결과 : "+a+"/"+b+" 나머지는 "+(a%b));
		System.out.println("곱하기 결과 : "+a+"*"+b+"="+(a*b));
		sc.close();
	}
}
