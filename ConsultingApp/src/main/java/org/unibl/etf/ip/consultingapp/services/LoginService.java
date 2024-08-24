package org.unibl.etf.ip.consultingapp.services;

import java.io.Serializable;

import org.unibl.etf.ip.consultingapp.beans.UserBean;
import org.unibl.etf.ip.consultingapp.db.dao.UserDao;

public class LoginService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8176132216150462358L;

	public LoginService() {}
	
	
	public UserBean login(String username, String password) {
	
		return UserDao.login(username, password);
	}

}
