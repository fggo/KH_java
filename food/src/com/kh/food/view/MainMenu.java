package com.kh.food.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.food.controller.UserController;
import com.kh.food.main.Main;
import com.kh.food.model.vo.MenuChoiceException;
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

	public static void showMainMenu() {
		System.out.println("=== 홈페이지 ===");
		System.out.println("1. 회원 가입");
		System.out.println("2. 로그인");
		System.out.println("3. 로그오프");
		System.out.println("4. 주문 하기");
		System.out.println("5. 주문 조회");
		System.out.println("6. 손님현황 조회");
		System.out.println("0. 프로그램 종료.");
		System.out.print("메뉴 입력: ");
	}

	public static void mainMenu() {
		int choice = -1;
		do {
			try {
				MainMenu.showMainMenu();
				choice = CONSOLE.nextInt(); CONSOLE.nextLine();
				if(choice <INIT_MENU.EXIT || choice > INIT_MENU.SHOW_USERS)
					throw new MenuChoiceException(choice);

				switch(choice) {
					case INIT_MENU.SIGNUP: controller.signUp(); break;
					case INIT_MENU.SIGNIN: controller.signIn(); break;
					case INIT_MENU.LOGOFF: controller.logOff(); break;
					case INIT_MENU.ORDER: controller.order(); break;
					case INIT_MENU.VIEW_ORDER: controller.viewOrder(); break;
					case INIT_MENU.SHOW_USERS: controller.showUsers(); seatView(); break;
					case INIT_MENU.EXIT:
						controller.logOff();
						controller.storeToFile();
						System.out.println("프로그램을 종료합니다.");
						return;
				}
			} catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴선택을 다시 합니다.\n");
			}
		} while(choice != 0);
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
				new HashMap<String, Integer>(), null, -1);
		return user;
	}

	public static String signInView() {
		System.out.println("=== 회원 로그인 ===");
		System.out.print("핸드폰번호 : ");
		String phone = CONSOLE.nextLine();

		return phone;
	}

	public static void showFoodMenu() {
		System.out.println("=== 음식 메뉴 ===");
		System.out.println("  1. 햄버거 --- 2,000");
		System.out.println("  2. 치킨 --- 9,000");
		System.out.println("=== 음료 메뉴 ===");
		System.out.println("  3. 콜라 --- 1,000");
		System.out.println("  4. 우유 --- 500");
		System.out.println("  0. 주문 종료");
		System.out.print(" 번호입력: ");
	}

	public static Map<String,Integer> orderView(){
		Map<String, Integer> orderList =new HashMap<String,Integer>();
		int total = 0;
		int choice = -1;
		int qty = 0;
		do {
			try {
				MainMenu.showFoodMenu();
				choice = CONSOLE.nextInt(); CONSOLE.nextLine();
				if(choice < FOOD_MENU.EXIT || choice > FOOD_MENU.MILK)
					throw new MenuChoiceException(choice);
				switch(choice) {
					case FOOD_MENU.BURGER:
						System.out.print("수량: ");
						qty = CONSOLE.nextInt(); CONSOLE.nextLine();
						if(qty <0) throw new MenuChoiceException(qty);
						orderList.put(FOOD.BURGER, qty);
						total += FOOD_PRICE.get(FOOD.BURGER) * qty;
						break;
					case FOOD_MENU.CHICKEN:
						System.out.print("수량: ");
						qty = CONSOLE.nextInt(); CONSOLE.nextLine();
						if(qty <0) throw new MenuChoiceException(qty);
						orderList.put(FOOD.CHICKEN, qty);
						total += FOOD_PRICE.get(FOOD.CHICKEN) * qty;
						break;
					case FOOD_MENU.COKE:
						System.out.print("수량: ");
						qty = CONSOLE.nextInt(); CONSOLE.nextLine();
						if(qty <0) throw new MenuChoiceException(qty);
						orderList.put(FOOD.COKE, qty);
						total += FOOD_PRICE.get(FOOD.COKE) * qty;
						break;
					case FOOD_MENU.MILK:
						System.out.print("수량: ");
						qty = CONSOLE.nextInt(); CONSOLE.nextLine();
						if(qty <0) throw new MenuChoiceException(qty);
						orderList.put(FOOD.MILK, qty);
						total += FOOD_PRICE.get(FOOD.MILK) * qty;
						break;
					case FOOD_MENU.EXIT:
						System.out.println("주문을 완료하였습니다.");
						return orderList;
				}
			} catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴선택을 다시합니다.\n");
			}
		}while(choice!= 0);
		
		return new HashMap<String,Integer>();
	}
	
	public static void seatView() {
		System.out.println("테이블 현황(X: 빈좌석)");
		boolean[] reservations = controller.getReservations();
		
		for(int i=0;i<reservations.length; i++) {
			if(i==reservations.length/2)
				System.out.println();
			System.out.print((reservations[i]==true ? 'O':'X') + " ");
		}
		System.out.println();
	}

	public static int reserveSeatView() {
		MainMenu.seatView();
		boolean[] reservations = controller.getReservations();
		Set<Integer> seatNos = new HashSet<Integer>();
		
		for(int i=0;i<reservations.length; i++)
			if(reservations[i]==false) seatNos.add(i+1);

		char answer = '\u0000';
		int seatNo = -1;
		do {
			System.out.print("식사하고 가시겠습니까? (Y/N): ");
			answer = Character.toUpperCase(CONSOLE.nextLine().charAt(0));
			if(answer =='Y') {
				try {
					System.out.print("좌석 번호 선택 (");
					Iterator<Integer> itr = seatNos.iterator();
					while(itr.hasNext())
						System.out.print(itr.next() + " ");
					System.out.print("중 택1) : ");
					seatNo = CONSOLE.nextInt(); CONSOLE.nextLine();
					if(!seatNos.contains(seatNo) || seatNo <0 || seatNo >= reservations.length)
						throw new MenuChoiceException(seatNo);

					controller.getReservations()[seatNo-1] = true;

				} catch(MenuChoiceException e) {
					e.showWrongChoice();
					System.out.println(seatNo + "번 자리는 예약할 수 없습니다.");
				}
			}
			else if(answer =='N') {
				System.out.println("음식 포장을 선택하셨습니다.");
			}
			else {
				System.out.println("Y/N으로 다시 입력해주세요.");
			}
		} while(answer!='Y' && answer!='N');

		return seatNo;
	}
	
	//getter setter
	public Integer[] getFoodCount() {
		Integer[] arr = FOOD_PRICE.values().toArray(new Integer[0]);
		return arr;
	}
}
