package org.unibl.etf.ip.fitzone.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.unibl.etf.ip.fitzone.admin.beans.AdminBean;
import org.unibl.etf.ip.fitzone.admin.db.DatabaseConnection;

public class AdminDao {

	
	public static AdminBean login(String username, String password) {

			AdminBean admin = null;
			 String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
		     
			 try (Connection conn = DatabaseConnection.getConnection();
			         PreparedStatement ps = conn.prepareStatement(query)) {
			        
			        ps.setString(1, username);
			        ps.setString(2, password);
			        
			        try (ResultSet rs = ps.executeQuery()) {
			            if (rs.next()) {
			                admin = new AdminBean();
			                admin.setUsername(rs.getString("username"));
			                admin.setName(rs.getString("name"));
			                admin.setSurname(rs.getString("surname"));
			            }
			        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			 return admin;
	}
}
