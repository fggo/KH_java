package logic.view;

import java.util.Scanner;

import logic.controller.Function;

public class Menu {
	public static final Scanner CONSOLE = new Scanner(System.in);
	static Function function = new Function();
	
	public static void displayMenu() {
		int no = 0;

		do {
			System.out.println("1. 간단 계산기");
			System.out.println("2. 작은수에서 큰수까지 합계구하기 ");
			System.out.println("3. 신상정보 확인하기");
			System.out.println("4. 학생성적 정보 확인하기");
			System.out.println("5. 별과 숫자 출력하기 ");
			System.out.println("6. 난수까지의 합게 구하기 ");
			System.out.println("7. 구구단 ");
			System.out.println("8. 주사위 숫자 알아맞추기 게임 ");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 입력: ");

			no = CONSOLE.nextInt();
			switch(no) {
			case 1: function.calculator(); break;
			case 2: function.totalCalculator(); break;
			case 3: function.profile(); break;
			case 4: function.sungjuk(); break;
			case 5: function.printStarNumber(); break;
			case 6: function.sumRandomNumber(); break;
			case 7: function.continueGugudan(); break;
			case 8: function.shutNumber(); break;
			case 9: System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				break;
			}
		}while(no != 9);
	}
}
