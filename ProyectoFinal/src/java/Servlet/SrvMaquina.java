/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin
 */

@WebServlet(name = "SrvMaquina", urlPatterns = { "/SrvMaquina" }) 
public class SrvMaquina extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
         String accion = request.getParameter("accion");
            System.out.println("Accion: "+accion);
        try {
            if (accion != null) {
                switch (accion) {
                    case "Consultar Maquina":
                        consultarMaquina(request, response);
                        break;
                    case "Registrar Maquina":
                        registrarMaquina(request, response);
                    case "Principal Admin":
                        response.sendRedirect("vistas/PrincipalAdmin.jsp");
                        //request.getRequestDispatcher("vistas/PrincipalAdmin.jsp").forward(request, response);
                        break;
                    case "Principal Usuario":
                        response.sendRedirect("vistas/PrincipalUsuario.jsp");
                         //request.getRequestDispatcher("vistas/PrincipalUsuario.jsp").forward(request, response);
                        break;
                    default:
                        System.out.print("Default");
                        response.sendRedirect("http://localhost:8080/ExamenPSW/");
                }
            } else {
                //La accion es null
                response.sendRedirect("inicioSesion.jsp");
            }
        } catch (IOException e) {
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

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SrvMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SrvMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void consultarMaquina(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CLaboratorio laboratorio = new CLaboratorio();
        CMarca marca = new CMarca();
        MCpu cpu = new MCpu();
        MAccesorio accesorio = new MAccesorio();
        MMonitor monitor = new MMonitor();
        MConfiguracion configuracion = new MConfiguracion();

        request.setAttribute("listaLab", laboratorio.getAllLaboratorio());
        request.setAttribute("listaMarca", marca.getAllMarca());
        request.setAttribute("listaCPU", cpu.getAllCpu());
        request.setAttribute("listaAccesorio", accesorio.getAllAccesorio());
        request.setAttribute("listaMonitor", monitor.getAllMonitor());
        request.setAttribute("listaConfiguracion", configuracion.getAllConfiguracion());    

        try {
            System.out.println("Entro a consultar maquina");
            request.getRequestDispatcher("vistas/Agregar/AgregarMaquina.jsp").forward(request, response);
            //response.sendRedirect("vistas/Agregar/AgregarMaquina.jsp");
            //this.getServletConfig().getServletContext().getRequestDispatcher("AgregarMaquina.jsp").forward(request, response);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            Logger.getLogger(SrvMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrarMaquina(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Entro a registrar maquina");

        if (request.getParameter("laboratorio") != null && request.getParameter("marca") != null 
            && request.getParameter("cpu") != null && request.getParameter("accesorio") != null 
            && request.getParameter("monitor") != null && request.getParameter("configuracion") != null) {
            
            DEquipo equipo = new DEquipo();

            equipo.getLaboratorio().setIdLaboratorio(Integer.parseInt(request.getParameter("laboratorio")));
            equipo.getMarca().setIdMarca(Integer.parseInt(request.getParameter("marca")));
            equipo.getCpu().setIdCpu(Integer.parseInt(request.getParameter("cpu")));
            equipo.getAccesorio().setIdAccesorio(Integer.parseInt(request.getParameter("accesorio")));
            equipo.getMonitor().setIdMonitor(Integer.parseInt(request.getParameter("monitor")));
            equipo.getConfiguracion().setIdConfiguracion(Integer.parseInt(request.getParameter("configuracion")));
            equipo.getEdoEquipo().setIdEdoEquipo(1);
            equipo.registrarEquipo(equipo);
            
        }else{
            System.out.println("Algun request es null");
            try {
                response.sendRedirect("SrvMaquina?accion=Consultar Maquina");
            } catch (IOException ex) {
                Logger.getLogger(SrvMaquina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
