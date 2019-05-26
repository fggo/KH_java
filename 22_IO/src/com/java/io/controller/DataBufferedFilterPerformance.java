package com.java.io.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataBufferedFilterPerformance {
	public void performanceTest(DataOutputStream dataOut) throws IOException{
		long startTime = System.currentTimeMillis();
		for(int i =0; i<500; i++)
			for(int j=0; j<500; j++)
				dataOut.writeDouble(12.345);

		dataOut.flush();
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : " + (endTime - startTime));
	}
	
	public void dataBufferedFilterPerformance() throws IOException{
		OutputStream out1 = new FileOutputStream("data1.bin");
		DataOutputStream dataOut = new DataOutputStream(out1);
		performanceTest(dataOut);
		dataOut.close();
		
		OutputStream out2 = new FileOutputStream("data2.bin");
		BufferedOutputStream bufFilterOut = new BufferedOutputStream(out2, 1024*10);
		DataOutputStream dataBufOut = new DataOutputStream(bufFilterOut);
		performanceTest(dataBufOut);
		dataBufOut.close();
	}
}
