<%@ page import="org.unibl.etf.ip.fitzone.models.dto.Mail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="mailService" class="org.unibl.etf.ip.consultingapp.services.MailService" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #007bff;
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 8px;
            font-weight: bold;
        }
        textarea {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 20px;
            resize: vertical;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .notification {
            margin-top: 20px;
            padding: 10px;
            border-radius: 4px;
            font-weight: bold;
        }
        .notification.success {
            background-color: #d4edda;
            color: #155724;
        }
        .notification.error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Send Mail</h1>
        <form action="mail.jsp" method="post">
            <input type="hidden" name="messageTitle" value="<%= request.getParameter("messageTitle") %>" />
            <input type="hidden" name="userName" value="<%= request.getParameter("userName") %>" />
            <input type="hidden" name="userEmail" value="<%= request.getParameter("userEmail") %>" />
            
            <label for="content">Content:</label>
            <textarea id="content" name="content" rows="10" cols="50" required></textarea>
            
            <input type="submit" name="submit" value="Send Email" />
            
            <%
                String notification = (String) session.getAttribute("notification");
                if (notification != null) {
                    String notificationClass = notification.contains("success") ? "success" : "error";
            %>
            <div class="notification <%= notificationClass %>">
                <%= notification %>
            </div>
            <%
                    session.removeAttribute("notification");
                }
            %>
        </form>
    </div>
</body>
</html>
