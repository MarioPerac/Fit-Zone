<%@ page import="org.unibl.etf.ip.consultingapp.beans.MessageBean"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="messageService" class="org.unibl.etf.ip.consultingapp.services.MessageService" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Consulting Application</title>
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
        h2 {
            color: #007bff;
            margin-bottom: 20px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
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
        form {
            display: inline;
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
        button {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            display: block;
            margin: 20px auto;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Messages</h2>
        <%
            List<MessageBean> messages = messageService.getAllUnreadMessages();

            if (messages != null && !messages.isEmpty()) {
        %>
        <table>
            <tr>
                <th>Title</th>
                <th>Read Status</th>
                <th>User Name</th>
                <th>Action</th>
            </tr>
            <%
        
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
        <p style="text-align: center;">No messages found.</p>
        <%
            }
        %>
        
        <button onclick="window.location.href='search.jsp';">Search messages</button>
    </div>
</body>
</html>
