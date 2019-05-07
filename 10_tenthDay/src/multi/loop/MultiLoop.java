package multi.loop;

import java.util.Scanner;

public class MultiLoop {
	public static final Scanner CONSOLE = new Scanner(System.in);

	//구구단
	public void test1() {
		for(int i =2; i<=9; i++) {
			System.out.println("=== " + i + "단 ===");
			for(int j =1; j<=9; j++)
				System.out.println(i + " * " + j + " = " + (i*j));
			System.out.println();
		}
	}
	
	//break
	public void test2(){
		label:
		for(int i =2; i<=9; i++) {
			System.out.println("=== " + i + "단 ===");
			for(int j =1; j<=9; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
				if(i*j == 10)
					break label;
			}
			System.out.println();
		}
	}

	//continue
	public void test3(){
		label:
		for(int i =2; i<=9; i++) {
			System.out.println("=== " + i + "단 ===");
			for(int j =1; j<=9; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
				if(i == j)
					continue label;
			}
			System.out.println();
		}
	}	

	public void printStar() {
		System.out.print("별 출력할 행 갯수 입력: ");
		int row = CONSOLE.nextInt();
		String format = "";
		
		if(row <0) System.out.println("양수가 아닙니다.");
		else {
			for(int i =1; i<=row; i++) {
				format = "%"+i+"s";
				System.out.println(String.format(format, i).replace(' ', '*'));
				//using for loops
//				for(int j = 1; j<i; j++)
//					System.out.print("*");
//				System.out.println(i);
			}
		}
	}
	
	public void printRowCol() {
		System.out.print("양의정수 하나 입력: ");
		int num = CONSOLE.nextInt();
		if(num <0) System.out.println("양수가 아닙니다.");
		else {
			for(int i =1 ;i<=num; i++) {
				for(int j=1; j<=num; j++)
					System.out.print(j);
				System.out.println();
			}
		}
	}
	
	public void printStar2() {
		System.out.print("양의정수 하나 입력: ");
		int row = CONSOLE.nextInt();
		String format1 = "", format2 = "";

		if(row <0) System.out.println("양수가 아닙니다.");
		else {
			for(int i =1; i<=row*2-1; i++) {
				if(i<=row) {
					format1 = "%"+i+"s";
					System.out.println(String.format(format1, ' ').replace(' ', '*'));
				}
				else {
					format1 = "%"+(i-row)+"s";
					format2 = "%"+(2*row-i)+"s";
					System.out.println((String.format(format1, ' ')
							+String.format(format2, ' ').replace(' ', '*')));
				}
			}
			
			
			
			
			//sol2
			for(int i =1; i<=row; i++) {
				
			}
		}
	}
	
	public void printMoreStars() {
		int n = 5;

		System.out.println("Q1.");
		for(int i =0;i<n; i++)
			System.out.print('*');

		System.out.println("\nQ2.");
		for(int i=0;i<n; i++)
			System.out.println('*');

		System.out.println("Q3.");
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print('*');
			System.out.println();
		}
		
		System.out.println("Q4.");
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(i+1);
			System.out.println();
		}
		
		System.out.println("Q5.");
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++)
				System.out.print(j+1);
			System.out.println();
		}
		
		System.out.println("Q6.");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(j+i+1);
			System.out.println();
		}
		
		System.out.println("Q7.");
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(n-i+j);
			System.out.println();
		}
		
		System.out.println("Q8.");
		for(int i=0;i<n; i++) {
			for(int j=0; j<i+1; j++)
				System.out.print('*');
			System.out.println();
		}

		System.out.println("Q9.");
		for(int i=0;i<n; i++) {
			for(int j=0; j<n-i; j++)
				System.out.print('*');
			System.out.println();
		}
		
		System.out.println("Q10.");
		for(int i=0;i<n; i++) {
			for(int j=0; j<i; j++)
				System.out.print(' ');
			for(int k=0; k<n-i; k++)
				System.out.print('*');
			System.out.println();
		}
		
		System.out.println("Q11.");
		for(int i=0;i<n; i++) {
			for(int j=0; j<n-i; j++)
				System.out.print(' ');
			for(int k=0; k<i+1; k++)
				System.out.print('*');
			System.out.println();
		}
	}
}
