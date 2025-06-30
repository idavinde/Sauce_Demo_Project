package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	
	private LoggerUtility() {
		// TODO Auto-generated constructor stub
	}
	
	public static Logger getLog(Class<?> clazz) {
		Logger logger = null;
		if(logger ==null) {
		logger =LogManager.getLogger(clazz);
		}
		
		return logger;
	}

}
