<%-- 
    Document   : index
    Created on : 7 dic 2022, 8:47:59
    Author     : Usuario
--%>

<%@page import="com.dam.bibliotecah.Libros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SESSION ID</h1>
        <h2><% out.println(session.getId()); %></h2>
        <%
        String titulo = "Datos del Libro";
        Libros libro = new Libros(1, "Macbeth", "William Shakespeare");
        %>
        <h1><%= titulo %></h1>
        <h1><%= libro.toString() %></h1>
    </body>
</html>
