package ncs.test5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PhoneMapTest {
	public static void main(String[] args) {
		Map<String, Phone> map = new HashMap<String, Phone>();
		Phone s7 = new Phone("galaxy S7", 563500, "Samsung", 7);
		Phone i6s = new Phone("iphone 6s", 840000, "Apple", 3);
		Phone g5 = new Phone("G5", 563500, "LG", 5);

		map.put(s7.getManufacture(), s7);
		map.put(i6s.getManufacture(), i6s);
		map.put(g5.getManufacture(), g5);
		
		Properties prop = new Properties();
		System.out.println("Map Phone data is ...");
		for(Map.Entry<String, Phone> entry : map.entrySet()) {
			System.out.println(entry.getValue());

			prop.setProperty(entry.getKey(), entry.getValue().toString());
		}


		try(FileOutputStream fos = new FileOutputStream(new File("phone.xml"));){
			prop.storeToXML(fos, "Phone List");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Successfully Saved to \"phone.xml\"!");
		}
	}
}
