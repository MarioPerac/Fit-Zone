package org.unibl.etf.ip.fitzone.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.unibl.etf.ip.fitzone.admin.beans.AdminBean;
import org.unibl.etf.ip.fitzone.admin.beans.CategoryBean;
import org.unibl.etf.ip.fitzone.admin.beans.UserBean;
import org.unibl.etf.ip.fitzone.admin.dao.AdminDao;
import org.unibl.etf.ip.fitzone.admin.dao.CategoryDao;
import org.unibl.etf.ip.fitzone.admin.dao.UserDao;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = "/WEB-INF/pages/login.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action == null || action.equals("")) {
			address = "/WEB-INF/pages/login.jsp";
		} else if (action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdminBean admin = AdminDao.login(username, password);
			if (admin != null) {
				session.setAttribute("adminBean", admin);
				address = "/WEB-INF/pages/main.jsp";
			} else {
				session.setAttribute("notification", "Incorrect username or password.");
			}

		}else if(action.equals("home")) {
			address = "/WEB-INF/pages/main.jsp";
		}
		
		else if (action.equals("categories")) {
			request.setAttribute("categories", CategoryBean.getAll());
			address = "/WEB-INF/pages/categories.jsp";
		} else if (action.equals("users")) {
			request.setAttribute("users", UserDao.getAllUsers());
			address = "/WEB-INF/pages/users.jsp";
		} else if (action.equals("updateCategory")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String attribute = request.getParameter("attribute");
			
			CategoryBean categoryBean = new CategoryBean();
			
			categoryBean.setId(id);
			categoryBean.setName(name);
			categoryBean.setAttribute(attribute);
			
			CategoryBean.updateCategory(categoryBean);
			
			request.setAttribute("categories", CategoryBean.getAll());
			address = "/WEB-INF/pages/categories.jsp";
		} else if (action.equals("deleteCategory")) {
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryBean.deleteCategory(id);
			request.setAttribute("categories", CategoryBean.getAll());
			address = "/WEB-INF/pages/categories.jsp";
		} else if (action.equals("addCategoryPage")) {

			address = "/WEB-INF/pages/addCategory.jsp";
		} else if (action.equals("addCategory")) {
			String name = request.getParameter("name");
			String attribute = request.getParameter("attribute");
			CategoryBean categoryBean = new CategoryBean();
			categoryBean.setName(name);
			categoryBean.setAttribute(attribute);
			CategoryBean.addCategory(categoryBean);

			request.setAttribute("categories", CategoryBean.getAll());
			address = "/WEB-INF/pages/categories.jsp";
		} else if (action.equals("updateCategoryPage")) {
			int id = Integer.parseInt(request.getParameter("id"));

			request.setAttribute("categoryBean", CategoryDao.getById(id));
			address = "/WEB-INF/pages/updateCategoryPage.jsp";
		}
		else if(action.equals("deleteUser")) {
			String username = request.getParameter("username");
			UserDao.deleteUser(username);
			request.setAttribute("users", UserDao.getAllUsers());
			address = "/WEB-INF/pages/users.jsp";
		}
		else if(action.equals("updateUser"))
		{
			   String username = request.getParameter("username");
	            String name = request.getParameter("name");
	            String surname = request.getParameter("surname");
	            String mail = request.getParameter("mail");


	            UserBean user = new UserBean();
	            user.setUsername(username);
	            user.setName(name);
	            user.setSurname(surname);
	            user.setMail(mail);
	            
	            UserDao.updateUser(user);
	    		request.setAttribute("users", UserDao.getAllUsers());
				address = "/WEB-INF/pages/users.jsp";
		}
		else if(action.equals("updateUserPage"))
		{
			String username = request.getParameter("username");
			UserBean userBean = UserDao.getById(username);
			
			request.setAttribute("userBean", userBean);
			address = "/WEB-INF/pages/userUpdatePage.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
