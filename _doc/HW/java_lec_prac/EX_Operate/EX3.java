package EX_Operate;
import java.util.Scanner;
public class EX3 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("첫번째 입력 : ");
		int a= sc.nextInt();
		System.out.print("두번째 입력 : ");
		int b= sc.nextInt();
		
		System.out.println(a+"!="+b+"은 "+(a!=b)+"이다.");
		System.out.println(a+"<"+b+"은 "+(a<b)+"이다.");
		System.out.println(a+"="+b+"은 "+(a==b)+"이다.");
		System.out.println(a+">"+b+"은 "+(a>b)+"이다.");
		sc.close();
	}

	
}
