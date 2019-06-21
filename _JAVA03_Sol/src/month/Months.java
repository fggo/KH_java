package month;

import java.util.Calendar;

public class Months {
	public int getDays(int months) {
		Calendar cal = Calendar.getInstance();
		cal.set(2019, months-1, 1);
		int res = cal.getActualMaximum(Calendar.DATE);
		return res;

	}
}
