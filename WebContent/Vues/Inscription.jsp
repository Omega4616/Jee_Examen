<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ include file="Header/NavBar.jsp"%>
    <%! public String couleur(String s)
{
	return "<font color=red>"+s+"</font>";
}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'inscription</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/InscriptionMedecin" method="POST">
		<table border="0">
			<tbody>
				<tr>
					<td>Numéro inami </td>
					<td><input required type="text" name="inami" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Mot de passe</td>
					<td><input required type="text" name="mdp1" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Confirmation mot de passe </td>
					<td><input required type="text" name="mdp2" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Nom</td>
					<td><input required type="text" name="nom" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Prénom</td>
					<td><input required type="text" name="prenom" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Sexe</td>
					<td><input type="radio" required name="genre" value="Homme">Homme
					<input type="radio" name="genre" value="Femme">Femme</td>
				</tr>
				<tr>
					<td>Adresse</td>
					<td><input required type="text" name="adresse" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Adresse cabinet</td>
					<td><input required type="text" name="adresseCabinet" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Téléphone</td>
					<td><input required type="text" name="telephone" value="" size="20" /></td>
				</tr>
				<tr>
					<td>Spécialisation</td>
					<td><input type="radio" required name="spe" value="Cardiologie">Cardiologie
					<input type="radio" name="spe" value="Generale">Générale
					<input type="radio" name="spe" value="Pneumologie">Pneumologie
					<input type="radio" name="spe" value="Neurologie">Neurologie
					<input type="radio" name="spe" value="Ophtalmologie">Ophtalmologie
					<input type="radio" name="spe" value="Psychiatre">Psychiatre
					<input type="radio" name="spe" value="Psychiatre">Dermatologie
					<input type="radio" name="spe" value="Gynecologie">Gynécologie</td>
				</tr>				
				<tr>
					<td>Date naissance (jj/mm/aaaa)</td>
					<td><input required type="text" name="naissanceJ" value="" size="4" />/<input required type="text" name="naissanceM" value="" size="4" />/<input required type="text" name="naissanceA" value="" size="4" /></td>
				</tr>
				<tr>
					<td>Date obtention diplôme (jj/mm/aaaa)</td>
					<td><input required type="text" name="diplomeJ" value="" size="4" />/<input required type="text" name="diplomeM" value="" size="4" />/<input required type="text" name="diplomeA" value="" size="4" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Inscription" name="inscription" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>