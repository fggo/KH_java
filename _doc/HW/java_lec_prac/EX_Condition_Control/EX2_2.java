package EX_Condition_Control;

import java.util.Scanner;

public class EX2_2 {

	public static void main(String[] args)
	{
		String name, gender;
		int grade, class_num, num;
		double avg;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("학생이름 : ");
		name=sc.nextLine();
		System.out.print("학년 : ");
		grade=sc.nextInt();
		System.out.print("반 : ");
		class_num=sc.nextInt();
		System.out.print("번호 : ");
		num=sc.nextInt();
		sc.nextLine();
		System.out.print("성별(M/F) : ");
		gender=sc.nextLine();
		System.out.print("성적 : ");
		avg=sc.nextDouble();
		
		if(gender.charAt(0)=='M')
		{
			gender="남학생";
		}
		else
		{
			gender="여학생";
		}
		
		System.out.printf("%d학년 %d반 %d번 %s %s은 성적이 %.2f이다.",grade, class_num, num, gender, name, avg);
	}
	
}
