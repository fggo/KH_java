package EX_While;

import java.util.Scanner;

public class EX3 {

	public static void main(String[] args) {
	
		int cho,i=1;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수입력 : ");
		cho=sc.nextInt();
		while(i<10)
		{
			System.out.println(cho+" X "+i+" = "+(cho*i));
			i++;
		}
		
	}

}
