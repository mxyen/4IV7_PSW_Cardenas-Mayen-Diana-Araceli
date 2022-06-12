
<%@page import="Modelo.MPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionuok = request.getSession();
    MPersona objUsu = (MPersona) sesionuok.getAttribute("objUsu");
    if(objUsu == null){
        System.out.println("Estoy en el forward de editar materia");
    %>
    
    <jsp:forward page="../../SrvPersona?accion=Cerrar Sesion">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    
    <%
        }else{
    %>
<!DOCTYPE html>
<html>
    <head>
        <title>Mi perfil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="../../css/docente.css"/>
    </head>
    <body>
         <header class="header">
            <div class="logo-header">
                <img src="../../img/logo.webp" alt=""> 
            </div>
            <nav class="nav-menu">
                <ul>
                    <li><a href="../Perfil/PerfilDocente.jsp">Mi perfil</a></li>
                    <li><a href="../../ConsultarReporte.jsp">Modificar Reportes</a></li>
                    <li><a href="../Principal/PrincipalDocente.jsp">Inicio</a></li>
                    <li><a href="../../SrvPersona?accion=Cerrar Sesion">Cerrar sesión</a></li>
                                    
                </ul>
            </nav>
              
        </header>
        
        <div class="img2">
            <h1>Docente</h1>
            <img src="../../img/usuario.webp" width="300px" height="280px">
        </div>
 
        <div class="info">
                
            <form id ="formulario" action="#" method="post" class="formulario">
                <div class="nombre"><label for="nombre" >Nombre:</label></div>
                    
                    <div class="nombre_input"><input type="text" name="nombre" value="<%= objUsu.getPersona_nombre() %>"></div>
                <div class="apellido"><label for="apellido">Apellido Paterno:</label></div>
                <div class="apellido_input"><input type="text" name="apellido" value="<%= objUsu.getPersona_appat() %>"></div>
                <div class="apellido"><label for="apellido">Apellido Materno:</label></div>
                <div class="apellido_input"><input type="text" name="apellido" value="<%= objUsu.getPersona_apmat() %>"></div>
                <div class="sexo"><label for="sexo">Sexo</label></div>
                <div class="sexo_input"><input type="text" name="sexo" value="<%= objUsu.getPersona_sexo() %>"></div>
                <div class="fechaNac"><label for="fechaNac">Fecha de nacimiento</label></div>
                <div class="fechaNac_input"><input type="text" name="fechaNac" value="<%= objUsu.getPersona_fechaNacimiento() %>"></div>
                <div class="user"><label for="user">User</label></div>
                <div class="user_input"><input type="text" name="user" value="<%= objUsu.getPersona_user() %>"></div>
                <div class="pass"><label for="pass">Pass</label></div>
                <div class="pass_input"><input type="text" name="pass" value="<%= objUsu.getPersona_pass() %>"></div>
                <div class="numEmp"><label for="numEmp">Num Empleado</label></div>
                <div class="numEmp_input"><input type="text" name="numEmp" value="<%= objUsu.getEmpleado_num() %>"></div>

                <input type="submit" value="Editar Perfil">
            </form>
        </div>
    </body>
</html>
<%
    }
%>