package EX_Condition_Control;

import java.util.Scanner;

public class EX4_2 {

	public static void main(String[] args)
	{
		int weight;
		double height,bmi;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("키입력 : ");
		height=sc.nextDouble()/100;
		System.out.print("몸무게 입력 : ");
		weight=sc.nextInt();
		bmi=weight/(height*height);
		
		if(bmi<20)
		{
			System.out.println("저체웅");
		}
		else if(20<=bmi && bmi<25)
		{
			System.out.println("정상체중");
		}
		else if(25<=bmi && bmi<30)
		{
			System.out.println("과제중");
		}			
		else if(bmi>30)
		{
			System.out.println("비만");
		}
		
	}
	
}
