package ncs.test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NoticeTest {

	public void fileSave(List<Notice> array) {
		try(FileOutputStream fos = new FileOutputStream(new File("notice.dat"));
				ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
			oos.writeObject(array);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<Notice> fileRead(){
		try(FileInputStream fis = new FileInputStream(new File("notice.dat"));
				ObjectInputStream ois = new ObjectInputStream(fis); ) {

			ArrayList<Notice> array= (ArrayList<Notice>)ois.readObject();
			return array;
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		NoticeTest test = new NoticeTest();
		int no = 0;

		List<Notice> obArray = new ArrayList<Notice>();
		Scanner sc = new Scanner(System.in);
		for(int i =0; i<3; i++) {
			Notice notice = new Notice();
			System.out.println("Register a Notice...");
			
			notice.setNo(++no);
			Calendar cal = new GregorianCalendar(2016, 
					new Random().nextInt(12), new Random().nextInt(28)+1);
			notice.setDate(cal.getTime());

			System.out.print("Title: ");
			notice.setTitle(sc.nextLine());
			System.out.print("Author: ");
			notice.setWriter(sc.nextLine());
			System.out.print("Content: ");
			notice.setContent(sc.nextLine());

			obArray.add(notice);
		}

		test.fileSave(obArray);
		Object[] loadedArr = test.fileRead().toArray();

		System.out.println("Object info inside a Notice List...");
		for(int i =0; i<loadedArr.length; i++) {
			System.out.println(loadedArr[i]);
		}
	}
}
