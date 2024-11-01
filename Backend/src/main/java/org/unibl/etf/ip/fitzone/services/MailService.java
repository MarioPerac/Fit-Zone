package org.unibl.etf.ip.fitzone.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.models.dto.Mail;
import org.unibl.etf.ip.fitzone.properties.ConfigMailProperties;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;

@Service
public class MailService {

    @Value("${spring.mail.port}")
    private int PORT;
    @Value("${spring.mail.host}")
    private String ADDRESS;

    public MailService() {
//        PORT = Integer.parseInt(prop.getProxyMailServerPort());
//        ADDRESS = prop.getProxyMailServerAddres();
    }


    public void sendMail(Mail mail) {

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
//            AppLogger.getLogger().log(Level.SEVERE, e.getMessage());
        }

    }
}
