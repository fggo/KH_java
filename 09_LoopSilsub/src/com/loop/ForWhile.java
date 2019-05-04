package com.loop;

import com.loop.test.Main;

public class ForWhile {
	public void printStar1() {
		System.out.print("양의정수 입력: ");
		int num = Main.CONSOLE.nextInt();
		
		if(num > 0){
			String row = "";
			
			for(int i =1 ;i<=num; i++) {
				row = String.format("%"+i+"s", i).replace(' ', '*');
				System.out.println(row);
			}
		}
		else
			System.out.println("잘못입력하셨습니다... \n"
					+ "0보다 큰 정수를 입력하세요.");
	}
	
	public void printStar2() {
		System.out.print("정수 입력: ");
		int num = Main.CONSOLE.nextInt();
		String row = "";
		
		if(num > 0) {
			for(int i = 1 ;i<=num; i++) {
				row = String.format("%"+i+"s", ' ').replace(' ', '*');
				System.out.println(row);
			}
		}
		else if (num < 0){
			for(int i =num; i<=-1; i++) {
				row = String.format("%"+ (-i)+"s", ' ').replace(' ', '*');
				System.out.println(row);
			}
		}
		else { // num = 0
			System.out.println("출력 기능이 없습니다.");
		}
	}
	
	public void selectMenu() {
		int no = 0;
		int count = 0;
		int sum = 0;
		String bill = "";
		
		char answer = '\u0000';
		
		do{
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
			System.out.print("메뉴선택: ");
			
			no = Main.CONSOLE.nextInt();
			
			switch(no) {
			case 1:
				System.out.print("불고기버거를 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 3500*count;
				bill += "불고기버거 : " + count + "개 - " + 3500*count +"원";
				break;
			case 2:
				System.out.print("치킨버거를 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 3200*count;
				bill += "치킨버거 : " + count + "개 - " + 3200*count +"원";
				break;
			case 3:
				System.out.print("감자튀김을 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 1000*count;
				bill += "감자튀김 : " + count + "개 - " + 1000*count +"원";
				break;
			case 4:
				System.out.print("치즈스틱을 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 400*count;
				bill += "치즈스틱 : " + count + "개 - " + 400*count +"원";
				break;
			case 5:
				System.out.print("샐러드를 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 2000*count;
				bill += "샐러드 : " + count + "개 - " + 2000*count +"원";
				break;
			case 6:
				System.out.print("콜라를  선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 700*count;
				bill += "콜라 : " + count + "개 - " + 700*count +"원";
				break;
			case 7:
				System.out.print("에이드를 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 1200*count;
				bill += "에이드 : " + count + "개 - " + 1200*count +"원";
				break;
			case 8:
				System.out.print("커피를 선택하셨습니다.\n" + "수량은 ? ");
				count = Main.CONSOLE.nextInt();
				System.out.println(count+ "개 주문하셨습니다.");
				sum += 1000*count;
				bill += "커피 : " + count + "개 - " + 1000*count +"원";
				break;
			default:
				System.out.println("잘못된 메뉴번호 입니다...");
				break;
			}
			System.out.print("추가 주문하시겠습니까?(y/n) : ");
			answer = Character.toLowerCase(Main.CONSOLE.next().charAt(0));			
			bill = sum>0 && answer=='y' ? bill+"\n": bill;
			
		}while(answer == 'y');
		
		System.out.println("\n* 주문하신 정보는 다음과 같습니다. *");
		System.out.println("-----------------------------------------------");
		System.out.println(bill);
		System.out.println("-----------------------------------------------");
		System.out.println("총 가격 : " + sum + "원\n");
	}
	
	public void countInputCharacter(){
		if(Main.CONSOLE.hasNextLine())
			Main.CONSOLE.nextLine();
		
		System.out.print("문자열 입력 : ");
		String str = Main.CONSOLE.nextLine();
		
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(!Character.isLetter(c)) {
				System.out.println("영문자가 아닙니다.");
				return;
			}
		}
		
		System.out.print("문자 입력 : ");
		char ch = Main.CONSOLE.next().charAt(0);
		int count = 0;
		
		for(int i =0; i<str.length(); i++) {
			if(str.charAt(i) == ch)
				count++;
		}
		
		System.out.println("포함된 갯수 : " + count + " 개");
	}
}
