package com.ui.pojo;

public class User {
	
	private   String username;
	private   String password ;
	
	public User(String username, String password) {
		this.username= username;
		this.password = password;
	}
	public String getUSERNAME() {
		return username;
	}
	public void setUSERNAME(String uSERNAME) {
		username = uSERNAME;
	}
	public String getPASSWORD() {
		return password;
	}
	public void setPASSWORD(String pASSWORD) {
		password = pASSWORD;
	}
	
	 
	

}
