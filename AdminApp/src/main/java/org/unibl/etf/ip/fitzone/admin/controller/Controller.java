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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/pages/login.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if (action == null || action.equals("")) {
			address = "/WEB-INF/pages/login.jsp";
		} 
		else if (action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdminBean admin = AdminBean.login(username, password);
			if(admin != null) {
				session.setAttribute("adminBean", admin);
				address = "/WEB-INF/pages/main.jsp";
			}
			else
			{
				session.setAttribute("notification", "Incorrect username or password.");
			}
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
