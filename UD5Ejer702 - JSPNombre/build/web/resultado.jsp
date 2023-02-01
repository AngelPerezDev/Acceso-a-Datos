<!DOCTYPE html>
<html>
    <head>
        <title>JSP Nombre</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
    </head>
    <body>
        <%
            String rotulo = "";
            rotulo = request.getParameter("nombre").toUpperCase();
            String rotuloConEspacios="";
            for(int i=0; i< rotulo.length(); i++){
            rotuloConEspacios = rotuloConEspacios + rotulo.substring(i,i+1) + " ";
            };
        %>        
        <div class="contenedor">
            <div class="contenedor-form">
                <h1>TU NOMBRE ES</h1>
            </div>
            <div class="contenedor-form">
                <p class="rotulo"><% out.print(rotuloConEspacios);%></p>
            </div>
            <div class="contenedor-form">
                <form id="formulario" name="formulario" action="index.jsp" method="POST" >
                    <input id="btn_submit" name="btn_submit" type="submit" value="Volver" />
                </form>
            </div>
        </div>
    </body>
</html>
