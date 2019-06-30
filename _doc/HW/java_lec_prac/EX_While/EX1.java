package EX_While;

import java.util.Scanner;

public class EX1 {

	public static void main(String[] args) {
			
		int su,i=1, sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		su=sc.nextInt();
		
		while(i<=su)
		{
			if(i%2==0) sum+=i;
			i++;
		}
		System.out.println(sum);
	}

}
