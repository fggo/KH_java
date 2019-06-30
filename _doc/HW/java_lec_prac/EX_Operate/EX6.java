package EX_Operate;

import java.util.Scanner;

public class EX6 {

	public static void main(String[] args)
	{
		int age;
		Scanner sc=new Scanner(System.in);
		System.out.print("본인의 나이를 입력하세요 : ");
		age=sc.nextInt();
	
		System.out.println(age>19?"성인입니다. 들어오세요":"미성년자입니다. 더커서오세요");
		sc.close();
	}
	
}

