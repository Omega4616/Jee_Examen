<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="Header/NavBar.html" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>
	<%
		String identifiant = (String) request.getSession(false).getAttribute("inami").toString();
		if (identifiant == null) {
			identifiant = "inconnu";
		}
		String motdepasse = (String) request.getSession(false).getAttribute("Nom");
		if (motdepasse == null) {
			motdepasse = "inconnu";
		}
	%>
	<h2>
		Bienvenue client :
		<%=identifiant%>
		<%=motdepasse%></h2>

</body>
</html>