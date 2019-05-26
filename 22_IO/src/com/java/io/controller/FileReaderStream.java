package com.java.io.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderStream {
	public void fileReaderStream() throws IOException {
		char[] cbuf = new char[10];
		int readCnt;
		
		Reader in = new FileReader("hyper.txt");
		readCnt = in.read(cbuf, 0, cbuf.length);
		
		for(int i =0; i<readCnt; i++)
			System.out.println(cbuf[i]);
		
		in.close();
	}
}
