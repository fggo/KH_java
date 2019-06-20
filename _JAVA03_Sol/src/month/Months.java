package month;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Months {
	public int getDays(int months) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 31);

		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("월을 입력하세요 (1~12): ");
			int month = sc.nextInt();
			if(month <1 || month >12) {
				System.out.println("월을 다시 입력해주세요.");
				continue;
			}
			System.out.println("입력받은 월: " + month + "월");
			System.out.println("마지막 일자: " + 31 + "일");
		} while(true);
	}
}
