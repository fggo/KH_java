package com.ooparr.main;

import java.util.Scanner;

import com.ooparr.controller.OopArrController;
import com.ooparr.model.vo.Student;

public class Main {
	public final static Scanner CONSOLE = new Scanner(System.in);

	public static void main(String[] args) {
		//ex1
		OopArrController oac = new OopArrController();
		oac.basicPersonTest();
		
		//ex2
		Student[] students = new Student[3];

		//toString() overload
		for(int i =0; i<students.length; i++) {
			students[i]= new Student();
			System.out.println(students[i]);
		}

	}
}
