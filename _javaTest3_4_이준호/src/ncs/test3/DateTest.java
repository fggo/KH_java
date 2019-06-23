package ncs.test3;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest {
	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar(1987, Calendar.MAY, 27);
		cal.setTime(cal.getTime());
		System.out.print("생일: " + 
				cal.get(Calendar.YEAR)+"년 " +
				cal.get(Calendar.MONTH)+"월 " + 
				cal.get(Calendar.DAY_OF_MONTH)+"일 ");
//				cal.get(Calendar.DAY_OF_WEEK));
		Format formatter = new SimpleDateFormat("EEEE"); 
		String date = formatter.format(cal.getTime());
		System.out.println(date);
		

		Calendar now = Calendar.getInstance();
		System.out.print("현재: " + 
				now.get(Calendar.YEAR)+"년 " +
				now.get(Calendar.MONTH)+"월 " + 
				now.get(Calendar.DAY_OF_MONTH)+"일 ");
		String dateNow = formatter.format(now.getTime());
		System.out.println(dateNow);


		int age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
		if(now.get(Calendar.MONTH) < cal.get(Calendar.MONTH))
			age = age -1;
		else if(now.get(Calendar.MONTH) == cal.get(Calendar.MONTH)) {
			if(now.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH))
				age = age -1;
		}

		System.out.println("만나이: " + age);
	}
}
