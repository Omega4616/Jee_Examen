<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>
	<%
		String identifiant = (String) request.getAttribute("inami");
		if (identifiant == null) {
			identifiant = "inconnu";
		}
		String motdepasse = (String) request.getAttribute("mdp");
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