<%@page import="org.unibl.etf.ip.consultingapp.beans.MessageBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:useBean id="messageService" class="org.unibl.etf.ip.consultingapp.services.MessageService" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulting Application</title>
</head>
<body>
    <h2>Messages</h2>
    <%
        // Call the getAllMessages method
        List<MessageBean> messages = messageService.getAllUnreadMessages();
        
        // Check if there are any messages
        if (messages != null && !messages.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Read Status</th>
                <th>User Name</th>
                <th></th>
            </tr>
            <%
                // Iterate through the list and display messages
                for (MessageBean message : messages) {
            %>
                <tr>
                    <td><%= message.getTitle() %></td>
                    <td><%= message.isRead() ? "Read" : "Unread" %></td>
                    <td><%= message.getUserFullName() %></td>
                    <td>
                    <form action="message.jsp" method="post">
    <input type="hidden" name="messageId" value="<%= message.getId() %>" />
    <input type="hidden" name="messageTitle" value="<%= message.getTitle() %>" />
    <input type="hidden" name="messageContent" value="<%= message.getContent() %>" />
    <input type="hidden" name="messageRead" value="<%= message.isRead() %>" />
    <input type="hidden" name="messageUserFullName" value="<%= message.getUserFullName() %>" />
    <input type="hidden" name="messageUserEmail" value="<%= message.getUserEmail() %>" />
    <input type="submit" value="Show" />
</form>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No messages found.</p>
    <%
        }
    %>
    
    <button onclick="window.location.href='search.jsp';">Search messages</button>
</body>
</html>