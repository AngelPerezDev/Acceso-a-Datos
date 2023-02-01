<%-- 
    Document   : index
    Created on : 6 dic 2022, 2:08:01
    Author     : ANGEL PEREZ ROJAS
--%>
<%@page import="java.util.concurrent.ThreadLocalRandom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/estilo.css" type="text/css">
        <title>ANGEL PEREZ ROJAS</title>
    </head>
    <body>
        <h1>Tabla de 100 letras aleatorias</h1>
        <%
        char[][] matriz = new char[10][10];
        // Carga de datos
        for (int i=0; i<10; i++) {
        for (int j=0; j<10; j++) {
        // Número entre el 65 y 90 -> 27 números posiblea
        int randomNum = ThreadLocalRandom.current().nextInt(65, 91);
        matriz[i][j]=(char) randomNum;
        }
        }
        // Mostrar matriz
        %>
        <table border="1">
            <tr>
                <td class="cabecera"></td>
                <% for (int i=0; i<10; i++) { %>
                <td class="cabecera"><%= i %></td>
                <% } %>
            </tr>            
            <% for (int i=0; i<10; i++) { %>
            <tr>
                <td class="cabecera"><%= i %></td>
                <% for (int j=0; j<10; j++) { %>
                <td><%= matriz[i][j] %></td>
                <% } %>
            </tr>
            <% } %>

        </table>
    </body>
</html>
