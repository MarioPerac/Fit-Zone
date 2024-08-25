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
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 300px;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h2 {
        margin-bottom: 20px;
    }
    label {
        align-self: flex-start;
        margin-bottom: 5px;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    h3 {
        color: red;
        text-align: center;
        margin-top: 15px;
    }
</style>
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