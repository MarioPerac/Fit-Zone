package org.unibl.etf.ip.consultingapp.services;

import java.io.Serializable;
import java.util.List;

import org.unibl.etf.ip.consultingapp.beans.MessageBean;
import org.unibl.etf.ip.consultingapp.db.dao.MessageDao;

public class MessageService implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7519552359001278066L;

	public MessageService() {}
	
	public List<MessageBean> getAllMessages(){
		
		return MessageDao.getAllMessages();
	}
	
	public void messageRead(String id) {
		MessageDao.messageRead(id);
	}
}
