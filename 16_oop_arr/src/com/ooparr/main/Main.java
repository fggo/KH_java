package com.ooparr.main;

import java.util.Scanner;

import com.ooparr.controller.OopArrController;
import com.ooparr.model.vo.Student;

public class Main {
	public final static Scanner CONSOLE = new Scanner(System.in);

	public static void main(String[] args) {
		OopArrController oac = new OopArrController();
		oac.basicPersonTest();
	}
}
