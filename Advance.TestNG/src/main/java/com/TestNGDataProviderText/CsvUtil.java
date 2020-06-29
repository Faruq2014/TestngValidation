package com.TestNGDataProviderText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvUtil {
public static void main(String[] args) {
	callCSV();
	//String[][] str = new String[2][2];
	
	
}
	
	public static Object[] callCSV() {
		String path="./excel/data.csv.txt";
		String line="";
		String[]  data = null;
		int row;
		try {
			BufferedReader bReader=new BufferedReader(new FileReader(path));
			
			while ((line=bReader.readLine()) !=null) {
			System.out.println(line);
			   data = line.split(",");

		 row=data.length;
		// System.out.println(row);
		 String[][] str = new String[row][row]; 
		  str[0][0]=data[0].toString();
		  str[0][1]=data[1].toString();
		  System.out.println(str+" :it is 2d");
			}
			
			System.out.println(data[1]);
			//return data;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return data;
		
	}
	
}
