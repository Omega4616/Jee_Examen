<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%! public String couleur(String s)
{
	return "<font color=red>"+s+"</font>";
}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de connexion</title>
</head>
<body>
	<form action="connexion" method="POST">
			<table border="1" cellspacing="0" cellpadding="5">
				<tr>
				    <td>N° Inami : </td>
				    <td><input type="text" name="inami" id="inami"
					value="" size="20"/></td>
				</tr>
				<tr>
				    <td>Mot de passe : </td>
				    <td><input type="text" name="mdp" id="mdp"
					value="" size="20"/></td>
				</tr>
				<tr>
				    <td colspan="2" align="center"><input type="submit"
					name="valider" id="valider" value="Valider"/></td>
				</tr>
			</table>
		</form>
<%
ArrayList<String> erreurs=(ArrayList<String>)request.getAttribute("erreurs");
%>
<%if(erreurs.size() == 0)
	{%>
		<h2>Les erreurs suivantes se sont produites</h2>
<ul>
    <%
     for(int i=0;i<erreurs.size();i++)
     {
    	 %>
 	 	<li><%=couleur(erreurs.get(i))%></li>
 	 	<%
 	 }%>
</ul>
	<%
	}
	%>
</body>
</html>