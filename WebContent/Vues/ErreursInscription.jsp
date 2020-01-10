<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%! public String couleur(String s)
{
	return "<font color=red>"+s+"</font>";
}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERREURS LORS DE L'INSCRIPTION</title>
</head>
<body>
<%
ArrayList<String> erreurs=(ArrayList<String>)request.getAttribute("erreurs");
%>
<h2>Les erreurs suivantes se sont produites</h2>
<ul>
    <!--<%
   	 for(String s : erreurs) out.println("<li>"+ couleur(s) +"</li>");   
    %>-->
    <%
     for(int i=0;i<erreurs.size();i++)
     {
    	 %>
 	 	<li><%=couleur(erreurs.get(i))%></li>
 	 	<%
 	 }%>
</ul>
</body>
</html>