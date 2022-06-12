/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import Control.Conexion;

public class DEquipo {
    private String equipo_etiqueta;
    private String problema;
    
    private CLaboratorio laboratorio;
    private CMarca marca;
    private MCpu cpu;
    private MAccesorio accesorio;
    private MMonitor monitor;
    private MConfiguracion config;
    private CEdoequipo edoEquipo;

    public DEquipo() {
        equipo_etiqueta = "";
        problema = "";
        laboratorio = new CLaboratorio();

    }
    public  int registrarEquipo(DEquipo e){
        int estatus = 0, estatus2 = 0;
        
        try{
            Connection con = Conexion.getConecction();
            String q = "insert into dequipo (equipo_etiqueta, lab_id, marca_id, cpu_serial, "
                    + "accesorio_id, monitor_id, config_id, edoEquipo_id, problema) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getEquipo_etiqueta());
            ps.setInt(2, e.getLaboratorio().getLab_id());
            ps.setInt(3, e.getMarca().getMarca_id());
            ps.setString(4, e.getCpu().getCpu_serial());
            ps.setInt(5, e.getAccesorio().getAccesorio_id());
            ps.setString(6, e.getMonitor().getMonitor_id());
            ps.setString(7, e.getConfig().getConfig_id());
            ps.setInt(8, e.getEdoEquipo().getEdoEquipo_id());
            ps.setString(9, e.getProblema());
            
            estatus = ps.executeUpdate();
            
            try{
                String q2 = "insert into eequiposreportados (equipo_etiqueta) " 
                    + "values (?)";
                
                PreparedStatement ps2 = con.prepareStatement(q2);
                
                ps2.setString(1, e.getEquipo_etiqueta());
                
                estatus2 = ps2.executeUpdate();
                
                System.out.println("Todo bien eequiposreportados");
            }catch(Exception exe){
                System.out.println("Error 2");
                System.out.println(exe.getMessage());
            }
            
            System.out.println("Registro exitoso");
            con.close();
        }catch(Exception ex){
            System.out.println("Error al registrar equipo");
            System.out.println(ex.getMessage());
        }
        return estatus;
    }

    public static int actualizarEquipo(DEquipo e, int idActual){
        int estatus = 0;
        
        try{
            Connection con = Conexion.getConecction();
            
            String q = "update dequipo set equipo_etiqueta = ?, lab_id = ?, marca_id = ?, "
                    + "cpu_serial = ?, accesorio_id = ?, monitor_id = ?, config_id = ?, "
                    + "edoEquipo_id = ?, problema = ? "
                    + "where equipo_etiqueta = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getEquipo_etiqueta());
            ps.setInt(2, e.getLaboratorio().getLab_id());
            ps.setInt(3, e.getMarca().getMarca_id());
            ps.setString(4, e.getCpu().getCpu_serial());
            ps.setInt(5, e.getAccesorio().getAccesorio_id());
            ps.setString(6, e.getMonitor().getMonitor_id());
            ps.setString(7, e.getConfig().getConfig_id());
            ps.setInt(8, e.getEdoEquipo().getEdoEquipo_id());
            ps.setString(9, e.getProblema());
            ps.setInt(10, idActual);
            
            estatus = ps.executeUpdate();

            System.out.println("Se actualizo el equipo");
            con.close();
                      
        }catch(Exception ex){
            System.out.println("Error al actualizar equipo");
            System.out.println(ex.getMessage());
        }      
        return estatus;    
    }

    public String getEquipo_etiqueta() {
        return equipo_etiqueta;
    }

    public void setEquipo_etiqueta(String equipo_etiqueta) {
        this.equipo_etiqueta = equipo_etiqueta;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public CLaboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(CLaboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public CMarca getMarca() {
        return marca;
    }

    public void setMarca(CMarca marca) {
        this.marca = marca;
    }

    public MCpu getCpu() {
        return cpu;
    }

    public void setCpu(MCpu cpu) {
        this.cpu = cpu;
    }

    public MAccesorio getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(MAccesorio accesorio) {
        this.accesorio = accesorio;
    }

    public MMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(MMonitor monitor) {
        this.monitor = monitor;
    }

    public MConfiguracion getConfig() {
        return config;
    }

    public void setConfig(MConfiguracion config) {
        this.config = config;
    }

    public CEdoequipo getEdoEquipo() {
        return edoEquipo;
    }

    public void setEdoEquipo(CEdoequipo edoEquipo) {
        this.edoEquipo = edoEquipo;
    }
}
