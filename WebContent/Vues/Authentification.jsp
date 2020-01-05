<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header/NavBar.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification Médecin</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AuthentificationMedecin" method="POST">
		<table border="0">
			<tbody>
				<tr>
					<td>Numéro inami </td>
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
</body>
</html>