package com.io.main;

import com.objectstream.ObjectStream;

public class Main {
	public static void main(String[] args) {
//		FileInOutTest fio = new FileInOutTest();
//		fio.fileOutput();
//		fio.fileInput();
//		
//		ReaderWriterTest rw = new ReaderWriterTest();
//		rw.writerTest(rw.inputKeyboard());
//		rw.readerTest();
		
//		DataStream ds = new DataStream();
//		ds.dataOutput();
//		ds.dataInput();
		
		ObjectStream os = new ObjectStream();
		os.objOutput();
		os.objInput();
	}
}
