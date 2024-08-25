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
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        max-width: 500px;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        box-sizing: border-box;
    }
    h1 {
        font-size: 24px;
        margin-bottom: 20px;
        color: #333;
        text-align: center;
    }
    .info-item {
        display: flex;
        justify-content: space-between;
        margin-bottom: 15px;
        align-items: flex-start;
    }
    .info-label {
        font-weight: bold;
        margin-right: 10px; 
        width: 30%; 
        text-align: left;
        white-space: nowrap; 
        overflow: hidden;
        text-overflow: ellipsis; 
    }
    .info-value {
        width: 70%; 
        text-align: left;
        word-wrap: break-word; 
        overflow-wrap: break-word; 
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 20px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 10px;
        width: 100%; 
        max-width: 150px;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .button-container {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }
    button {
        padding: 10px 20px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%; 
        max-width: 150px;
    }
    button:hover {
        background-color: #218838;
    }
</style>
</head>
<body>
     <div class="container">
        <h1>Message Details</h1>
        <div class="info-item">
            <span class="info-label">Title:</span>
            <span class="info-value"><%= title %></span>
        </div>
        
        <div class="info-item">
            <span class="info-label">Content:</span>
            <span class="info-value"><%= content %></span>
        </div>
        
        <div class="info-item">
            <span class="info-label">User Full Name:</span>
            <span class="info-value"><%= userFullName %></span>
        </div>
        
        <div class="info-item">
            <span class="info-label">User Email:</span>
            <span class="info-value"><%= userEmail %></span>
        </div>
        
        <form action="mail.jsp" method="post">
            <input type="hidden" name="messageTitle" value="<%= title %>" />
            <input type="hidden" name="userName" value="<%= userFullName %>" />
            <input type="hidden" name="userEmail" value="<%= userEmail %>" />
            <input type="submit" value="Answer" />
        </form>
       <div class="button-container">
            <button onclick="window.location.href='main.jsp';">Go Back</button>
        </div>
    </div>
</body>
</html>