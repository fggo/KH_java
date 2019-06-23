package ncs.test12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropTest {
	public static void fileSave(Properties p) {
		try(OutputStream os = new FileOutputStream("data.xml");){

	    	p.storeToXML(os, "Fruit List");

		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void fileOpen(Properties p) {
		try(InputStream is = new FileInputStream("data.xml");) {

			p.loadFromXML(is);

			Fruit[] fruits = new Fruit[p.size()];
			for(int i =1 ;i<=p.size(); i++) {
				String[] params = p.getProperty(String.valueOf(i)).split(",");
				fruits[i-1] = new Fruit(params[0], Integer.valueOf(params[1]), Integer.valueOf(params[2]));
				System.out.println(i+"="+params[0]+", " + params[1]+ "¿ø, " + params[2]+"°³");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Fruit apple = new Fruit("apple", 1200, 3);
		Fruit banana = new Fruit("banana", 2500, 2);
		Fruit grape = new Fruit("grape", 4500, 5);
		Fruit orange = new Fruit("orange", 800, 10);
		Fruit melon = new Fruit("melon", 5000, 2);

		Properties prop = new Properties();
		prop.setProperty("1", apple.toString());
		prop.setProperty("2", banana.toString());
		prop.setProperty("3", grape.toString());
		prop.setProperty("4", orange.toString());
		prop.setProperty("5", melon.toString());

		fileSave(prop);
		fileOpen(prop);
	}
}
