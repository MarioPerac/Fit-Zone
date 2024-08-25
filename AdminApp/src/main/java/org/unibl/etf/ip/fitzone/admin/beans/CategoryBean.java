package org.unibl.etf.ip.fitzone.admin.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.ip.fitzone.admin.dao.CategoryDao;
import org.unibl.etf.ip.fitzone.admin.db.DatabaseConnection;

public class CategoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4788018859092999132L;

	private int id;
	private String name;
	private String attribute;
	
	public CategoryBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	public static List<CategoryBean> getAll() {
		return CategoryDao.getAll();
	}
	
	public static void addCategory(CategoryBean category) {
	     CategoryDao.addCategory(category);
	}

	public static void updateCategory(CategoryBean category) {
	   
	  CategoryDao.updateCategory(category);
	}
	
	public static void deleteCategory(int categoryId) {
		CategoryDao.deleteCategory(categoryId);
	}
}
