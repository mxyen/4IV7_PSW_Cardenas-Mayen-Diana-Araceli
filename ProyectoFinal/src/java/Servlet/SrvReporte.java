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

@WebServlet(name = "SrvReporte", urlPatterns = { "/SrvReporte" }) 
public class SrvReporte extends HttpServlet {

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
                    case "Consultar Reporte":
                        consultarReporte(request, response);
                        break;
                    case "Registrar Reporte":
                        registrarReporte(request, response);
                    
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
            Logger.getLogger(SrvReporte.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SrvReporte.class.getName()).log(Level.SEVERE, null, ex);
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

    private void consultarReporte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EEquiposreportados reportados = new EEquiposreportados();
        EReportespersona rpersona= new EReportespersona();
        CPrioridad prioridad = new CPrioridad();
        CEstadoreporte reporte = new CEstadoreporte();
        MReporte mreporte= new MReporte();
        CAsignatura asignatura = new CAsignatura();

        System.out.println(reportados.getAllReportados());
        System.out.println(rpersona.getAllRpersona());
        System.out.println(prioridad.getAllPrioridad());
        System.out.println(reporte.getAllReporte());
        System.out.println(mreporte.getAllMreporte());
        System.out.println(asignatura.getAllAsignatura());

        request.setAttribute("listaRep", reportados.getAllReportados());
        request.setAttribute("listaRP", rpersona.getAllRpersona());
        request.setAttribute("listaPrioridad", prioridad.getAllPrioridad());
        request.setAttribute("listaReporte", reporte.getAllReporte());
        request.setAttribute("listaMReporte", mreporte.getAllMreporte());
        request.setAttribute("listaAsignatura", asignatura.getAllAsignatura());    

        try {
            //response.sendRedirect("vistas/Principal/PrincipalDocente.jsp");
            request.getRequestDispatcher("vistas/Agregar/AgregarReporte.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(SrvReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrarReporte(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
