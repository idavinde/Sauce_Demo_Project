package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.ui.pojo.Data;
import com.ui.pojo.User;

public class JSONFileUtility {
		
	public static Iterator<Object[]> readJSON(){
		
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"/testData/loginData.json");
		
		FileReader fileReader= null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Data data = gson.fromJson(fileReader, Data.class);
		List<Object[]> userList  = new ArrayList<Object[]>();
		
		for(User user : data.getUserList()) {
			
			userList.add(new Object[] {user});
		}
		
		return userList.iterator();
	}
}
