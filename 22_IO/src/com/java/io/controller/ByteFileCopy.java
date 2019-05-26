package com.java.io.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {
	public void byteFileCopy() throws IOException, FileNotFoundException{
		InputStream in = new FileInputStream("org.bin");
		OutputStream out = new FileOutputStream("cpy.bin");
		
		int copyByte = 0;
		int bData = 0;
		
		while(true) {
			//read 1 byte
			bData = in.read();
			if(bData == -1)
				break;
			out.write(bData);
			copyByte++;
		}
		
		in.close();
		out.close();
		System.out.println("복사된 바이트 크기: " + copyByte);
	}
}
