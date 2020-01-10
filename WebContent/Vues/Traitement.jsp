<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CPatient"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CMedicament"%>
<%@ include file="Header/NavBar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%if(request.getSession().getAttribute("medecin") == null){%>
	<meta http-equiv="refresh" content="0; url=<%=application.getContextPath()%>/Vues/Authentification.jsp">
<%}%>
<meta charset="ISO-8859-1">
<title>Traitement</title>
<style>
input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=button], input[type=submit], input[type=reset], a {
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
  width: 50%;
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
<a href="<%=application.getContextPath()%>/ChercherMedicament" >Selectionner les médicaments</a>
</body>
</html>