package com.filetest;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		//파일을 생성하려면 먼저 파일 객체 생성
		File file = new File("d:\\test1\\test\\first.txt");
		File dir = new File("d:\\test1\\test\\");
		//Ram에 파일 객체만 생성됨
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		try {
			//경로에 이미 파일 있으면 false
			//새로 만달수 있으면 true
			dir.mkdirs();

			System.out.println(file.createNewFile()); //하드에 파일이 생성
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			if(file.exists()) {
				file.delete(); //파일 삭제
			}
		}
	}
}
