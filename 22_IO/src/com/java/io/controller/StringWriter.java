package com.java.io.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
	public void stringWriter() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
		out.write("가나라다라마");
		out.newLine();
		out.write("글자놀이");
		out.newLine();
		out.write("ABCDEFG 알파벳 놀이");
		out.close();
		
		System.out.println("글자놀이 입력 완료.");
	}
}
