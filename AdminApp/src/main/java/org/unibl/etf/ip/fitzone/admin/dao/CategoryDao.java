package org.unibl.etf.ip.fitzone.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.fitzone.admin.beans.CategoryBean;
import org.unibl.etf.ip.fitzone.admin.db.DatabaseConnection;

public class CategoryDao {
	
	public static CategoryBean getById(int id) {
		CategoryBean category  = null;
		String query = "SELECT * FROM category WHERE id = ? ";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
	        ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					category = new CategoryBean();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setAttribute(rs.getString("attribute"));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}

	public static List<CategoryBean> getAll() {
		String query = "SELECT * FROM category";
		List<CategoryBean> categories = new ArrayList<CategoryBean>();
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					CategoryBean category = new CategoryBean();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setAttribute(rs.getString("attribute"));
					categories.add(category);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	public static void addCategory(CategoryBean category) {
	    String query = "INSERT INTO category (name, attribute) VALUES (?, ?)";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        
	        ps.setString(1, category.getName());
	        ps.setString(2, category.getAttribute());
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void updateCategory(CategoryBean category) {
	    String query = "UPDATE category SET name = ?, attribute = ? WHERE id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        
	        ps.setString(1, category.getName());
	        ps.setString(2, category.getAttribute());
	        ps.setInt(3, category.getId());
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void deleteCategory(int categoryId) {
	    String query = "DELETE FROM category WHERE id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        
	        ps.setInt(1, categoryId);
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
