/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.MPersona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "SrvPersona", urlPatterns = { "/SrvPersona" })
public class SrvPersona extends HttpServlet {

    private MPersona usuario = new MPersona();
    private MPersona registroUsu = new MPersona();
    private HttpSession sesionuok;
    private HttpSession sesionNoOK;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        {
            String accion = request.getParameter("accion");
            System.out.println("Accion: "+accion);
        try {
            if (accion != null) {
                switch (accion) {
                    case "Iniciar Sesion":
                        iniciarSesion(request, response);
                        break;
                    case "Cerrar Sesion":
                        cerrarSession(request, response);
                    case "Principal Admin":
                        response.sendRedirect("vistas/PrincipalAdmin.jsp");
                        //request.getRequestDispatcher("vistas/PrincipalAdmin.jsp").forward(request, response);
                        break;
                    case "Principal Usuario":
                        response.sendRedirect("vistas/PrincipalUsuario.jsp");
                         //request.getRequestDispatcher("vistas/PrincipalUsuario.jsp").forward(request, response);
                        break;
                    case "Mostrar Perfil":
                        //mostrarPerfil(request, response);
                        break;
                    case "Editar Perfil":
                        //editarPerfil(request, response);
                        break;
                    case "Registrar Persona":
                        registrarPersona(request, response);
                        break;
                    case "Validar Inteligencia":
                        //validarInt(request, response);
                        break;
                    case "leerUsuario":
//                        presentarUsuario(request, response);
                        break;
                    case "Actualizar Persona":
//                        actualizarUsuario(request, response);
                        break;
                    case "Eliminar Persona":
                            //eliminarPersona(request, response);
                        break;
                    default:
                        System.out.print("Default");
                        response.sendRedirect("http://localhost:8080/ExamenPSW/");
                }
            } else {
                //La accion es null
                response.sendRedirect("inicioSesion.jsp");
            }
        } catch (Exception e) {
            try {
                System.out.println("Menu Error e: " + e.getMessage());
                response.sendRedirect("http://localhost:8080/ExamenPSW/");
                //this.getServletConfig().getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

            } catch (IOException ex) {
                System.out.println("Menu Error ex: " + ex.getMessage());
                response.sendRedirect("../Error.jsp");
            }
        }
        
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.F
     *
     * @return a String containing servlet description
     */
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ClassNotFoundException, ServletException {
        String user, pass;
        user = request.getParameter("usuario");
        pass = request.getParameter("password");

        System.out.println(user);
        System.out.println(pass);

        request.setAttribute("msje", "Esperando datos...");
        usuario = usuario.verificarUsuario(user, pass);

        if (usuario != null) {
            /*
             * que el usuario si existe en la bd
             * creamos la sesion de ese usuario
             */
            sesionuok = request.getSession(true);
            sesionuok.setAttribute("objUsu", usuario);

            if ("Alumno".equals(usuario.getRol().getRol_tipo())) {
                // Alumno
                response.sendRedirect("vistas/Principal/PrincipalAlumno.jsp");
            } else if ("Docente".equals(usuario.getRol().getRol_tipo())){
                // Docente
                response.sendRedirect("vistas/Principal/PrincipalDocente.jsp");
            }
        } else {
            // el usuario no existe o la clave es incorrecta
            usuario = new MPersona();

            user += " no se encontro en la BD";
            // request.setAttribute("usuario", user);

            System.out.println("Credenciales Incorrectas\n");
            request.setAttribute("msje", "Credenciales Incorrectas, " + user);

            request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
            // response.sendRedirect("inicioSesion.jsp");
        }
    }

    private void cerrarSession(HttpServletRequest request, HttpServletResponse response) {
        try {
            sesionuok = request.getSession();
            sesionuok.removeAttribute("objUsu");

            sesionuok.invalidate();
            sesionuok.invalidate();
            response.sendRedirect("http://localhost:8080/ExamenPSW/");
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    }

    private void registrarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, Exception, NullPointerException {
        
        // System.out.println("usuario: " +request.getParameter("usuario"));
        // System.out.println("password: " +request.getParameter("password"));
        // System.out.println("nombre: " +request.getParameter("nombre"));
        // System.out.println("appat: " +request.getParameter("appat"));
        // System.out.println("apmat: " +request.getParameter("apmat"));
        // System.out.println("sexo: " +request.getParameter("sexo"));
        // System.out.println("fecha: " +request.getParameter("fecha"));
        // System.out.println("rol: " +request.getParameter("rol"));
        // System.out.println("privilegio: " +request.getParameter("privilegio"));
        // System.out.println("numEmpleado: " +request.getParameter("numEmpleado"));
        // System.out.println("boleta: " +request.getParameter("boleta"));
        // System.out.println("grupo: " +request.getParameter("grupo"));
        
        //Eres alumno
        if(request.getParameter("rol").equals("1")){
            System.out.println("Entre a registrar alumno");

            //Validar los datos del formulario
            if (request.getParameter("usuario") != null && request.getParameter("password") != null 
            && request.getParameter("nombre") != null 
            && request.getParameter("appat") != null && request.getParameter("apmat") != null 
            && request.getParameter("fecha") != null && request.getParameter("sexo") != null 
            && request.getParameter("rol") != null && request.getParameter("privilegio") != null
            && request.getParameter("boleta") != null && request.getParameter("grupo") != null) {

                registroUsu.setPersona_user(request.getParameter("usuario"));
                registroUsu.setPersona_pass(request.getParameter("password"));
                registroUsu.setPersona_nombre(request.getParameter("nombre"));
                
                registroUsu.setPersona_appat(request.getParameter("appat"));
                registroUsu.setPersona_apmat(request.getParameter("apmat"));
                registroUsu.setPersona_sexo(request.getParameter("sexo"));
                registroUsu.setPersona_fechaNacimiento(request.getParameter("fecha"));
                
                registroUsu.getRol().setRol_id(Integer.parseInt(request.getParameter("rol")));
                registroUsu.getPrivilegio().setPrivilegio_id(Integer.parseInt(request.getParameter("privilegio")));
                registroUsu.setAlumno_boleta(Integer.parseInt(request.getParameter("boleta")));
                registroUsu.getGrupo().setGrupo_id(Integer.parseInt(request.getParameter("grupo")));
                
                System.out.println(registroUsu.verificarSiExiste(registroUsu.getPersona_user()) );
                if(registroUsu.verificarSiExiste(registroUsu.getPersona_user()) == false){
                    registroUsu.registrarPersona(registroUsu);
                    try {
                        System.out.println("Antes de registrar");
                        response.sendRedirect("InicioSesion.jsp");
                    } catch (IOException e) {
                        // request.setAttribute("usuario", usu);
                        System.out.println("Error al registrar: " + e.getCause());
                        System.out.println("Registrar Exception e " + e.getMessage());  
                        
                    }
                }
                else{
                    System.out.println("El alumno ya existe");
                    request.setAttribute("msje", "El usuario ya existe");
                    //response.sendRedirect("RegistrarUsuario.jsp");
                    request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
                }
            } else {

                System.out.println("Todos los request de son null");
                response.sendRedirect("RegistrarUsuario.jsp");
            }
        }

        //Eres docente
        if(request.getParameter("rol").equals("2")){
            System.out.println("Entre a registrar docente");
            if (request.getParameter("usuario") != null && request.getParameter("password") != null 
            && request.getParameter("nombre") != null 
            && request.getParameter("appat") != null && request.getParameter("appmat") != null 
            && request.getParameter("fecha") != null && request.getParameter("sexo") != null 
            && request.getParameter("rol") != null && request.getParameter("privilegio") != null
            && request.getParameter("numEmpleado") != null) {

                registroUsu.setPersona_user(request.getParameter("usuario"));
                registroUsu.setPersona_pass(request.getParameter("password"));
                registroUsu.setPersona_nombre(request.getParameter("nombre"));
                
                registroUsu.setPersona_appat(request.getParameter("appat"));
                registroUsu.setPersona_apmat(request.getParameter("appmat"));
                registroUsu.setPersona_sexo(request.getParameter("sexo"));
                registroUsu.setPersona_fechaNacimiento(request.getParameter("fecha"));
                
                registroUsu.getRol().setRol_id(Integer.parseInt(request.getParameter("rol")));
                registroUsu.getPrivilegio().setPrivilegio_id(Integer.parseInt(request.getParameter("privilegio")));
                registroUsu.setEmpleado_num(Integer.parseInt(request.getParameter("numEmpleado")));
                

                if(registroUsu.verificarUsuario(registroUsu.getPersona_user(), registroUsu.getPersona_pass()) == null){
                    registroUsu.registrarPersona(registroUsu);
                    response.sendRedirect("InicioSesion.jsp");
                }
                else{
                    //response.sendRedirect("../index.html");
                    request.setAttribute("msje", "El usuario ya existe");
                    request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
                }

            } else {
                System.out.println("Todos los request de son null");
                 response.sendRedirect("RegistrarUsuario.jsp");
        }
    }
    }
}