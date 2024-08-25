<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fit Zone Admin</title>
</head>
<body>
  <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .menu-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .menu-item {
            margin: 10px 0;
            padding: 10px;
            background-color: #007bff;
            color: white;
            text-align: center;
            text-decoration: none;
            display: block;
            border-radius: 5px;
        }
        .menu-item:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <h1>Fit Zone Admin</h1>
        <h3>Select an option:</h3>
        <a href="?action=categories" class="menu-item">Categories</a>
        <a href="?action=users" class="menu-item">Users</a>
    </div>
</body>
</html>