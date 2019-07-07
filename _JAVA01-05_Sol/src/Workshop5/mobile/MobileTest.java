package Workshop5.mobile;

public class MobileTest {
	public static void main(String[] args) {
		Mobile ltab = new Ltab("Ltab", 500, "AP-01");
		Mobile otab = new Otab("Otab", 1000, "AND-20");

		System.out.println("Mobile\tBattery\tOS");
		System.out.println("-------------------------------");
		ltab.showInfo(); otab.showInfo();
		System.out.println("\n10MIN CHARGE");
		ltab.charge(10); otab.charge(10);
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("-------------------------------");
		ltab.showInfo(); otab.showInfo();
		System.out.println("\n5MIN CALL");
		ltab.operate(5); otab.operate(5);
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("-------------------------------");
		ltab.showInfo(); otab.showInfo();
	}
}
