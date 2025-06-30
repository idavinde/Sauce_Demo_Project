package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReaderUtility {

	public static Iterator<User> excelReader() {
		
		List<User> userList;
		File file;
		XSSFWorkbook xssfWorkbook;
		 XSSFSheet xssfSheet=null;
		
		
		file = new File(System.getProperty("user.dir")+"/testData/loginData.xlsx");
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			xssfSheet = xssfWorkbook.getSheet("loginData");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  xssfSheet = xssfWorkbook.getSheet("loginData");
		
		Iterator<Row> rowIterator = xssfSheet.rowIterator();
		rowIterator.next();
		userList = new ArrayList<User>();
		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			Cell firstCell = row.getCell(0);
			Cell secondCell = row.getCell(1);
			User user = new User(firstCell.toString(), secondCell.toString());
			userList.add(user);

		}

		return userList.iterator();

	}

}
