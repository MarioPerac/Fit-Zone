<%@page import="org.unibl.etf.ip.fitzone.admin.beans.CategoryBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        padding: 20px;
    }
    .container {
        max-width: 600px;
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
        margin-right: 10px;
    }
    .button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Category Management</h1>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Attribute</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
             
                List<CategoryBean> categories = (List<CategoryBean>) request.getAttribute("categories");
                
                
                if (categories != null && !categories.isEmpty()) {
                    for (CategoryBean category : categories) {
            %>
                        <tr>
                            <td><%= category.getId() %></td>
                            <td><%= category.getName() %></td>
                            <td><%= category.getAttribute() %></td>
                            <td>
                                <a href="?action=updateCategoryPage&id=<%= category.getId() %>" class="button">Update</a>
                                <a href="?action=deleteCategory&id=<%= category.getId() %>" class="button">Delete</a>
                            </td>
                        </tr>
            <% 
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4" style="text-align:center;">No categories available</td>
                    </tr>
            <% 
                }
            %>
        </tbody>
    </table>

    <div class="button-container">
        <a href="?action=addCategoryPage" class="button">Add New Category</a>
    </div>
       <p class="back-link"><a href="?action=home">Back to home</a></p>
</div>

</body>
</html>
