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
