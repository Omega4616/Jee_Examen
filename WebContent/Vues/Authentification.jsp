<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="Header/NavBar.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification Médecin</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/AuthentificationMedecin"
		method="POST">
		<table border="0">
			<tbody>
				<tr>
					<td>Numéro inami</td>
					<td><input type="text" name="inami" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Mot de passe</td>
					<td><input type="text" name="mdp" value="" size="20" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Connexion" name="Connexion" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<%
	ArrayList<String> erreurs = null;
	if(request.getAttribute("erreurs") != null)
		erreurs = (ArrayList<String>) request.getAttribute("erreurs");
	%>
	<%
		if (erreurs != null) {
	%>
	<h2>Les erreurs suivantes se sont produites</h2>
	<ul>
		<%
			for (int i = 0; i < erreurs.size(); i++) {
		%>
		<li><%=erreurs.get(i)%></li>
		<%
			}
		%>
	</ul>
	<%
		}
	%>
</body>
</html>