package EX_Condition_Control;

import java.util.Scanner;

public class EX1 {

	public static void main(String[] args)
	{
		int kor, eng, math, total;
		double avg;
		Scanner sc=new Scanner(System.in);
		System.out.print("국어 점수 : ");
		kor=sc.nextInt();
		System.out.print("영어 점수 : ");
		eng=sc.nextInt();
		System.out.print("수학 점수 : ");
		math=sc.nextInt();
		
		total=kor+eng+math;
		System.out.println("총점 : "+total);
		if(total>=250) //if((kor+eng+math)>=250)
		{
			System.out.println("우수생입니다.");
		}
	}
	
}
