<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CPatient"%>
<%@ include file="Header/NavBar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%if(request.getSession().getAttribute("medecin") == null){%>
	<meta http-equiv="refresh" content="0; url=<%=application.getContextPath()%>/Vues/Authentification.jsp">
<%}%>
<style>
input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=button], input[type=submit], input[type=reset], button {
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
<meta charset="ISO-8859-1">
<title>Recherche d'un médicament</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/GererPatient"
		method="POST">
		<table margin="10 px">
			<tbody>
				<tr>
					<td>Nom patient</td>
					<td><input type="text" name="nom" value="" size="20" /></td>

					<td>Prénom patient</td>
					<td><input type="text" name="prenom" value="" size="20" /></td>
					
					<td>Numéro de registre national</td>
					<td><input type="text" name="nrn" value="" size="20" /></td>

					<td></td>
					<td><input type="submit" value="Rechercher" name="Rechercher" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<%
		List<CPatient> ListPatients = null;
		//Récupération de la liste des patients
		if(request.getAttribute("ListPatients") != null){
			ListPatients = (List<CPatient>)request.getAttribute("ListPatients");
		}
		
		
	%>
	<h2>Liste de vos patients</h2>
	<form action="${pageContext.request.contextPath}/GererPatient" method="post">
	<table>
		<tr>
			<th>Prénom</th>
			<th>Nom</th>
			<th>Numéro de registre national</th>
		</tr>
	
	<%
		if(!ListPatients.isEmpty()){
			for (CPatient p : ListPatients) {%>
			<tr>
				<th><%= p.getPrenom() %></th>
				<th><%= p.getNom() %></th>
				<th><%= p.getNrn() %></th>
				<th><button type="submit" value="<%=p.getID_Patient()%>" name="Selectionner">Sélectionner</button>
					<button type="submit" value="<%=p.getID_Patient()%>" name="infoSup">Plus d'info</button></th>
			</tr>
		    <%}}%>
	</table>
	</form>
</body>
</html>