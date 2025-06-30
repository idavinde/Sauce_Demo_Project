package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Envir;
import com.google.gson.Gson;
import com.ui.pojo.Configuration;
import com.ui.pojo.Enviroment;

public class JSONEnvirUtility {

	public static  Enviroment readConfigJason(Envir enviroment) {
		
	
	File file = new File(System.getProperty("user.dir")+"/config/JSONConfig.json");
	FileReader fileReader = null;
	try {
		fileReader = new FileReader(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Gson gson = new Gson();
	
	Configuration  config= gson.fromJson(fileReader, Configuration.class);
	
	Enviroment envir = config.getEnviroment().get(""+enviroment+"");
	 
	return envir;
	}
	
	

}
