package org.unibl.etf.ip.fitzone.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.fitzone.admin.beans.UserBean;
import org.unibl.etf.ip.fitzone.admin.db.DatabaseConnection;

public class UserDao {
	
	public static UserBean getById(String username) {
		UserBean user  = null;
		String query = "SELECT * FROM user WHERE username = ? ";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
	        ps.setString(1, username);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user = new UserBean();
					user.setName(rs.getString("name"));
					user.setMail(rs.getString("mail"));
					user.setSurname(rs.getString("surname"));
					user.setUsername(rs.getString("username"));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	 public static List<UserBean> getAllUsers() {
	        List<UserBean> users = new ArrayList<>();
	        String query = "SELECT * FROM user";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    UserBean user = new UserBean();
	                    user.setName(rs.getString("name"));
	                    user.setMail(rs.getString("mail"));
	                    user.setSurname(rs.getString("surname"));
	                    user.setUsername(rs.getString("username"));
	                    users.add(user);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    public static void addUser(UserBean user) {
	        String query = "INSERT INTO user (name, mail, surname, username) VALUES (?, ?, ?, ?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setString(1, user.getName());
	            ps.setString(2, user.getMail());
	            ps.setString(3, user.getSurname());
	            ps.setString(4, user.getUsername());
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void updateUser(UserBean user) {
	        String query = "UPDATE user SET name = ?, mail = ?, surname = ? WHERE username = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setString(1, user.getName());
	            ps.setString(2, user.getMail());
	            ps.setString(3, user.getSurname());
	            ps.setString(4, user.getUsername());
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void deleteUser(String username) {
	        String query = "DELETE FROM user WHERE username = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setString(1, username);
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
