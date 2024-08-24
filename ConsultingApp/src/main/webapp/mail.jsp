<%@page import="org.unibl.etf.ip.fitzone.models.dto.Mail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="mailService" class="org.unibl.etf.ip.consultingapp.services.MailService" scope="application"></jsp:useBean>
<!DOCTYPE html>
<%
	if (request.getParameter("submit") != null) {
		  String messageTitle = request.getParameter("messageTitle");
	        String userFullName = request.getParameter("userName");
	        String userEmail = request.getParameter("userEmail");
	        String content = request.getParameter("content");
	        
		Mail mail = new Mail(userEmail, messageTitle, userFullName, content );
		if(mailService.sendMail(mail)){
		session.setAttribute("notification", "Email sent successfully!");
		}
		else{
			session.setAttribute("notification", "Failed to send the email.");
		}
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mail</title>
</head>
<body>
<%
%>
 <form action="mail.jsp" method="post">
     <input type="hidden" name="messageTitle" value="<%= request.getParameter("messageTitle") %>" />
    <input type="hidden" name="userName" value="<%= request.getParameter("userName") %>" />
    <input type="hidden" name="userEmail" value="<%= request.getParameter("userEmail") %>" />
    
    <label for="content"> Content:</label><br/>
    <textarea id="content" name="content" rows="10" cols="50" required></textarea><br/>
    
 <input type="submit" name="submit" value="Send Email" />
 <h3><%=session.getAttribute("notification").toString()%></h3>
 </form>
</body>
</html>