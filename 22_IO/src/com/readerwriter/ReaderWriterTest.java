package com.readerwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderWriterTest {
	public void readerTest() {

		FileReader fr = null;
		try {
			fr = new FileReader("test1.txt");
			int value = 0;
			while((value=fr.read()) != -1) {
				System.out.print((char)value);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writerTest(String msg) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test1.txt");
			fw.write(msg);
//			fw.write("바바는 개입니다.");
//			fw.write('여');
//			fw.write(new char[] {'A','B','C', '\n', 'D'});
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String inputKeyboard() {
		BufferedReader br = null;
		String value = "";
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("문장입력: ");
			value = br.readLine();
			System.out.println(value);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
}
