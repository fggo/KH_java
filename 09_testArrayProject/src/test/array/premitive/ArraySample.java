package test.array.premitive;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ArraySample {
	public static final Scanner CONSOLE = new Scanner(System.in);

	public void test1() {
		int[] intArr = new int[10];
		int sum = 0;
		
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (int)(Math.random()*100 + 1);
			sum += intArr[i];
		}
		System.out.println("1~100사이 난수  10개의 합: " + sum);
	}

	public void test2() {
		int[] intArr = new int[10];
		int max = 0, min = 0;
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (int)(Math.random()*100 + 1);
			if(i == 0) {
				max = intArr[i];
				min = intArr[i];
			}

			if (intArr[i] > max) max = intArr[i];
			if (intArr[i] < min) min = intArr[i];
		}
		System.out.print("최소 난수: "+ min + ", 최대 난수: " + max + "\n");
	}

	public void test3() {
		int[] intArr = new int[10];
		int sum = 0;
		
		for(int i =0; i<intArr.length; i++) {
			intArr[i] = (int)(Math.random()*100 + 1);
			if(intArr[i]%2 ==0)
				sum += intArr[i];
		}
		System.out.println("1~100사이 짝수난수들의 합: " + sum);
	}
	
	public void test4() {
		System.out.print("숫자로된 문자열 입력: ");
		String numStr = CONSOLE.nextLine();
		int sum = 0;
		
		for(int i =0; i<numStr.length(); i++) 
			sum += Integer.valueOf(numStr.substring(i, i+1));
			
		System.out.println("합계: " + sum);
	}
	
	public void test5() {
		System.out.print("숫자로된 문자열 입력: ");
		String numStr = CONSOLE.nextLine();
		int sum = 0;
		
		for(int i =0; i<numStr.length(); i++) {
//			sum += Integer.valueOf(numStr.substring(i, i+1));
			sum += numStr.charAt(i) - '0';
		}
		System.out.println("합계: " + sum);
	}
	
	public void test6() {
		String personID = "881225-1234567";
		//생년월일
		int birthYear = Integer.valueOf("19" + personID.substring(0, 2));
		int birthMonth = Integer.valueOf(personID.substring(2, 4));
		int birthDay = Integer.valueOf(personID.substring(4, 6));

		//요일
		Date dt1 = new Date();
		try {
			dt1 = new SimpleDateFormat("yyMMdd")
					.parse(personID.substring(0, 6));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dayOfWeek = new SimpleDateFormat("EEEE").format(dt1);

		//성별
		char gender = personID.substring(7, 8).equals("1")? '남':'여';

		//나이
		int age = Calendar.getInstance().get(Calendar.YEAR) - birthYear + 1;
		
		System.out.println("===== 생일 정보 =====");
		System.out.println("연도: " + birthYear);
		System.out.println("월: " + birthMonth);
		System.out.println("일: " + birthDay);
		System.out.println("요일: " + dayOfWeek);
		System.out.println("성별: " + gender + "자");
		System.out.println("나이: " + age);
	}
}
