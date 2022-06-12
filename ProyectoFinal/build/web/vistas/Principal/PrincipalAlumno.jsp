<%-- 
    Document   : PrincipalAlumno
    Created on : 9/06/2022, 05:38:30 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Principal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../../css/indexstyle.css"/>
         <link rel="shortcut icon" href="../../img/logo.webp" />
    </head>
   
    <body>
        <header class="header">
            <div class="logo-header">
                <img src="img/logo.webp" alt=""> 
            </div>
            <nav class="nav-menu">
                <ul>
                    <li><a href="../Perfil/PerfilAlumno.jsp">Mi perfil</a></li>
                    <li><a href="../Agregar/AgregarMaquina.jsp">Agregar Maquina</a></li>
                    <li><a href="../../ConsultarReporte.jsp">Agregar Reportes</a></li>
                    <li><a href="../Principal/PrincipalAlumno.jsp">Inicio</a></li>
                    <li><a href="../../SrvPersona?accion=Cerrar Sesion">Cerrar sesión</a></li>
                    
                                    
                </ul>
            </nav>
              
        </header>
        
        <div class="img2">
            <br>
            <img src="../../img/edifcecyt.jpg" width="100%">   
                     
        </div>
        
        <div class="img">
            <img src="../../img/labs.png" width="50%">   
                         
        </div>
        
        <h1>Bitacora</h1>
        <div id="bitacora-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Etiqueta</th>
                        <th>Usuario que reportó</th>
                        <th>Docente</th>
                        <th>Prioridad</th>
                        <th>Estado</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Responsable de la Atencion al reporte</th>
                        <th>Consultar Equipo</th> 
                     </tr>
               </thead>
               
               <tr>
                    <td>1</td>
                    <td>LB045</td>
                    <td>Diana</td>
                    <td>Jaime</td>
                    <td>Alta</td>
                    <td>Pendiente</td>
                    <td>25/11/2021</td>
                    <td>9:54 am</td>
                    <td>Luis</td>
                    <td><a href="ConsultarEquipo.jsp">Consultar</a></td>
                    
               </tr>
               
                <tr>
                      <td>2</td>
                      <td>LB045</td>
                      <td>Diana</td>
                      <td>Jaime</td>
                      <td>Alta</td>
                      <td>Pendiente</td>
                      <td>25/11/2021</td>
                      <td>9:54 am</td>
                      <td>Luis</td>
                      <td><a href="ConsultarEquipo.jsp">Consultar</a></td>
                </tr>
                <tr>
                      <td>3</td>
                      <td>LB045</td>
                      <td>Diana</td>
                      <td>Jaime</td>
                      <td>Alta</td>
                      <td>Pendiente</td>
                      <td>25/11/2021</td>
                      <td>9:54 am</td>
                      <td>Luis</td>
                      <td><a href="ConsultarEquipo.jsp">Consultar</a></td>
                </tr>
                <tr>
                      <td>4</td>
                      <td>LB045</td>
                      <td>Diana</td>
                      <td>Jaime</td>
                      <td>Alta</td>
                      <td>Pendiente</td>
                      <td>25/11/2021</td>
                      <td>9:54 am</td>
                      <td>Luis</td>
                      <td><a href="ConsultarEquipo.jsp">Consultar</a></td>
                </tr>
                <tr>
                      <td>5</td>
                      <td>LB045</td>
                      <td>Diana</td>
                      <td>Jaime</td>
                      <td>Alta</td>
                      <td>Pendiente</td>
                      <td>25/11/2021</td>
                      <td>9:54 am</td>
                      <td>Luis</td>
                      <td><a href="ConsultarEquipo.jsp">Consultar</a></td>
                </tr>
    
            </table>
             
           
        </div>
        <br>
        <br>
        <br>
       
    </body>
</html>

