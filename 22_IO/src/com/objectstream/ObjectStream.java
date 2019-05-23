package com.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.inoutstream.model.vo.Person;

public class ObjectStream {
	private Person[] pers = new Person[6];

	public void objInput() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("obj.txt"));

//			for(int i =0 ;i<pers.length; i++)
//				pers[i] = (Person)ois.readObject();
			pers = (Person[]) ois.readObject();

			for(Person p : pers)
				System.out.println(p);

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void objOutput() {
		pers[0] = new Person("바바", 2, 30.11);
		pers[1] = new Person("홍길동", 19, 178);
		pers[2] = new Person("이순신", 40, 180);
		pers[3] = new Person("aaa바바", 2222, 3110.11);
//		pers[4] = new Person("aaa홍길동", 19999, 11178);
//		pers[5] = new Person("aaa이순신", 40, 188880);

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
//			for(Person p : pers) {
//				oos.writeObject(p);
//			}
			oos.writeObject(pers);
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
