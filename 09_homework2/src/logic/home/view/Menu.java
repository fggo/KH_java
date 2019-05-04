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
		int no = 0;
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
			no = CONSOLE.nextInt();
			
			switch(no)
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
		int no = 0;
		VariableSample vs = new VariableSample();
		do {
			System.out.println("*** 변수 테스트 부메뉴 ***");
			System.out.println("1. 내 신상정보 변수에 담아 출력하기");
			System.out.println("2. 사원정보를 키보드로 입력받아 출력하기");
			System.out.println("3. 기본 자료형 변수의 초기값 확인하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			no = CONSOLE.nextInt();

			switch(no) {
			case 1: vs.myProfile(); break;
			case 2: vs.empInformation(); break;
			case 3: vs.defaultValue(); break;
			case 4: System.out.println("메인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시 입력하세요.");
				break;
			}
		}while(no != 4);
	}

	public static void subPTypeMenu(){
		int no = 0;
		PrimitiveTypeSample pts = new PrimitiveTypeSample();
		do {
			System.out.println("*** 기본자료형 테스트 부메뉴 ***");
			System.out.println("1. 기본자료형 메모리 할당크기 확인하기");
			System.out.println("2. 기본자료형 값의 최소값, 최대값 출력하기");
			System.out.println("3. 기본자료형 비트갯수 확인하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			no = CONSOLE.nextInt(); CONSOLE.nextLine();

			switch(no)
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
		}while(no != 4);
	}

	public static void subIfMenu(){
		int no = 0;
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
			no = CONSOLE.nextInt();

			switch(no)
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
		}while(no != 9);
	}

	public static void subSwitchMenu(){
		int no = 0;
		SwitchSample ss = new SwitchSample();
		do {
			System.out.println("*** switch문 테스트 부메뉴 ***");
			System.out.println("1. 두 개의 정수와 한 개의 연산문자를 입력받아 계산한 결과 확인하기");
			System.out.println("2. 과일이름을 문자열로 입력받아, 그 과일의 가격 출력하기");
			System.out.println("3. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			no = CONSOLE.nextInt();

			switch(no)
			{
			case 1:	ss.calculator(); break;
			case 2:	ss.fruitPrice(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(no != 3);
	}

	public static void subForMenu(){
		int no = 0;
		ForSample fs = new ForSample();
		
		do {
			System.out.println("for문 테스트 부메뉴 ***");
			System.out.println("1. 1~10까지 정수들의 합계 구하기");
			System.out.println("2. 1~100사이의 짝수들의 합게 구하기");
			System.out.println("3. 정수 하나 입력받아, 그 수의 구구단 출력하기");
			System.out.println("4. 두 개의 정수를 입력받아, 두 수중 작은 값에서 큰 값까지의 합계 구하기");
			System.out.println("5. 줄수와 칸수 입력받아, 입력된 줄수/칸수만큼 별표문자 출력하기");
			System.out.println("6. 7줄에 7칸에 별표문자 출력하되, 각 줄에 줄번호와 같은 칸에 숫자 출력하기");
			System.out.println("7. 줄수를 입력받아, 삼각형 모양으로 별표문자 출력하기(양수:직각삼각형, 음수:역삼각형)");
			System.out.println("8. 구구단 2단부터 9단까지 출력하기");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			no = CONSOLE.nextInt();
			
			switch(no)
			{
			case 1:	fs.sum1To10(); break;
			case 2:	fs.sumEven1To100(); break;
			case 3:	fs.oneGugudan(); break;
			case 4:	fs.sumMinToMax(); break;
			case 5:	fs.printStar(); break;
			case 6:	fs.printNumberStar(); break;
			case 7:	fs.printTriangleStar(); break;
			case 8:	fs.guguDan(); break;
			case 9:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		} while(no != 9);
	}

	public static void subWhileMenu(){
		int no = 0;
		WhileSample ws = new WhileSample();
		
		do {
			System.out.println("*** while문 테스트 부메뉴 ***");
			System.out.println("1. 문자 하나 입력받아, 그 문자의 유니코드 출력 반복('0' 입력되면 반복종료)");
			System.out.println("2. 1~100까지 정수들의 합계 출력하기(while 문으로 작성)");
			System.out.println("3. 1~100사이의 임의의 정수를 발생시켜, 숫자 알아맞추기");
			System.out.println("4. 문자열을 입력받아, 글자 갯수 알아내어 출력하기");
			System.out.println("5. 문자열값과 문자 하나를 입력받아, 문자열에 문자가 몇 개 있는지 확인하기");
			System.out.println("6. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			
			switch(no)
			{
			case 1:	ws.printUniCode(); break;
			case 2:	ws.sum1To100(); break;
			case 3:	ws.numberGame(); break;
			case 4:	ws.countCharacter(); break;
			case 5:	ws.countInChar(); break;
			case 6:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
			
		}while(no != 6);
	}
	
	public static void subDoWhileMenu(){
		int no = 0;
		DoWhileSample dws = new DoWhileSample();
		
		do {
			System.out.println("*** do~while문 테스트 부메뉴 ***");
			System.out.println("1. 문자열값 입력받아, 문자 사이에 '-' 끼워넣어 출력하기");
			System.out.println("2. 버거킹 메뉴 주문 테스트");
			System.out.println("3. 문자열 입력받아, \"모든 글자 영문자다\"/\"영문자 아니다.\" 출력하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
				
			switch(no)
			{
			case 1:	dws.addDashToken(); break;
			case 2:	dws.burgerKingMenu(); break;
			case 3:	dws.isStringAlphabet(); break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(no != 4);
	}
	
	public static void subBreakMenu(){
		int no = 0;
		BreakSample bs = new BreakSample();
		
		do {
			System.out.println("*** break문 테스트 부메뉴 ***");
			System.out.println("1. 1~100까지 정수들의 합계 출력하기(break문 사용)");
			System.out.println("2. 구구단 1단~9단까지 출력하되, * 5 계산에서 반복문 빠지기(break 이름 사용)");
			System.out.println("3. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : "); 
			switch(no)
			{
			case 1:	bs.sumBreak(); break;
			case 2:	bs.guguDanBreak(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		} while(no != 3);
	}
	
	public static void subContinueMenu(){
		int no = 0;
		ContinueSample cs = new ContinueSample();
		
		do {
			System.out.println("*** continue문 테스트 부메뉴 ***");
			System.out.println("1. 1~100까지의 정수 중 3의 배수를 뺀 정수들의 합계 출력하기");
			System.out.println("2. 3행 5열의 행열값 출력하되, 1행 3열부터 1행 5열까지 생략하고 출력하기");
			System.out.println("3. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : "); 
			switch(no)
			{
			case 1: cs.sumJumpThree(); break;
			case 2:	cs.rowColJump(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(no != 3);
	}
	
	public static void subStaticMethodMenu(){
		int no = 0;
		StaticMethodSample sms = new StaticMethodSample();
		
		do {
			System.out.println("*** static 메소드 사용 테스트 부메뉴 ***");
			System.out.println("1. Math 클래스의 랜덤값 구하는 메소드 : 1~45사이의 임의의 정수 출력");
			System.out.println("2. Math 클래스의 실수값에 대한 절대값 구하는 메소드 : -12.77 절대값 출력하기");
			System.out.println("3. Math 클래스의 두 정수중 큰값 구하는 메소드 : 120, 54 중 큰값 출력하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : "); 
				
			switch(no)
			{
			case 1:	sms.testMathRandom(); break;
			case 2:	sms.testMathAbs(); break;
			case 3:	sms.testMathMax(); break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(no != 4);
	}
	
	public static void subNonStaticMethodMenu(){
		int no = 0;
		NonStaticMethodSample nsms = new NonStaticMethodSample();
		
		do {
			System.out.println("*** non-static 메소드 사용 테스트 부메뉴 ***");
			System.out.println("1. Scanner 클래스 사용 : 자료형 종류별로 값 입력받아 출력하기");
			System.out.println("2. Date 클래스 사용 : 오늘 날짜, 현재 시간 정보 출력하기");
			System.out.println("3. Random 클래스 사용 : 정수와 실수에 대한 난수 출력하기");
			System.out.println("4. 이전 메뉴로 가기");
			System.out.println("메뉴 선택 :"); 
	
			switch(no)
			{
			case 1:	nsms.testScanner(); break;
			case 2:	nsms.testDate(); break;
			case 3:	nsms.testRandom(); break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:
				System.out.println("잘못된 메뉴번호 입니다. 다시입력하세요.");
				break;
			}
		}while(no != 4);
	}
}
