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

	public static List<MessageBean> getAllUnreadMessages() {
		List<MessageBean> messages = new ArrayList<>();
		String query = "SELECT m.id, m.title, m.content, m.is_read, u.name, u.surname, u.mail  FROM message_to_advisors m JOIN user u ON u.username = m.user_username WHERE is_read= ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setBoolean(1, false);
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
	

	public static List<MessageBean> searchMessagesByContent(String searchTerm){
		List<MessageBean> messages = new ArrayList<>();

        String sql = "SELECT  m.title, m.content, m.is_read, u.name, u.surname, u.mail  FROM message_to_advisors m JOIN user u ON u.username = m.user_username WHERE content LIKE ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + searchTerm + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    MessageBean message = new MessageBean();
                    message.setTitle(resultSet.getString("title"));
                    message.setContent(resultSet.getString("content"));
                    message.setRead(resultSet.getBoolean("is_read"));
                    message.setUserFullName(resultSet.getString("name") + " " + resultSet.getString("surname"));
                    message.setUserEmail(resultSet.getString("mail"));

                    messages.add(message);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return messages;
	}
}
