<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CMedecin" %>
<%@ include file="Header/NavBar.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%if(request.getSession().getAttribute("medecin") == null){%>
	<meta http-equiv="refresh" content="0; url=<%=application.getContextPath()%>/Vues/Authentification.jsp">
<%}%>
<title>Bienvenue</title>
</head>
<body>
	<%
		CMedecin medecin = new CMedecin();
		if (request.getSession().getAttribute("medecin") != null) {
			medecin = (CMedecin) request.getSession().getAttribute("medecin");
		}%>
	<h2>Bienvenue :	<%= medecin.getNom()%>	<%= medecin.getPrenom()%></h2>
	<p></p>
	<p>Vous pouvez accéder à vos patients et voir leurs fiches d'information</p>
	<p>Vous pouvez voir la liste des médicaments</p>

</body>
</html>