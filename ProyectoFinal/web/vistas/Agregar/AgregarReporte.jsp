<%-- 
    Document   : AgregarReporte
    Created on : 11/06/2022, 07:23:11 PM
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionuok = request.getSession();
    MPersona objUsu = (MPersona) sesionuok.getAttribute("objUsu");
    if(objUsu == null){
        System.out.println("Estoy en el forward de editar materia");
    %>
<jsp:forward page="../SrvReporte?accion=Cerrar Sesion">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    
    <%
        }else{
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ArrayList<EEquiposreportados> listaRep = (ArrayList<EEquiposreportados>) request.getAttribute("listaRep");
        ArrayList<EReportespersona> listaRP = (ArrayList<EReportespersona>) request.getAttribute("listaRP");
        ArrayList<CPrioridad> listaPrioridad = (ArrayList<CPrioridad>) request.getAttribute("listaPrioridad");
        ArrayList<CEstadoreporte> listaReporte = (ArrayList<CEstadoreporte>) request.getAttribute("listaReporte");
        ArrayList<MReporte> listaMReporte = (ArrayList<MReporte>) request.getAttribute("listaMReporte");
        ArrayList<CAsignatura> listaAsignatura = (ArrayList<CAsignatura>) request.getAttribute("listaAsignatura");
    %>
    <div class="main-container">
        <form class="forms"  method="post" name="registro" action="../../SrvReporte?accion=Registrar Maquina" onsubmit="return validarAgregarReporte(this)"> 
           <br>
           
           <div class="entrada">
              
               <label class="lbl"><span class="text">Reportados</span></label>
               <div class="select">
               <select name="reportados" id="reportados">
                   <option selected disabled>Reportados</option>
                   <%
                       for(EEquiposreportados ere : listaRep){
                           
                   %>
                   <option value="<%=ere.getEquiposrepor_id()%>"><%=ere.getEquipo_etiqueta()%></option>

                   <%}%>
               </select>
               
           </div>
           </div>
           
           <br>
          
           <div class="entrada">
               
               <label class="lbl"><span class="text">Reportes Persona</span></label>
               <div class="select">
               <select name="marca" id="marca">
                   <option selected disabled>Marca</option>
                   
                   <%
                       for(CMarca marca : listaMarca){
                       
                   %>
                   <option value="<%=marca.getMarca_id()%>"><%=marca.getMarca_nom()%></option>

                   <%}%>
               </select>
               
           </div>
           </div>
           <br>
           
           
           
           <div class="entrada">
               
               <label class="lbl"><span class="text">CPU Serial</span></label>
               <div class="select">
               <select name="cpu" id="cpu">
                   <option selected disabled>CPU serial</option>
                   <%
                       for(MCpu cpu : listaCPU){
                           
                   %>
                   <option value="<%=cpu.getCpu_serial()%>"><%=cpu.getCpu_descripcion()%></option>

                   <%}%>
               </select>
               
           </div>
           </div>
          <br>
            
           <div class="entrada">
              
               <label class="lbl"><span class="text">Accesorio</span></label>
               <div class="select">
               <select name="accesorio" id="accesorio">
                   <option selected disabled>Accesorios</option>
                   <%
                       for(MAccesorio accesorio : listaAccesorio){
                           
                   %>
                   <option value="<%=accesorio.getAccesorio_id()%>"><%=accesorio.getConfig_descripcionTeclado()%> y <%=accesorio.getConfig_descripcionMause()%></option>

                   <%}%>
               </select>
               
           </div>
           </div>
           <br>
            
           <div class="entrada">
              
               <label class="lbl"><span class="text">Monitor</span></label>
               <div class="select">
               <select name="monitor" id="monitor">
                   <option selected disabled>Monitor</option>
                   <%
                   for(MMonitor monitor : listaMonitor){
                       
               %>
               <option value="<%=monitor.getMonitor_id()%>"><%=monitor.getMonitor_descripcion()%></option>

               <%}%>
               </select>
               
           </div>
           </div>
           <br>
            
           <div class="entrada">
              
               <label class="lbl"><span class="text">Sistema operativo</span></label>
               <div class="select">
               <select name="configuracion" id="configuracion">
                   <option selected disabled>Sistema</option>
                   <%
                               for(MConfiguracion configuracion : listaConfiguracion){
                                   
                           %>
                           <option value="<%=configuracion.getConfig_id()%>"><%=configuracion.getConfig_descripcion()%></option>

                           <%}%>
                   
               </select>
               
           </div>
           </div>
           
          
           <br>
            <div class="row">
               <div class="col">
                   <div class="mb-3"><label class="form-label" for="first_name">
                           <strong style="color:white">Problema</strong><br></label>
                       <textarea class="form-control" name="problema"></textarea>
                   </div>
               </div>
           </div>
           
           <br>
           
           
           
           
           
           <div class="botones">
                             
       <input type="submit" name="guardar"  class="crear" style="width:80px;height:45px; background-color: #DBDFFD; border-radius: 10px; font-size: 15px;" value="Guardar">
       &nbsp &nbsp &nbsp 
       <input type="reset" name="Cancelar" value="Cancelar" style="width:80px;height:45px; background-color: #DBDFFD; border-radius: 10px; font-size: 15px;" >
      
       </div>
          
        
                           
       </form>
      
   </div>
</body>
</html>
                       <textarea class="form-control" name="problema"></textarea>
                   </div>
               </div>
           </div>
           <button class="btn btn-primary btn-sm" id="boton-guardarCambios" type="submit">Registrar Equipo</button>
       </form>
   </div>
    </body>
</html>
