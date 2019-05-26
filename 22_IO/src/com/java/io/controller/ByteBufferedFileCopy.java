package com.java.io.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufferedFileCopy {
	public void byteBufferedFileCopy() throws IOException{
		InputStream in = new FileInputStream("org.bin");
		OutputStream out = new FileOutputStream("cpy.bin");
		
		BufferedInputStream bin = new BufferedInputStream(in);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		//default bufferSize =2MB
//		new BufferedInputStream(InputStream in, int bufferSize);
//		new BufferedOutputStream(OutputStream out, int bufferSize);

		int copyByte = 0;
		int bData= 0;
		
		while(true) {
			bData = bin.read();
			if(bData == -1)
				break;
			
			bout.write(bData);
			copyByte++;
		}
		
		bin.close();
		bout.close();
		System.out.println("복사된 바이트 크기: " + copyByte);
	}
}
