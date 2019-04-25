package com.kh.day3.practice;

public class RunPractice2 {
	public static void main(String[] args) {
		String[] name = {"홍두깨", "고길동"};
		int[] age = {19, 21};
		char[] gender = {'남', '여'};
		String[] location = {"서울", "경기"};
		String[] tel = {"010-1111-1234", "010-9998-8877"};
		String[] email = {"uululu@aaa.com", "laruru@bbb.com"};

		System.out.printf("이름\t나이\t성별\t지역\t전화\t\t이메일\n");
		for(int i =0; i<2; i++) {
			System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",
					name[i], age[i], gender[i], 
					location[i], tel[i], email[i]);
		}
	}
}
