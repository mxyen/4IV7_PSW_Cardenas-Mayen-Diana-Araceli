<%@page import="Modelo.MPersona" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Other/html.html to edit this template
-->
<html>
    
    <head>
            <title>Iniciar sesión</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/iniciarsesion.css" />
    </head>
    

    <body>
        <form action="SrvPersona?accion=Iniciar Sesion" method="POST">
            <section class="form-login">
                <h5>Iniciar sesión</h5>
                <input class="controls" type="text" name="usuario" value="" placeholder="Usuario">
                <input class="controls" type="password" name="password" value="" placeholder="Contraseña">
                <input class="buttons" type="submit" name="" value="Ingresar">
                <p><a href="RegistrarUsuario.jsp">¿No tienes cuenta?</a></p>
                <br>

                <p>- Verificación Credenciales -</p>
                <br>
                <p>Mensaje: ${msje}                
            </section>
            <br>
            <center><a class="link" href="index.html" style="color:white">Volver</a></center>
            <br>
        </form>
    </body>

</html>