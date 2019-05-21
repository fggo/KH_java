package com.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class StringController {
	public void stringController() {
		String name1 = "ABC";
		String name2 = "아아아";
		String name3 = "가가가";
		String name4 = "dsds";
		
		ArrayList<String> list = new ArrayList();
		list.add(name1);
		list.add(name2);
		list.add(name3);
		list.add(name4);
		Collections.sort(list, (i,j)->i.compareTo(j));
		System.out.println(list);
		
		System.out.println(name1.concat(name2));
		System.out.println(name1);

		if(name1.contains("AB"))
			System.out.println("AB를 포함합니다.");
		
		String str = "가가,나나,바바,아아";
		String[] chs = str.split(",");
		for(String s : chs) {
			System.out.println(s);
		}
		System.out.println(str.substring(3));
		System.out.println(str.substring(3, 6));
		
		
		//String(변경시 주소값 변경) 문자 수정 불가

		//StrinBuffer(주소값 그대로) 문자 수정 가능
		String msg = "가나다";
		StringBuffer msg2 = new StringBuffer("루룰룽");

		System.out.println(msg + " : " + msg.hashCode());
		System.out.println(msg2 + " : " + msg2.hashCode());
		
		msg += "하하";
		msg2.append("22가가");
		System.out.println(msg + " : " + msg.hashCode());
		System.out.println(msg2 + " : " + msg2.hashCode());
		
		msg2.delete(0, 2);
		System.out.print(msg2);
		
		System.out.println(msg + " : " + msg.hashCode());
		System.out.println(msg2 + " : " + msg2.hashCode());
		
		msg2.insert(3, "hehehe");
		System.out.println(msg + " : " + msg.hashCode());
		System.out.println(msg2 + " : " + msg2.hashCode());
		
		
		//StringBuilder 문자 수정 가능
		StringBuilder builder = new StringBuilder();
		
		//StringTokenizer
		String language = "Java,C,C++,Javascript,HTML";
		StringTokenizer stn = new StringTokenizer(language, ",");

		while(stn.hasMoreTokens()) {
			String s = stn.nextToken();
			System.out.println(s);
		}
		
		//wrapper
		Integer num = 10; //auto boxing
		Integer num2 = new Integer(20);
		
		int su = num;
		System.out.println(su);
		String strSu = "19";
		int su2 = Integer.parseInt(strSu);
		System.out.println(su2);
		
		System.out.println(num.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		double height = 180.5;
		Double ki = height;
		height = ki;
		String height2 = "3.1415";
		double num3 = Double.parseDouble(height2);
		System.out.println(num3);
		
		//valueof (convert primitive type)
		
	}
	
	public void dateTest() {
		Date today = new Date(); //new Date(0); 1970.1.1
//		today = new Date(987654322221L);  //new Date(milis);
		System.out.println(today);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		//birth day 2001-5-22
		Calendar birthday = Calendar.getInstance();
		birthday.set(Calendar.YEAR, 2001);
		birthday.set(Calendar.MONTH, 5-1);
		birthday.set(Calendar.DATE, 22);
		
		GregorianCalendar birth = new GregorianCalendar(2001, 5-1, 22);
		System.out.println(birth.get(Calendar.YEAR));
		System.out.println(birth.get(Calendar.MONTH) + 1);
		System.out.println(birth.get(Calendar.DATE));
//		System.out.println(birth.get(Calendar.AM_PM));

		Date temp = new Date(birthday.getTimeInMillis());
		System.out.println(temp);
	}
}
