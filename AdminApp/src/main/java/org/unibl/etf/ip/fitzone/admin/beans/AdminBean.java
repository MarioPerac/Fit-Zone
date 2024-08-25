package org.unibl.etf.ip.fitzone.admin.beans;

import java.io.Serializable;

import org.unibl.etf.ip.fitzone.admin.dao.AdminDao;

public class AdminBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3168787539194301653L;
	private String username;
	private String name;
	private String surname;

	public AdminBean() {}

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
	
}
