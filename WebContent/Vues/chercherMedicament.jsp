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
</style>
<meta charset="ISO-8859-1">
<title>Recherche d'un médicament</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/ChercherMedicament"
		method="POST">
		<table margin="10 px">
			<tbody>
				<tr>
					<td>Nom médicament </td>
					<td><input type="text" name="inami" value="" size="20" /></td>

					<td>Voie d'administration </td>
					<td><input type="text" name="mdp" value="" size="20" /></td>

					<td></td>
					<td><input type="submit" value="Rechercher" name="Rechercher" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<%
		@SuppressWarnings("unchecked")
		List<CMedicament> medicaments = (List<CMedicament>)request.getAttribute("medicaments");
		
	%>
	<h2>Liste des médicaments</h2>
	<ul>
		<%
		if(!medicaments.isEmpty()){
			for (CMedicament m : medicaments)
				out.println("<li>" + m.getID_Medicament() + " | Nom : " + m.getNom() + " | Description : " + m.getDescription() + " | Type :  " + m.getType() + " | Posologie : " + m.getDosage_jour_max() + "</li>");
		}
			
		%>
	</ul>
</body>
</html>