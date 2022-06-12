/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.*;

/**
 *
 * @author cerna
 */
public class DReporte {
    private int detalleReporte_id;
    private String detalleReporte_fecha;
    private String detalleReporte_hora;
    private EEquiposreportados equiposRepor_id;
    private EReportespersona reportePer_id;
    private CPrioridad prioridad_id;
    private CEstadoreporte edoRe_id;
    private MReporte maestraReporte_id;
    private CAsignatura asignatura_id;
    
    public DReporte(){
        detalleReporte_id=0;
        detalleReporte_fecha="";
        detalleReporte_hora="";
        
        equiposRepor_id= new EEquiposreportados();
        reportePer_id= new EReportespersona();
        prioridad_id= new CPrioridad();
        edoRe_id= new CEstadoreporte();
        maestraReporte_id= new MReporte();
        asignatura_id= new CAsignatura();
    }

    public int getDetalleReporte_id() {
        return detalleReporte_id;
    }

    public void setDetalleReporte_id(int detalleReporte_id) {
        this.detalleReporte_id = detalleReporte_id;
    }

    public String getDetalleReporte_fecha() {
        return detalleReporte_fecha;
    }

    public void setDetalleReporte_fecha(String detalleReporte_fecha) {
        this.detalleReporte_fecha = detalleReporte_fecha;
    }

    public String getDetalleReporte_hora() {
        return detalleReporte_hora;
    }

    public void setDetalleReporte_hora(String detalleReporte_hora) {
        this.detalleReporte_hora = detalleReporte_hora;
    }

    public EEquiposreportados getEquiposRepor_id() {
        return equiposRepor_id;
    }

    public void setEquiposRepor_id(EEquiposreportados equiposRepor_id) {
        this.equiposRepor_id = equiposRepor_id;
    }

    public EReportespersona getReportePer_id() {
        return reportePer_id;
    }

    public void setReportePer_id(EReportespersona reportePer_id) {
        this.reportePer_id = reportePer_id;
    }

    public CPrioridad getPrioridad_id() {
        return prioridad_id;
    }

    public void setPrioridad_id(CPrioridad prioridad_id) {
        this.prioridad_id = prioridad_id;
    }

    public CEstadoreporte getEdoRe_id() {
        return edoRe_id;
    }

    public void setEdoRe_id(CEstadoreporte edoRe_id) {
        this.edoRe_id = edoRe_id;
    }

    public MReporte getMaestraReporte_id() {
        return maestraReporte_id;
    }

    public void setMaestraReporte_id(MReporte maestraReporte_id) {
        this.maestraReporte_id = maestraReporte_id;
    }

    public CAsignatura getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(CAsignatura asignatura_id) {
        this.asignatura_id = asignatura_id;
    }
    

    public static int registrarReporte(DReporte r){
        int estatus = 0;
        
        try{
            Connection con = Conexion.getConecction();
            
            String q = "insert into dreporte (equiposRepor_id, reportePer_id, prioridad_id,"
                    + "edoRe_id, detalleReporte_fecha,"
                    + "detalleReporte_hora) values (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
//            ps.setInt(1, r.getEquiposRepor_id());
//            ps.setInt(2, r.getReportePer_id());
//            ps.setInt(3, r.getPrioridad_id());
//            ps.setInt(4, r.getEdoRe_id());
//            ps.setString(5, r.getDetalleReporte_fecha());
//            ps.setString(6, r.getdetalleReporte_hora());
            
            estatus = ps.executeUpdate();
            
            System.out.println("Registro de reporte exitoso");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al registrar reporte");
            System.out.println(ex.getMessage());
        }       
        return estatus;       
    }

    public static int actualizarReporte(DReporte r){
        int estatus = 0;
        
        try{
            Connection con = Conexion.getConecction();
            
            String q = "update dreporte set equiposRepor_id = ?, prioridad_id = ?, "
                    + "edoRe_id = ? where detalleReporte_id = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
//            ps.setInt(1, r.getEtiqueta_id());
//            ps.setInt(2, r.getPrioridad_id());
//            ps.setInt(3, r.getEdoRe_id());
//            ps.setInt(4, r.detalleReporte_id());
            
            estatus = ps.executeUpdate();

            System.out.println("Se actualizo el reporte");
            con.close();
                      
        }catch(Exception ex){
            System.out.println("Error al actualizar reporte");
            System.out.println(ex.getMessage());
        }      
        return estatus;    
    }

    public static int eliminarReporte(int id){
        int estatus = 0;
        
        try{
            Connection con = Conexion.getConecction();
            
            String q = "delete from dreporte where detalleReporte_id = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            estatus = ps.executeUpdate();
            
            System.out.println("Se elimino el reporte");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al eliminar reporte");
        }
        return estatus;
    }
}
