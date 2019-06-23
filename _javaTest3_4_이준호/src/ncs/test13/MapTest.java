package ncs.test13;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {

		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 2016);
		cal1.set(Calendar.MONTH, Calendar.MARCH);
		cal1.set(Calendar.DAY_OF_MONTH, 15);
		Inventory s7 = new Inventory("Samsung Galaxy S7", cal1.getTime(), null, 30, 0, 30);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2016);
		cal2.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal2.set(Calendar.DAY_OF_MONTH, 25);
		Inventory g5 = new Inventory("LG G5", cal2.getTime(), null, 20, 0, 20);

		Calendar cal3 = Calendar.getInstance();
		cal3.set(Calendar.YEAR, 2016);
		cal3.set(Calendar.MONTH, Calendar.JANUARY);
		cal3.set(Calendar.DAY_OF_MONTH, 23);
		Inventory ipadPro = new Inventory("Apple IPad Pro", cal3.getTime(), null, 15, 0, 15);

		Map<String, Inventory> map = new HashMap<String, Inventory>();
		map.put(s7.getProductName(), s7);
		map.put(g5.getProductName(), g5);
		map.put(ipadPro.getProductName(), ipadPro);

		Inventory[] inventories = new Inventory[map.size()];
		int count = 0;

		for(Map.Entry<String, Inventory> entry : map.entrySet()) {
			System.out.println(entry.getValue());
			inventories[count++] = entry.getValue();
		}

		try {
			System.out.println("\n1st stock out: 10 units-----------------------------");
			for(int i =0; i<inventories.length; i++) {
				inventories[i].setGetAmount(10);
				System.out.println(inventories[i]);
			}

			System.out.println("\n2nd stock out: 10 units-----------------------------");
			for(int i =0; i<inventories.length; i++) {
				inventories[i].setGetAmount(10);
				System.out.println(inventories[i]);
			}
		} catch(AmountNotEnough e) {
			e.showMessage();
		}
	}
}
