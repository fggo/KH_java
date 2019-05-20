package com.kh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Our example data
		List<List<String>> rows = Arrays.asList(  
		    Arrays.asList("Jean", "author", "Java"),
		    Arrays.asList("David", "editor", "Python"),
		    Arrays.asList("Scott", "editor", "Node.js")
		);

		try {
			//write
			FileWriter csvWriter = new FileWriter("new.csv");  
			csvWriter.append("Name");  
			csvWriter.append(",");  
			csvWriter.append("Role");  
			csvWriter.append(",");  
			csvWriter.append("Topic");  
			csvWriter.append("\n");

			for (List<String> rowData : rows) {  
				csvWriter.append(String.join(",", rowData));
				csvWriter.append("\n");
			}

			csvWriter.flush();  
			csvWriter.close();  

			//read
			String pathToCsv = "C:\\Users\\user1\\KH\\KH_java\\csvtest\\new.csv";
			File csvFile = new File(pathToCsv);
			String row = "";
			if (csvFile.isFile()) { 
			    // create BufferedReader and read data from csv
				BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));  
				while ((row = csvReader.readLine()) != null) {  
					String[] data = row.split(",");
					// do something with the data
					for(int i =0; i<data.length; i++) {
						System.out.println(data[i]);
					}
				}
				csvReader.close();  
			}
		}
		catch(IOException e ) {
			e.printStackTrace();
		}
	}
}
