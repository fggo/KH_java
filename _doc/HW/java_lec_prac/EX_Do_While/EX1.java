package EX_Do_While;

import java.util.Scanner;

public class EX1 {
	public static void main(String[] args)
	{
		int choice, count=0, sum=0;
		char flag;
		String menu="";
		Scanner sc=new Scanner(System.in);
		
		do{
			System.out.printf("김밥류===============\n1.원조김밥===========1000월\n"
					+ "2.치즈김밥===========1200월\n3.참치김밥===========2000월\n"
					+ "라면================\n4.그냥라면===========1200월\n"
					+ "5.치즈라면===========1500월\n6.짬뽕라면===========2000월\n"
					+"기타================\n7.튀김=============1200월\n"
					+"8.순대=============2500월\n9.오뎅=============1000월\n"
					+"10.음료수============800월\n"
					);
			System.out.print("메뉴선택 : ");
			choice=sc.nextInt();
			System.out.print("수량선택 : ");
			count=sc.nextInt();
			System.out.println(count+"개 주문하셨습니다.");
			sc.nextLine();
			switch(choice)
			{
				case 1 : menu+="원조김밥 : "+count+"개 - "+(count*1000)+"월\n";sum+=(count*1000);break;
				case 2 : menu+="치즈김밥 : "+count+"개 - "+(count*1200)+"월\n";sum+=(count*1200);break;
				case 3 : menu+="참즈김밥 : "+count+"개 - "+(count*2000)+"월\n";sum+=(count*2000);break;
				case 4 : menu+="그냥라면 : "+count+"개 - "+(count*1200)+"월\n";sum+=(count*1200);break;
				case 5 : menu+="치즈라면 : "+count+"개 - "+(count*1500)+"월\n";sum+=(count*1500);break;
				case 6 : menu+="짬뽕라면 : "+count+"개 - "+(count*2000)+"월\n";sum+=(count*2000);break;
				case 7 : menu+="튀김 : "+count+"개 - "+(count*12000)+"월\n";sum+=(count*1200);break;
				case 8 : menu+="순대 : "+count+"개 - "+(count*2500)+"월\n";sum+=(count*2500);break;
				case 9 : menu+="오뎅 : "+count+"개 - "+(count*1000)+"월\n";sum+=(count*1000);break;
				case 10 : menu+="음료수 : "+count+"개 - "+(count*800)+"월\n";sum+=(count*800);break;
				default : System.out.println("메뉴에 없는 번호입니다. 다시입력해주세요");break;
			}
			if(menu!="") 
			{
				System.out.print("추가주문하시겠습니까?(y/n) ");
				
				flag=sc.nextLine().charAt(0);
				
				if(flag!='y' && flag!='Y') break;
			}
			
		}while(true);
		System.out.println("*주문하신 정보는 다음과 같습니다.*\n=========================");
		System.out.println(menu);
		System.out.println("=========================\n총 가격 : "+sum+"원");
	}
}
