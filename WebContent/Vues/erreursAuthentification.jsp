<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="Header/NavBar.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Refresh" content="4;url=<%=application.getContextPath()%>/Vues/Authentification.jsp">
<title>Erreurs !</title>
</head>
<body>
	<%
		ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
	%>
	<h2>Les erreurs suivantes se sont produites</h2>
	<ul>
		<%
			for (String s : erreurs)
				out.println("<li>" + s + "</li>");
		%>
	</ul>

</body>
</html>