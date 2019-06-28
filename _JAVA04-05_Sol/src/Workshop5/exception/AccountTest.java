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
		System.out.printf("INTEREST: %.1f\n", acc.calculateInterest());
	}
}
