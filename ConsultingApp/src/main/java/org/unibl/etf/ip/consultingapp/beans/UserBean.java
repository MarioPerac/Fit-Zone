package org.unibl.etf.ip.consultingapp.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4196331195638262882L;
	private String username;
	private String password;
	private String fullName;
	
	public boolean loggedIn;

	public UserBean() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

}
