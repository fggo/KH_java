package EX_Operate;
import java.util.Scanner;
public class EX1 {

		public static void main(String[] args)
		{
			int a,b,c;
			Scanner sc=new Scanner(System.in);
			System.out.print("젓번째 정수를 입력하세요 : ");
			a=sc.nextInt();
			System.out.print("두번째 정수를 입력하세요 : ");
			b=sc.nextInt();
			System.out.print("세번째 정수를 입력하세요 : ");
			c=sc.nextInt();
			
			a++;
			b=(--a)+b;
			c=(a++)+(--b);
			
			System.out.println("a="+a+"   b="+b+"   c="+c);
			sc.close();
		}
}
