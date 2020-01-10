<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CPatient"%>
<%@ include file="Header/NavBar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%if(request.getSession().getAttribute("medecin") == null){%>
	<meta http-equiv="refresh" content="0; url=<%=application.getContextPath()%>/Vues/Authentification.jsp">
<%}%>
<style>
#aRetourListe {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 8px 12px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 80%;
  align: center;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<title>Fiche information</title>
</head>
<body>
<%
		CPatient Patient = null;
		//Récupération du patient 
		if(request.getAttribute("Patient") != null){
			Patient = (CPatient)request.getAttribute("Patient");
		}
%>
<table>
		<tr>
			<th>Prénom</th>
			<th>Nom</th>
			<th>Sexe</th>
			<th>Numéro de registre national</th>
			<th>Adresse</th>
			<th>Téléphone</th>
			<th>Date de naissance</th>
			
		</tr>
	
			<tr>
				<th><%= Patient.getPrenom() %></th>
				<th><%= Patient.getNom() %></th>
				<th><%= Patient.getSexe() %></th>
				<th><%= Patient.getNrn() %></th>
				<th><%= Patient.getAdresse() %></th>
				<th><%= Patient.getTelephone() %></th>
				<th><%= Patient.getDateNaissance() %></th>
</table>
	<br/>
	<a id="aRetourListe" href="<%=application.getContextPath()%>/GererPatient" >Liste des patients</a>
</body>
</html>