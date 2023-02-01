<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Nombre</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
    </head>
    <body>
        <div class="contenedor">
            <form id="formulario" name="formulario" action="resultado.jsp" method="POST" >
                <div class="contenedor-form">
                    <h1>ESCRIBE TU NOMBRE</h1>
                </div>
                <div class="contenedor-form">
                    <label for="nombre">NOMBRE</label><br>
                    <input id="nombre" name="nombre" type="text" />
                </div>
                <div class="contenedor-form">
                    <input id="btn_submit" name="btn_submit" type="submit" value="Mostrar" />
                </div>
            </form>
        </div>
    </body>
</html>
