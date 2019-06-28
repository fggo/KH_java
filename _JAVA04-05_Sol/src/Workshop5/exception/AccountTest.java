package Workshop5.exception;

public class AccountTest {
	public static void main(String[] args) {
		Account acc = new Account("441-0290-1203", 500000.0, 7.3);
		acc.showAccountInfo();
		try {
			acc.deposit(-10);
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			acc.withdraw(600000);
		} catch(Exception e) {
			e.printStackTrace();
		}
//		입금 금액이 0보다 적습니다.
//		금액이 0보다 적거나 현재 잔액보다 많습니다.
//		이자: 36500.0
		System.out.printf("INTEREST: %.1f\n", acc.calculateInterest());
	}
}
