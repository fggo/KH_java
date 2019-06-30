package EX_Condition_Control;

import java.util.Scanner;

public class EX2 {
	
	public static void main(String[] args)
	{
		int kor, eng, math, total;
		double avg;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("국어성적을 입력하세요 : ");
		kor=sc.nextInt();
		System.out.print("영어성적을 입력하세요 : ");
		eng=sc.nextInt();
		System.out.print("수학성적을 입력하세요 : ");
		math=sc.nextInt();
		total=kor+eng+math;
		System.out.println("총점은 "+total+"점");
		avg=total/3.0;
		System.out.println("평균은 "+avg+"점");
		if(kor>=40 && eng>=40 && math>=40 && avg>=60)
		{
				System.out.println("합격입니다.");
			
		}
		else
		{
			System.out.println("불합격입니다.");
		}
	}
}
