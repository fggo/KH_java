package EX_Operate;

import java.util.Scanner;

public class EX6_1 {

	public static void main(String[] args) {
		int age;
		String gender;
		Scanner sc=new Scanner(System.in);
		System.out.print("본인의 나이를 입력하세요 : ");
		age=sc.nextInt();
		sc.nextLine();
		System.out.print("본인의 성명을 입력하세요(남,여) : ");
		gender=sc.nextLine();
	
		System.out.println(age>19? gender.equals("남")?"남자입니다. 왼쪽으로 가세요":"여자입니다. 오른쪽으로 오세요":"미성년자입니다. 더커서오세요");
		//System.out.println(age>19? gender.charAt(0)=='남'?"구석으로 가세요":"이쪽으로 오세요":"미성년자입니다. 더커서오세요");
		sc.close();
	}

}
