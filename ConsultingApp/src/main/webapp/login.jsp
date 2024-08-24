<%@page import="org.unibl.etf.ip.consultingapp.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" class="org.unibl.etf.ip.consultingapp.beans.UserBean" scope="session"></jsp:useBean>
<jsp:useBean id="loginService" class="org.unibl.etf.ip.consultingapp.services.LoginService" scope="application"></jsp:useBean>
<jsp:setProperty property="username" name="userBean" param="username" />
<jsp:setProperty property="password" name="userBean" param="password" />
<!DOCTYPE html>
<%
	if (request.getParameter("submit") != null) {
		UserBean u = loginService.login(userBean.getUsername(), userBean.getPassword());
		if (u != null) {
			userBean.setFullName(u.getFullName());
			userBean.setLoggedIn(true);
			session.setAttribute("notification", "");
			response.sendRedirect("main.jsp");
		} else {
			session.setAttribute("notification", "Incorrect username or password.");
			userBean.setLoggedIn(false);
		}
	} else {
		session.setAttribute("notification", "");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulting Application</title>
</head>
<body>

<form method="POST" action="login.jsp">
Username:
<input type="text" name="username"><br/>
Password:
<input type="password" name="password" ><br/>

<input type="submit" name="submit" value="Login"><br/>
<h3><%=session.getAttribute("notification").toString()%></h3>
</form>
</body>
</html>