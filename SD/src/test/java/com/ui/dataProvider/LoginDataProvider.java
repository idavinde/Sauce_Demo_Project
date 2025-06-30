package com.ui.dataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.Data;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import com.utility.JSONFileUtility;

public class LoginDataProvider {
	
	@DataProvider(name = "JSONLoginDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		
		return JSONFileUtility.readJSON();
	
	}
	
	@DataProvider(name = "CSVLoginDataProvider")
	public Iterator<Object[]> CSVLoginDataProvider(){
		
		return CSVReaderUtility.readCSV();
	}
	
	@DataProvider(name = "ExcelLoginDataProvider")
	public Iterator<User> ExcelLoginDataProvider() {
		
		 return ExcelReaderUtility.excelReader();
	}
}
