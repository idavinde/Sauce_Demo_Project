package com.ui.pojo;

import java.util.Map;

public class Configuration {
	
	private Map <String , Enviroment> Environment;
	

	public Map<String, Enviroment> getEnviroment() {
		return Environment;
	}

	public void setEnviroment(Map<String, Enviroment> Environment) {
		this.Environment = Environment;
	}

}
