package com.java.io.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterStream {
	public void fileWriterStream() throws IOException {
		char ch1 = 'A';
		char ch2 = 'B';
		
		Writer out = new FileWriter("hyper.txt");
		out.write(ch1);
		out.write(ch2);
		out.close();
	}
}
