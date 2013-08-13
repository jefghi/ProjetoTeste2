<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Ghisius Web System - Alpha Version</title>
<link rel="stylesheet" href="css/style.css" /> 
</head>
<%@ page import="model.Materiais" %>
<%@ page import="dao.MaterialDao" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%
  String nome = "Bem vindo " + session.getAttribute("Booksite_nome");   
%>

<body>
 <div id="bar">
   <div id="container">
      <div id="UserNameHeader" >
		<font><%=nome%></font>			
      </div>      
   </div>
 </div> 
 <div id="ListagemMateriais">
   <table border="1" >
      <tr bgcolor="gray">
		<th>Código do Material</th>      
		<th>Código do Idioma</th>
		<th>Código do tipo do Material</th>
		<th>Título</th>
		<th>Subtítulo</th>
		<th>Descrição</th>
      </tr>
      <%
      MaterialDao dao = new MaterialDao();
  	  
      List<Materiais> materiais = dao.getList();           
      
      for (Materiais material : materiais) {
    	  %> 
    	  <tr>
    	    <td>
    	  <%     	  
    	  out.println(material.getCodMaterial());
          %> </td><td> <% 
    	  out.println(material.getCodIdioma());
    	  %> </td><td> <%    	  
    	  out.println(material.getCodTipoMaterial());
    	  %> </td><td> <%
    	  out.println(material.getTitulo());
    	  %> </td><td> <%
    	  out.println(material.getSubtitulo());
    	  %> </td><td> <%
    	  out.println(material.getDescricao());
    	  %> </td> </tr><%
      %>
      
      <%
      }
	%>
   </table>
 </div>
</body>
</html>