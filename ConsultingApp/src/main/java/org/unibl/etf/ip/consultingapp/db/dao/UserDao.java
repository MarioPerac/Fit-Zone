package org.unibl.etf.ip.consultingapp.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.unibl.etf.ip.consultingapp.beans.UserBean;
import org.unibl.etf.ip.consultingapp.db.DatabaseConnection;

public class UserDao {

	
	public static UserBean login(String username, String password) {

			UserBean user = null;
			 String query = "SELECT * FROM advisor WHERE username = ? AND password = ?";
		     
			 try (Connection conn = DatabaseConnection.getConnection();
			         PreparedStatement ps = conn.prepareStatement(query)) {
			        
			        ps.setString(1, username);
			        ps.setString(2, password);
			        
			        try (ResultSet rs = ps.executeQuery()) {
			            if (rs.next()) {
			                user = new UserBean();
			                user.setUsername(rs.getString("username"));
			                user.setPassword(rs.getString("password"));
			                user.setFullName(rs.getString("full_name"));
			            }
			        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			 return user;
	}
}
