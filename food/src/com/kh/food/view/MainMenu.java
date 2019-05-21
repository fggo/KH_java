package com.kh.food.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kh.food.controller.UserController;
import com.kh.food.main.Main;
import com.kh.food.model.vo.User;

interface INIT_MENU {
	int SIGNUP=1, SIGNIN=2, LOGOFF=3, ORDER=4, VIEW_ORDER=5, SHOW_USERS=6, EXIT=0;
}

interface LOGGED{
	boolean OFF=false, ON=true;
}

interface FOOD{
	String BURGER="BURGER", CHICKEN="CHICKEN", COKE="COKE", MILK="MILK";
}

interface FOOD_MENU{
	int BURGER=1, CHICKEN=2, COKE=3, MILK=4, EXIT=0;
}

public class MainMenu {
	public final static Scanner CONSOLE = new Scanner(System.in);
	static UserController controller = Main.getController();
	
	private final static Map<String, Integer> FOOD_PRICE = 
			new HashMap<String, Integer>(){
		{
			put(FOOD.BURGER, 2000);
			put(FOOD.CHICKEN, 9000);
			put(FOOD.COKE, 1000);
			put(FOOD.MILK, 500);
		};
	};

	public static void mainMenu() {
		int choice = -1;
		do {
			System.out.println("=== 홈페이지 ===");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 로그오프");
			System.out.println("4. 주문 하기");
			System.out.println("5. 주문 조회");
			System.out.println("6. 손님현황 조회");
			System.out.println("0. 프로그램 종료.");
			System.out.print("메뉴 입력: ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case INIT_MENU.SIGNUP: controller.signUp(); break;
				case INIT_MENU.SIGNIN: controller.signIn(); break;
				case INIT_MENU.LOGOFF: controller.logOff(); break;
				case INIT_MENU.ORDER: controller.order(); break;
				case INIT_MENU.VIEW_ORDER: controller.viewOrder(); break;
				case INIT_MENU.SHOW_USERS: controller.showUsers(); break;
				case INIT_MENU.EXIT:
					controller.logOff();
					controller.storeToFile();
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}while(choice != 0);
	}
	
	public static User signUpView() {
		System.out.println("=== 회원 가입 ===");
		System.out.print("회원 이름 : ");
		String username = CONSOLE.nextLine();
		System.out.print("회원 전화 : ");
		String phone = CONSOLE.nextLine();
		System.out.print("회원 이메일 : " );
		String email = CONSOLE.nextLine();
		System.out.print("회원 주소 : ");
		String address = CONSOLE.nextLine();
		
		User user = new User(username, phone, email, address, LOGGED.OFF,
				new HashMap<String, Integer>());
		return user;
	}

	public static String signInView() {
		System.out.println("=== 회원 로그인 ===");
		System.out.print("핸드폰번호 : ");
		String phone = CONSOLE.nextLine();

		return phone;
	}

	public static Map<String,Integer> orderView(){
		Map<String, Integer> orderList =new HashMap<String,Integer>();
		int total = 0;
		int choice = -1;
		int qty = 0;
		do {
			System.out.println("=== 음식 메뉴 ===");
			System.out.println("  1. 햄버거 --- 2,000");
			System.out.println("  2. 치킨 --- 9,000");
			System.out.println("=== 음료 메뉴 ===");
			System.out.println("  3. 콜라 --- 1,000");
			System.out.println("  4. 우유 --- 500");
			System.out.println("  0. 주문 종료");
			System.out.print(" 번호입력: ");
			choice = CONSOLE.nextInt(); CONSOLE.nextLine();
			switch(choice) {
				case FOOD_MENU.BURGER:
					System.out.print("\t 수량: ");
					qty = CONSOLE.nextInt();
					orderList.put(FOOD.BURGER, qty);
					total += FOOD_PRICE.get(FOOD.BURGER) * qty;
					break;
				case FOOD_MENU.CHICKEN:
					total += FOOD_PRICE.get(FOOD.CHICKEN);
					System.out.print("\t 수량: ");
					qty = CONSOLE.nextInt();
					orderList.put(FOOD.CHICKEN, qty);
					total += FOOD_PRICE.get(FOOD.CHICKEN) * qty;
					break;
				case FOOD_MENU.COKE:
					total += FOOD_PRICE.get(FOOD.COKE);
					System.out.print("\t 수량: ");
					qty = CONSOLE.nextInt();
					orderList.put(FOOD.COKE, qty);
					total += FOOD_PRICE.get(FOOD.COKE) * qty;
					break;
				case FOOD_MENU.MILK:
					total += FOOD_PRICE.get(FOOD.MILK);
					System.out.print("\t 수량: ");
					qty = CONSOLE.nextInt();
					orderList.put(FOOD.MILK, qty);
					total += FOOD_PRICE.get(FOOD.MILK) * qty;
					break;
				case FOOD_MENU.EXIT:
					System.out.println("주문을 완료하였습니다.");
					return orderList;
			}
		}while(choice!= 0);
		
		return new HashMap<String,Integer>();
	}

	//getter setter
	public Integer[] getFoodCount() {
		Integer[] arr = FOOD_PRICE.values().toArray(new Integer[0]);
		return arr;
	}
}
