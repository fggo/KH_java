package com.datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.inoutstream.model.vo.Person;

public class DataStream {
	private Person[] pers = new Person[3];

	public void dataInput() {
		DataInputStream di = null;
		try {
			for(Person p1 : pers) {
				di = new DataInputStream(new FileInputStream("dataTest.txt"));
				//입력 순서와 출력 순서 같아야함. 다르면 EOFException
				String name = di.readUTF();
				int age = di.readInt();
				double height = di.readDouble();
//				p1.setName(di.readUTF());
//				p1.setAge(di.readInt());
//				p1.setHeight(di.readDouble());
				System.out.println(p1.getName() + p1.getAge() + p1.getHeight());
			}
		}
		catch(EOFException e) {
			System.out.println("EOFException 파일 읽기 완료");
		}
		catch(IOException e ) {
			e.printStackTrace();
		}
		finally {
			try {
				di.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dataOutput() {
		pers[0] = new Person("바바", 2, 30); //자료형 유지하여 저장
		pers[1] = new Person("손흥민", 27, 180);
		pers[2] = new Person("메시", 99, 198);
		//DataOutputStream(보조스트림)
		DataOutputStream dos = null;
		try{
			dos = new DataOutputStream(new FileOutputStream("dataTest.txt"));
			//Person 배열이 전부 초기화됐는지 확인 못함
			for(Person p : pers) {
				dos.writeUTF(p.getName());
				dos.writeInt(p.getAge());
				dos.writeDouble(p.getHeight());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				dos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
