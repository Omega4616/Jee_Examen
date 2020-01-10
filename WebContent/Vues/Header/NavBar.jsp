<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

<div class="topnav">
<%if(request.getSession().getAttribute("medecin") == null){%>
	  <a class="active" href="<%=application.getContextPath()%>/Vues/Accueil.jsp">Accueil</a>
	  <a href="<%=application.getContextPath()%>/Vues/Authentification.jsp" >Connexion</a>
	  <a href="#contact">Inscription</a>
<%}
else{%>
	  <a class="active" href="<%=application.getContextPath()%>/Vues/Accueil.jsp">Accueil</a>
	  <a href="<%=application.getContextPath()%>/Deconnexion" >Déconnexion</a>
	  <a href="<%=application.getContextPath()%>/GererPatient" >Liste des patients</a>
<%}%>
  
  
</div>


</body>
</html>