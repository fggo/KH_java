package logic.home.view;

import java.util.Scanner;

import logic.home.model.VariableSample;
import logic.home.model.PrimitiveTypeSample;
import logic.home.model.IfSample;
import logic.home.model.SwitchSample;
import logic.home.model.ForSample;
import logic.home.model.WhileSample;
import logic.home.model.DoWhileSample;
import logic.home.model.BreakSample;
import logic.home.model.ContinueSample;
import logic.home.model.StaticMethodSample;
import logic.home.model.NonStaticMethodSample;


public class Menu {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public static void mainMenu(){
		int choice = 0;
		char answer = '\u0000';
		
		do {
			System.out.println("***** 프로그래밍 기본 기능 테스트 프로그램 *****");
			System.out.println("1. 변수 테스트");
			System.out.println("2. 기본 자료형 테스트");
			System.out.println("3. if문 테스트");
			System.out.println("4. switch문 테스트");
			System.out.println("5. for문 테스트");
			System.out.println("6. while문 테스트");
			System.out.println("7. do~while문 테스트");
			System.out.println("8. break문 테스트");
			System.out.println("9. continue문 테스트");
			System.out.println("10. static 메소드 사용 테스트");
			System.out.println("11. non-static 메소드 사용 테스트");
			System.out.println("12. 프로그램 종료");
			System.out.print("메뉴 번호 입력 : ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			
			switch(choice)
			{
			case 1: subVarMenu(); break;
			case 2: subPTypeMenu(); break;
			case 3: subIfMenu(); break;
			case 4: subSwitchMenu(); break;
			case 5: subForMenu(); break;
			case 6: subWhileMenu(); break;
			case 7: subDoWhileMenu(); break;
			case 8: subBreakMenu(); break;
			case 9: subContinueMenu(); break;
			case 10: subStaticMethodMenu(); break;
			case 11: subNonStaticMethodMenu(); break;
			case 12:
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			
			System.out.print("정말로 종료하시겠습니까? (예:y/아니오:n) : ");
			answer = CONSOLE.nextLine().charAt(0);
		}while(Character.toUpperCase(answer) != 'Y');
	}
	
	public static void subVarMenu(){
		int choice = 0;
		VariableSample vs = new VariableSample();
		do {
			System.out.println("*** 변수 테스트 부메뉴 ***");
			System.out.println("1. 내 신상정보 변수에 담아 출력하기");
			System.out.println("2. 사원정보를 키보드로 입력받아 출력하기");
			System.out.println("3. 기본 자료형 변수의 초기값 확인하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(choice) {
			case 1: vs.myProfile(); break;
			case 2: vs.empInformation(); break;
			case 3: vs.defaultValue(); break;
			case 4: System.out.println("메인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시 입력하세요.");
				break;
			}
		}while(choice != 4);
	}

	public static void subPTypeMenu(){
		int choice = 0;
		PrimitiveTypeSample pts = new PrimitiveTypeSample();
		do {
			System.out.println("*** 기본자료형 테스트 부메뉴 ***");
			System.out.println("1. 기본자료형 메모리 할당크기 확인하기");
			System.out.println("2. 기본자료형 값의 최소값, 최대값 출력하기");
			System.out.println("3. 기본자료형 비트갯수 확인하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(choice)
			{
			case 1:	pts.typeSize(); break;
			case 2:	pts.minMaxValue(); break;
			case 3:	pts.bitSize(); break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(choice != 4);
	}

	public static void subIfMenu(){
		int choice = 0;
		IfSample is = new IfSample();
		do {
			System.out.println("*** if문 테스트 부메뉴 ***");
			System.out.println("1. 두 개의 정수를 입력받아, 두 수중 큰 값 출력하기");
			System.out.println("2. 두 개의 정수를 입력받아, 두 수중 작은 값 출력하기");
			System.out.println("3. 세 개의 정수를 입력받아, 세 수중 가장 큰수와 가장 작은수 출력하기");
			System.out.println("4. 한 개의 정수를 입력받아, 짝수인지 홀수인지 출력하기");
			System.out.println("5. 국,영,수 세 과목의 점수를 입력받아, 합격/불합격 확인하기");
			System.out.println("6. 점수를 입력받아, 학점 확인하기");
			System.out.println("7. 한 개의 정수를 입력받아, 양수인지 0인지 음수인지 확인하기");
			System.out.println("8. 문자 하나를 입력받아, 영어대문자인지 소문자인지 숫자문자인지 "
					+ "기타문자인지 확인하기");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.println("메뉴 선택 : ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(choice)
			{
			case 1:	is.maxNumber(); break;
			case 2:	is.minNumber(); break;
			case 3:	is.threeMaxMin(); break;
			case 4:	is.checkEven(); break;
			case 5:	is.isPassFail(); break;
			case 6:	is.scoreGrade(); break;
			case 7:	is.checkPlusMinusZero(); break;
			case 8:	is.whatCaracter(); break;
			case 9:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(choice != 9);
	}

	public static void subSwitchMenu(){
		int choice = 0;
		SwitchSample ss = new SwitchSample();
		do {
			System.out.println("*** switch문 테스트 부메뉴 ***");
			System.out.println("1. 두 개의 정수와 한 개의 연산문자를 입력받아 계산한 결과 확인하기");
			System.out.println("2. 과일이름을 문자열로 입력받아, 그 과일의 가격 출력하기");
			System.out.println("3. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(choice)
			{
			case 1:	ss.calculator(); break;
			case 2:	ss.fruitPrice(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(choice != 3);
	}

	public static void subForMenu(){
		
	}

	public static void subWhileMenu(){}
	public static void subDoWhileMenu(){}
	public static void subBreakMenu(){}
	public static void subContinueMenu(){}
	public static void subStaticMethodMenu(){}
	public static void subNonStaticMethodMenu(){}
}
