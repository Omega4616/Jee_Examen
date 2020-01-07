<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CMedicament"%>
<%@ include file="Header/NavBar.html"%>
<!DOCTYPE html>
<html>
<head>
<style>
input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=button], input[type=submit], input[type=reset] {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
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
	<form action="${pageContext.request.contextPath}/ChercherMedicament"
		method="POST">
		<table margin="10 px">
			<tbody>
				<tr>
					<td>Nom médicament</td>
					<td><input type="text" name="inami" value="" size="20" /></td>

					<td>Voie d'administration</td>
					<td><input type="text" name="mdp" value="" size="20" /></td>

					<td></td>
					<td><input type="submit" value="Rechercher" name="Rechercher" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<%
		List<CMedicament> medicaments = null;
		List<String> mChoisi = null;
		if(request.getAttribute("medicaments") != null){
			medicaments = (List<CMedicament>)request.getAttribute("medicaments");
		}
		if(request.getAttribute("mChoisi") != null){
			mChoisi = (List<String>)request.getAttribute("mChoisi");
		}
		
		
	%>
	<h2>Liste des médicaments</h2>
	<form action="${pageContext.request.contextPath}/ChercherMedicament" method="post">
	<table>
		<tr>
			<th>Nom</th>
			<th>Type</th>
			<th>Description</th>
			<th>Dosage max/jour</th>
			<th>     </th>
		</tr>
	
	<%
		if(!medicaments.isEmpty()){
			for (CMedicament m : medicaments) {%>
			<tr>
				<th><%= m.getNom() %></th>
				<th><%= m.getType() %></th>
				<th><%= m.getDescription() %></th>
				<th><%= m.getDosage_jour_max() %></th>
				<th><input type="hidden" value="<%=m.getID_Medicament()%>" name="IDMedicament"><input type="submit" value="Choisir" name="Choisir"></th>
			</tr>
		    <%}}%>
	</table>
	</form>
	
	<%
		if(mChoisi != null){ 
		for(String m : mChoisi){
		%>
			<p><%= mChoisi %></p>
		<%}}%>
</body>
</html>