package org.unibl.etf.ip.consultingapp.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.consultingapp.beans.MessageBean;
import org.unibl.etf.ip.consultingapp.beans.UserBean;
import org.unibl.etf.ip.consultingapp.db.DatabaseConnection;

public class MessageDao {

	public static List<MessageBean> getAllMessages() {
		List<MessageBean> messages = new ArrayList<>();
		String query = "SELECT m.id, m.title, m.content, m.is_read, u.name, u.surname, u.mail  FROM message_to_advisors m JOIN user u ON u.username = m.user_username";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					MessageBean mb = new MessageBean();
					mb.setId(rs.getInt("id"));
					mb.setTitle(rs.getString("title"));
					mb.setContent(rs.getString("content"));
					mb.setRead(rs.getBoolean("is_read"));
					mb.setUserFullName(rs.getString("name") + " " + rs.getString("surname"));
					mb.setUserEmail(rs.getString("mail"));
					messages.add(mb);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return messages;
	}
	
	public static void messageRead(String id) {
		  String query = "UPDATE message_to_advisors SET is_read = ? WHERE id = ?";

		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement ps = conn.prepareStatement(query)) {

		        ps.setBoolean(1, true); 
		        ps.setInt(2, Integer.parseInt(id)); 

		        ps.executeUpdate();

		    } catch (SQLException e) {
		        e.printStackTrace(); 
		    }
	}
}
