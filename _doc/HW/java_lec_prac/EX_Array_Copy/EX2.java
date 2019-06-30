package EX_Array_Copy;

import java.util.Arrays;
import java.util.Scanner;

public class EX2 {

	public static void main(String[] args) {
		
		char value[]=new char[4];
		char input[]=new char[4];
		int strike=0, ball=0;
		int count=0;
		String temp;
		Scanner sc=new Scanner(System.in);
		System.out.println("============ 지금부터 야구게임을 시작하지 ============");
		for(int i=0;i<4;i++)
		{   
			int temp1=(int)(Math.random()*9);
			value[i]=(Integer.toString(temp1)).charAt(0);
			
				for(int j=0;j<i;j++)
				{
					if(value[i]==value[j])
					{
						i--;break;
					}
				}
		}
		
		while(true)
		{
			strike=0;ball=0;
			count++;
			System.out.print("숫자 입력 : ");
			temp=sc.nextLine();
			
			if(temp.length()!=4)
			{
				System.out.println("숫자를 4개 입력해야합니다.");
			}
			else
			{
				//비교배열에 값대입
				for(int i=0;i<4;i++)
				{
					input[i]=temp.charAt(i);
				}
				//값비교
				for(int i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
						if(i==j && value[i]==input[j])
						{
							strike++;
							break;
						}
						else if(i!=j && value[i]==input[j])
						{
							ball++;
							break;
						}
					}
				}
				if(strike==4)
				{
					System.out.println("정답입니다. "+count+"번 실행"); break;
				}
				else
				{
					System.out.println(strike+"스트라이크 "+ball+"볼 입니다.");	
				}
			}
		}
	}
}
