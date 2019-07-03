package com.kh.day3.practice;

//�ǽ�����2
public class RunPractice2 {
	public static void main(String[] args) {
		String[] name = {"ȫ�α�", "��浿"};
		int[] age = {19, 21};
		char[] gender = {'F', 'M'};
		String[] location = {"����", "���"};
		String[] tel = {"010-1111-1234", "010-9998-8877"};
		String[] email = {"uululu@aaa.com", "laruru@bbb.com"};

		System.out.printf("�̸�\t����\t����\t����\t��ȭ\t\t�̸���\n");
		for(int i =0; i<2; i++) {
			System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",
					name[i], age[i], gender[i], 
					location[i], tel[i], email[i]);
		}
	}
}
