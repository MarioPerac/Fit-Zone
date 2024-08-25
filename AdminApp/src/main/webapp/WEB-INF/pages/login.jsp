<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Application</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 300px;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h2 {
        margin-bottom: 20px;
    }
    label {
        align-self: flex-start;
        margin-bottom: 5px;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    h3 {
        color: red;
        text-align: center;
        margin-top: 15px;
    }
</style>
</head>
<body>


<form method="POST" action="?action=login">
    <h2>Login</h2>
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" required><br/>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required><br/>

    <input type="submit" name="submit" value="Login"><br/>
    <h3><%=session.getAttribute("notification") != null ? session.getAttribute("notification") : "" %></h3>
</form>
</body>
</html>