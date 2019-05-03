package practice.run;

import java.util.Scanner;

public class Run {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void selectMenu() {
		System.out.println("*** 메뉴를 선택하세요 ***");
		System.out.println("햄버거 ***************");
		System.out.println("1. 불고기버거	3500원");
		System.out.println("2. 치킨버거	3200원");
		System.out.println("추가 ****************");
		System.out.println("3. 감자튀김	1000원");
		System.out.println("4. 치즈스틱	400원");
		System.out.println("5. 샐러드		2000원");
		System.out.println("음료수 ***************");
		System.out.println("6. 콜라		700원");
		System.out.println("7. 에이드		1200원");
		System.out.println("8. 커피		1000원");
		System.out.println("********************");
		int choice = CONSOLE.nextInt(); CONSOLE.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("불고기버거를 선택하셨습니다.");
			break;
		case 2:
			System.out.println("");
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		default:
			break;
				
		}
	}
	
	
	public static void printStar1() {
		System.out.print("양의정수를 입력: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();

		String str = "";
		
		for(int i =0 ;i<num; i++) {
			str = String.format("%" + (i+1) + "s", String.valueOf(i+1)).replace(' ', '*');
			System.out.println(str);
		}
	}
	
	public void printStar2() {
//		System.out.println("정수를 입력: ");
//		int num = CONSOLE.nextInt();
//		CONSOLE.nextLine();

	}
}
