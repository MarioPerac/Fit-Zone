package org.unibl.etf.ip.consultingapp.services;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

import org.unibl.etf.ip.fitzone.models.dto.Mail;

public class MailService implements Serializable {
	
	private String ADDRESS = "localhost";
	private int PORT = 9001;
	 public MailService() {
   }


   public boolean sendMail(Mail mail) {
	   String htmlContent = "<html>"
               + "<body>"
               + "<p>Dear " + mail.getToFullName() + ",</p>"
               + "<p>" + mail.getHtmlContent() + "</p>"
               + "<br>"
               + "<p>Kind regards,</p>"
               + "<p>Fit Zone Consulting</p>" 
               + "</body>"
               + "</html>";
	   mail.setHtmlContent(htmlContent);
	   
       boolean sent = false;
       try (Socket socket = new Socket(InetAddress.getByName(ADDRESS), PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
       ) {

           out.writeObject(mail);
           out.flush();

           String result = (String) in.readObject();
           sent = "OK".equals(result);

       } catch (IOException | ClassNotFoundException e) {
    	   return false;
       }
       
       return true;
   }
}
