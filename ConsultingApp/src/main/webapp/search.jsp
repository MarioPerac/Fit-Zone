<%@page import="java.util.ArrayList"%>
<%@page import="org.unibl.etf.ip.consultingapp.beans.MessageBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="messageService"
	class="org.unibl.etf.ip.consultingapp.services.MessageService"
	scope="application"></jsp:useBean>
<jsp:useBean id="messageBean"
	class="org.unibl.etf.ip.consultingapp.beans.MessageBean" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Messages</title>
  <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            max-width: 1000px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #007bff;
            margin-bottom: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            margin-right: 10px;
        }
        input[type="text"] {
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

	<!-- Search Form -->
	<form action="search.jsp" method="get">
		<label for="searchTerm">Search Messages by Content:</label> <input
			type="text" id="searchTerm" name="searchTerm"
			value="<%=request.getParameter("searchTerm")%>"> <input
			type="submit" value="Search">
	</form>

	<!-- Messages Table -->
	<table border="1">
		<tr>
			<th>Title</th>
			<th>Content</th>
			<th>Read Status</th>
			<th>User Name</th>
			<th>Email</th>
		</tr>
		<%
		String searchTerm = request.getParameter("searchTerm");
		List<MessageBean> messages = null;

		if (searchTerm != null && !searchTerm.isEmpty()) {

			messages = messageService.searchMessagesByContent(searchTerm);
		}

		if (messages != null) {

			for (MessageBean message : messages) {
		%>
		<tr>
			<td><%=message.getTitle()%></td>
			<td><%=message.getContent()%></td>
			<td><%=message.isRead() ? "Read" : "Unread"%></td>
			<td><%=message.getUserFullName()%></td>
			<td><%=message.getUserEmail()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

</body>
</html>
