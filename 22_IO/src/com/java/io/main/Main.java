package com.java.io.main;

import java.io.IOException;

import com.java.io.controller.BufferFileCopy;
import com.java.io.controller.ByteBufferedFileCopy;
import com.java.io.controller.ByteFileCopy;
import com.java.io.controller.DataBufferFilterStream;
import com.java.io.controller.DataBufferedFilterPerformance;
import com.java.io.controller.DataFilterStream;
import com.java.io.controller.FileReaderStream;
import com.java.io.controller.FileWriterStream;
import com.java.io.controller.StringReader;
import com.java.io.controller.StringWriter;

public class Main {
	public static void main(String[] args) {
		try {
			new ByteFileCopy().byteFileCopy();
			new BufferFileCopy().bufferFileCopy();
			new DataFilterStream().dataFilterStream();

			new ByteBufferedFileCopy().byteBufferedFileCopy();

			new DataBufferFilterStream().dataBufferFilterStream();

			new DataBufferedFilterPerformance().dataBufferedFilterPerformance();

			new FileWriterStream().fileWriterStream();
			new FileReaderStream().fileReaderStream();
			
			new StringWriter().stringWriter();
			new StringReader().stringReader();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
