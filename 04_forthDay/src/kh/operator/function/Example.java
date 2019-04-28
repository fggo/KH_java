package kh.operator.function;

import java.util.Scanner;

public class Example {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void opSample1() {
		int kor, eng, math;
		int total;
		double avg;
		
		System.out.print("국어 점수: ");
		kor = CONSOLE.nextInt();
		System.out.print("영어 점수: ");
		eng = CONSOLE.nextInt();
		System.out.print("수학 점수: ");
		math = CONSOLE.nextInt(); CONSOLE.nextLine();
	
		total = kor + eng + math;
		avg = total / 3.0;
		System.out.println("점수 합계: " + total);
		System.out.println("점수 평균 : " + avg);
		
		boolean passed = kor >= 40 && eng >= 40 && math >= 40 && avg >= 60;
		String resultMsg = passed? "합격을 축하합니다!": "불합격입니다. 다음에 도전하세요!";
		System.out.println(resultMsg);
	}
	
	public void opSample2() {
		String name;
		int year; // 1~6학년
		int classRoom; //반 (1~10)
		int number; //번호(1~30)
		char gender; //M/F
		double grade;

		System.out.print("학생이름: ");
		name = CONSOLE.nextLine();

		System.out.print("학년(1~6): ");
		year = CONSOLE.nextInt();

		System.out.print("반(1~10): ");
		classRoom = CONSOLE.nextInt();

		System.out.print("번호(1~30): ");
		number = CONSOLE.nextInt(); CONSOLE.nextLine();

		System.out.print("성별(M/F): ");
		gender = CONSOLE.nextLine().charAt(0);
		gender = gender == 'M'? '남': gender == 'F'? '여': '?';

		System.out.print("성적: ");
		grade = CONSOLE.nextDouble(); CONSOLE.nextLine();

		System.out.printf("%d학년 %d반 %d번 %c학생 %s은 성적이 %.2f이다.",
				year, classRoom, number, gender, name, grade);
	}
	
	public void opSample3() {
		System.out.print("정수 입력: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		
		String msg = num>0? "양수다": "양수가 아니다";
		System.out.println(msg);
	}
	
	public void opSample4() {
		System.out.print("정수 입력: ");
		int num = CONSOLE.nextInt(); CONSOLE.nextLine();
		
		String msg = num%2 == 0? "짝수다": "홀수다";
		System.out.println(msg);
	}
}
