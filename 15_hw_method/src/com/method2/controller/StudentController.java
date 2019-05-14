package com.method2.controller;

import com.method2.model.vo.Student;

public class StudentController {
	public void insertStudent( String name, int year,
			double kor, double eng, double math) {
		Student s = new Student();

		s.setName(name);
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
		double sum = kor + eng + math;
		double avg = sum/3.0;
		s.setSum(sum);
		s.setAvg(avg);
		
		System.out.println(name+ year+ kor+ math+ eng+ sum + avg);
	}
}
