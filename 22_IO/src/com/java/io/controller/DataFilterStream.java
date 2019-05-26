package com.java.io.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataFilterStream {
	public void dataFilterStream() throws IOException{
		//read write with specified size(int/double)
		OutputStream out = new FileOutputStream("data.bin");
		DataOutputStream filterOut = new DataOutputStream(out);
		filterOut.writeInt(275);
		filterOut.writeDouble(45.79);
		filterOut.close();
		
		InputStream in = new FileInputStream("data.bin");
		DataInputStream filterIn = new DataInputStream(in);
		int num1 = filterIn.readInt();
		double num2 = filterIn.readDouble();
		filterIn.close();
		
		System.out.println(num1);
		System.out.println(num2);
	}
}
