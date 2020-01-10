<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="be.BiscontiLagneau.JavaBean.CMedicament"%>
<%@ include file="Header/NavBar.jsp"%>
<!DOCTYPE html>
<html>
<%if(request.getSession().getAttribute("medecin") == null){%>
	<meta http-equiv="refresh" content="0; url=<%=application.getContextPath()%>/Vues/Authentification.jsp">
<%}%>
<head>
<style>
#ulM{
width : 40%;
display: inline-block;
}
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
  align : center;
  display: inline-block;
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
<title>Choisir les médicaments</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ChercherMedicament"
		method="POST">
		<table margin="10 px">
			<tbody>
				<tr>
					<td>Nom médicament</td>
					<td><input type="text" name="nom" value="" size="20" /></td>

					<td>Voie d'administration</td>
					<td><input type="text" name="type" value="" size="20" /></td>

					<td></td>
					<td><input type="submit" value="Rechercher" name="Rechercher" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<%
		List<CMedicament> medicaments = null;
		List<String> List_IdMedicament = null;
		//Récupération de la liste des médicaments
		if(request.getAttribute("medicaments") != null){
			medicaments = (List<CMedicament>)request.getAttribute("medicaments");
		}
		//récupération de la liste des médicaments sélectionner
		if(session.getAttribute("List_IdMedicament") != null){
			List_IdMedicament = (ArrayList<String>)session.getAttribute("List_IdMedicament");
		}
		
		
	%>
	<h2>Liste des médicaments</h2>
	<form action="${pageContext.request.contextPath}/ChercherMedicament" method="post">
	<table>
		<tr>
			<th>ID</th>
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
				<th><%= m.getID_Medicament() %></th>
				<th><%= m.getNom() %></th>
				<th><%= m.getType() %></th>
				<th><%= m.getDescription() %></th>
				<th><%= m.getDosage_jour_max() %></th>
				<th><button type="submit" value="<%=m.getID_Medicament()%>" name="Choisir">Choisir</button></th>
			</tr>
		    <%}}%>
	</table>
	</form>
	
	<%
		if (List_IdMedicament != null) {
	%>
	<h2>Les médicaments sélectionnés sont :</h2>
	<ul id="ulM">
		<%
			for (int i = 0; i < List_IdMedicament.size(); i++) {
		%>
		<li> ID : <%=List_IdMedicament.get(i)%></li>
		<%
			}
		%>
	</ul>
	<%
		}
	%>
	<form action="${pageContext.request.contextPath}/ChercherMedicament" method="post">
	<button type="submit" value="Valider" name="Valider">Valider</button>
	</form>
</body>
</html>