package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	
	public static Iterator<Object[]> readCSV() {
		
		File csvFile;
		FileReader fileReader = null;
		CSVReader csvReader ;
		List<Object[]> userList= null;
		String [] data;
		User userData;
		
		 csvFile = new File(System.getProperty("user.dir")+"/testData/loginData.csv");
		
		try {
			fileReader = new FileReader(csvFile);
			csvReader  = new CSVReader(fileReader);
			csvReader.readNext();
			userList = new ArrayList<Object[]>();
			while((data =csvReader.readNext())!=null){
				
				userData = new User(data[0], data[1]);
				
				userList.add(new Object[] {userData});
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList.iterator();
		
	}
}
