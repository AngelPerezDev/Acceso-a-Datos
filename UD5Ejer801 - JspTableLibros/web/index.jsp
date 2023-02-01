<%-- 
    Document   : index
    Created on : 6 dic 2022, 4:10:56
    Author     : ANGEL PEREZ
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.Libros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Libros> datos = new ArrayList<Libros>();
            Libros registro;
            registro = new Libros();
            registro.setId(1);
            registro.setTitulo("Macbeth");
            registro.setAutor("William Shakespeare");
            datos.add(registro);
            registro = new Libros();
            registro.setId(2);
            registro.setTitulo("La Celestina (Tragicomedia de Calisto y Melibea)");
            registro.setAutor("Fernando de Rojas");
            datos.add(registro);
            registro = new Libros();
            registro.setId(3);
            registro.setTitulo("El Lazarillo de Tormes");
            registro.setAutor("Anónimo");
            datos.add(registro);
            registro = new Libros();
            registro.setId(4);
            registro.setTitulo("20.000 Leguas de Viaje Submarino");
            registro.setAutor("Julio Verne");
            datos.add(registro);
            registro = new Libros();
            registro.setId(5);
            registro.setTitulo("Alicia en el País de las Maravillas");
            registro.setAutor("Lewis Carrol");
            datos.add(registro);
            registro = new Libros();
            registro.setId(6);
            registro.setTitulo("Cien Años de Soledad");
            registro.setAutor("Gabriel García Márquez");
            datos.add(registro);
            registro = new Libros();
            registro.setId(7);
            registro.setTitulo("La tempestad");
            registro.setAutor("William Shakespeare");
            datos.add(registro);
        %>
        <div>
            <p>Número de registros: <%= datos.size() %></p>
        </div>
        <% if (datos.size()>0) { %>
        <table border="1" style="border-collapse:collapse">
            <thead style="background-color:orange">
                <tr>
                    <td>ID LIBRO</td>
                    <td>TÍTULO</td>
                    <td>AUTOR</td>
                </tr>
            </thead>
            <tbody>
                <%
                for (int i=0; i<datos.size(); i++) {
                %>
                <tr>
                    <td><% out.println(datos.get(i).getId()); %></td>
                    <td><% out.println(datos.get(i).getTitulo()); %></td>
                    <td><% out.println(datos.get(i).getAutor()); %></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <%
        } else {
        %>
        <div>
            <p>No hay datos que mostrar</p>
        </div>
        <%
        }
        %>
    </body>
</html>
