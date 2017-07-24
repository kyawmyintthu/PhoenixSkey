package com.phoenixInfoTech.security;

public class DBSecurityObject {
	
	private String dbUserName;
	private String dbPassword;
	
	public DBSecurityObject(){
		
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
