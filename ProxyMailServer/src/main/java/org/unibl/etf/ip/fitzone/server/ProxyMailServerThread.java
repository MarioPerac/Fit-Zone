package org.unibl.etf.ip.fitzone.server;

import org.unibl.etf.ip.fitzone.logger.AppLogger;
import org.unibl.etf.ip.fitzone.models.dto.Mail;
import org.unibl.etf.ip.fitzone.properties.ConfigMailProperties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

public class ProxyMailServerThread extends Thread {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private ConfigMailProperties prop = new ConfigMailProperties();

    public ProxyMailServerThread(Socket socket) {
        this.socket = socket;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            AppLogger.getLogger().log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void run() {

        try {

                    Mail mail = (Mail) in.readObject();

                    Session session = Session.getDefaultInstance(prop.getMailProperties(), new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(prop.getUsername(), prop.getPassword());
                        }
                    });
                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(prop.getUsername()));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo()));
                        message.setSubject(mail.getSubject());
                        message.setContent(mail.getHtmlContent(), "text/html");

                        Transport.send(message);
                        out.writeObject("OK");
                        out.flush();
                    } catch (MessagingException e) {
                        AppLogger.getLogger().log(Level.INFO, e.getMessage());
                        out.writeObject("NOK");
                        out.flush();
                    }


        } catch (IOException | ClassNotFoundException e) {
            AppLogger.getLogger().log(Level.SEVERE, e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                AppLogger.getLogger().log(Level.SEVERE, e.getMessage());
            }

        }
    }
}
