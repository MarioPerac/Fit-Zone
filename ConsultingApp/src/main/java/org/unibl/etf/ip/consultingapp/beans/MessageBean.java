package org.unibl.etf.ip.consultingapp.beans;

import java.io.Serializable;

public class MessageBean implements Serializable {
	
	/**
	 * 
	 */
	
	private int id;
	private String title;
	private String content;
	private String userFullName;
	private boolean isRead;
	private String userEmail;
	
	private static final long serialVersionUID = 6358940491867378447L;

	public MessageBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
