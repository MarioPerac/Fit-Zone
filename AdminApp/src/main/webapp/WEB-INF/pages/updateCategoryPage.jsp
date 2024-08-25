<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.unibl.etf.ip.fitzone.admin.beans.CategoryBean" %>
<%@ page import="org.unibl.etf.ip.fitzone.admin.dao.CategoryDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
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
        text-align: center;
        margin-bottom: 20px;
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    label {
        font-weight: bold;
        margin-bottom: 5px;
        align-self: flex-start; 
    }
    input[type="text"] {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        margin-bottom: 10px;
        width: 100%; /* Full width */
        max-width: 300px;
    }
    input[type="submit"] {
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%; /* Full width */
        max-width: 150px; 
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .back-link {
        display: block;
        margin-top: 20px;
        text-align: center;
    }
    .back-link a {
        color: #007bff;
        text-decoration: none;
    }
    .back-link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<%
    CategoryBean category = (CategoryBean) request.getAttribute("categoryBean");
%>
<div class="container">
    <h1>Update Category</h1>

    <form action="?action=updateCategory" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= category.getId() %>">
        <p>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%= category.getName() %>" required>
        </p>
        <p>
            <label for="attribute">Attribute:</label>
            <input type="text" id="attribute" name="attribute" value="<%= category.getAttribute() %>" required>
        </p>
        <p>
            <input type="submit" value="Save">
        </p>
    </form>

    <p class="back-link"><a href="?action=categories">Back to Category List</a></p>
</div>

</body>
</html>
