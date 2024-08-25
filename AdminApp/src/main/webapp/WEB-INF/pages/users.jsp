<%@page import="org.unibl.etf.ip.fitzone.admin.beans.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    table, th, td {
        border: 1px solid #ccc;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    .button-container {
        text-align: center;
    }
    .button {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        cursor: pointer;
        margin: 0 5px; 
        display: inline-block; 
    }
    .button:hover {
        background-color: #0056b3;
    }
    .no-users {
        text-align: center;
    }
</style>
</head>
<body>

<div class="container">
    <h1>User Management</h1>
    
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Mail</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<UserBean> users = (List<UserBean>) request.getAttribute("users");
                
                if (users != null && !users.isEmpty()) {
                    for (UserBean user : users) {
            %>
                        <tr>
                            <td><%= user.getUsername() %></td>
                            <td><%= user.getName() %></td>
                            <td><%= user.getSurname() %></td>
                            <td><%= user.getMail() %></td>
                            <td>
                                <a href="?action=updateUserPage&username=<%= user.getUsername() %>" class="button">Update</a>
                                <a href="?action=deleteUser&username=<%= user.getUsername() %>" class="button">Delete</a>
                            </td>
                        </tr>
            <% 
                    }
                } else {
            %>
                    <tr>
                        <td colspan="5" class="no-users">No users available</td>
                    </tr>
            <% 
                }
            %>
        </tbody>
    </table>
    <p class="back-link"><a href="?action=home">Back to home</a></p>
</div>

</body>
</html>
