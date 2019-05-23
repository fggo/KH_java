package com.inoutstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutTest {
	public void fileOutput() {
		//1. 파일 저장할때는먼저 저장대상 파일 생성
		//2. 파일과 연결되는 스트림 생성!
		//3. 스트림이 생성되면 램에 있는 데이터를 전송
		//각 내용마다 해당되는 Exception처리를 해줘야함.
		//생성된 스트림은 반드시 닫아줘야함(close)
		File file = new File("test.txt");
		FileOutputStream fos = null;
		try/*(FileOutputStream fos = new FileOutputStream(file);)*/{
			//혹은 try~catch문 밖에 declare
			fos = new FileOutputStream(file);

			String data1 = "바바는 개입니다.";
//			byte[] data2 = {10, 20, 30, 40, 50};
			fos.write(data1.getBytes());
//			fos.write(data2);

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void fileInput() {
		//1. file을  File객체에 연결
		//2. 스트림을 연결
		//3. read로 불러옴
		//	byte단위 통신으로 불러오는 값이 int임
		// 	데이터를 다 받을때 까지 반복문을 활용
		// Exception 처리, 스트림을 close()
		File file = new File("test.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			//파일 읽어오기 (int로 불러옴)
			int value = 0;
			
			while((value=fis.read()) != -1) {
				System.out.print((char)value);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}
}
	
