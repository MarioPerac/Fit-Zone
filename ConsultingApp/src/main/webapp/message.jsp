<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="messageService" class="org.unibl.etf.ip.consultingapp.services.MessageService" scope="application"></jsp:useBean>
<!DOCTYPE html>
    <%
        String id = request.getParameter("messageId");
        String title = request.getParameter("messageTitle");
        String content = request.getParameter("messageContent");
        String readStatus = request.getParameter("messageRead");
        String userFullName = request.getParameter("messageUserFullName");
        String userEmail = request.getParameter("messageUserEmail");
        boolean isRead = Boolean.parseBoolean(readStatus);
        
        if(!isRead){
        messageService.messageRead(id);
        }
    %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
    <p><strong>Title:</strong> <%= title %></p>
    <p><strong>Content:</strong> <%= content %></p>
    <p><strong>User Full Name:</strong> <%= userFullName %></p>
    <p><strong>User Email:</strong> <%= userEmail %></p>
    <form action="mail.jsp" method="post">
        <input type="hidden" name="messageTitle" value="<%= title %>" />
    	<input type="hidden" name="userName" value="<%= userFullName %>" />
        <input type="hidden" name="userEmail" value="<%= userEmail %>" />
        <input type="submit" value="Answer" />
    </form>
    <button onclick="window.location.href='main.jsp';">Go Back</button>
</body>
</html>