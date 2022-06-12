
<%@page import="Modelo.MPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionuok = request.getSession();
    MPersona objUsu = (MPersona) sesionuok.getAttribute("objUsu");
    if(objUsu == null){
        System.out.println("Estoy en el forward de editar materia");
    %>
    
    <jsp:forward page="../SrvPersona?accion=Cerrar Sesion">
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
         <link rel="stylesheet" href="css/alumno.css"/>
    </head>
    <body>
         <header class="header">
            <div class="logo-header">
                <img src="img/logo.webp" alt=""> 
            </div>
            <nav class="nav-menu">
                <ul>
                    <li><a href="../Perfil/PerfilAlumno.jsp">Mi perfil</a></li>
                    <li><a href="../../ConsultarReporte.jsp">Modificar Reportes</a></li>
                    <li><a href="../../index.html">Inicio</a></li>
                    <li><a href="../../SrvPersona?accion=Cerrar Sesion">Cerrar sesión</a></li>
                                    
                </ul>
            </nav>
              
        </header>
        
        <div class="img2">
            <h1>Docente</h1>
            <img src="../../img/usuario.webp" width="300px" height="280px">
        </div>
        
        <ul>
            <li>
                <a href="google.com"></a>
            </li>
             <li>
                <a href="google.com"></a>
            </li>
        </ul>
        <div class="info">
            <form action="" method="post">
                <label for="">Nombre:</label>
                <input type="text" name="nombre" value="<%= objUsu.getPersona_nombre() %>">
                <label for="">Apellido Paterno:</label>
                <input type="text" name="apellido" value="<%= objUsu.getPersona_appat() %>">
                <label for="">Apellido Materno:</label>
                <input type="text" name="apellido" value="<%= objUsu.getPersona_apmat() %>">
                <label for="">Sexo</label>
                <input type="text" name="sexo" value="<%= objUsu.getPersona_sexo() %>">
                <label for="">Fecha de nacimiento</label>
                <input type="text" name="fechaNac" value="<%= objUsu.getPersona_fechaNacimiento() %>">
                <label for="">User</label>
                <input type="text" name="user" value="<%= objUsu.getPersona_user() %>">
                <label for="">Pass</label>
                <input type="text" name="pass" value="<%= objUsu.getPersona_pass() %>">
                <label for="">Boleta</label>
                <input type="text" name="numEmp" value="<%= objUsu.getAlumno_boleta() %>">
                
                <input type="submit" value="Editar Perfil">

            </form>
            
        </div>
        
           
        
        
        
     
    </body>
</html>
<%
    }
%>