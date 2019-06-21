package month;

import java.util.Scanner;

public class MonthsTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("월을 입력하세요 (1~12): ");
			int month = sc.nextInt();

			if(month <1 || month >12) {
				System.out.println("월을 다시 입력해주세요.");
				continue;
			}
			System.out.println("입력받은 월: " + month + "월");
			int lastDay = new Months().getDays(month);
			System.out.println("마지막일자: " + lastDay +"일");
			break;
		} while(true);
	}
}
