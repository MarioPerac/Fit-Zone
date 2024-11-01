package org.unibl.etf.ip.fitzone.admin.beans;

import java.io.Serializable;


public class UserBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7376997015361755802L;
	private String username;
	private String name;
	private String surname;
	private String mail;

	public UserBean() { }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
