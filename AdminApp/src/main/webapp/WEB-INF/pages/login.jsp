<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulting Application</title>
</head>
<body>

<form method="POST" action="?action=login">
Username:
<input type="text" name="username"><br/>
Password:
<input type="password" name="password" ><br/>

<input type="submit" name="submit" value="Login"><br/>
<h3><%=session.getAttribute("notification") != null ? session.getAttribute("notification") : "" %></h3>
</form>
</body>
</html>