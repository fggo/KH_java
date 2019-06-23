package ncs.test3;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Type Date info... ");
		System.out.print("year: ");
		int year = sc.nextInt();
		System.out.print("month: ");
		int month = sc.nextInt();
		System.out.print("day: ");
		int dayOfMonth = sc.nextInt();

		System.out.println("Typed Date info: ");
		Calendar cal = new GregorianCalendar(year, month-1, dayOfMonth);
		Format formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		System.out.println(formatter.format(cal.getTime()) + " "
				+ new SimpleDateFormat("EEEE", Locale.KOREA).format(cal.getTime()));
		if(year %4 ==0) {
			if((year %100!=0) || (year%100==0 && year %400 ==0))
				System.out.println(year + " is a Leap year.");
			else 
				System.out.println(year + " is NOT a Leap year.");
		}
	}
}
