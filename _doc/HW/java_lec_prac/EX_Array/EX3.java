package EX_Array;

import java.util.Scanner;

public class EX3 {

	public static void main(String[] args)
	{
		int input;
		Scanner sc=new Scanner(System.in);
		System.out.print("양의 정수입력 : ");
		input=sc.nextInt();
		
		int arr[]=new int[input];
		
		if(input%2!=0)
		{
			int num=0;
			for(int i=0;i<arr.length;i++)
			{
				
				if(arr.length/2>=i)
				{
					arr[i]=i+1;	
				}
				else 
				{
					num+=2;
					arr[i]=(i+1)-num;
				}
			}
			for(int temp : arr)
			{
				System.out.print(temp);
			}
		}
		else System.out.println("홀수가 아닙니다. 홀수를 입력해주세요");
	}
	
}
