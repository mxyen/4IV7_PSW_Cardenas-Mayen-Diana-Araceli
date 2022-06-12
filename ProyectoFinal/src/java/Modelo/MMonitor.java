/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author cerna
 */
public class MMonitor {
    private String monitor_id;
    private String monitor_descripcion;
    
    public MMonitor(){
        monitor_id="";
        monitor_descripcion="";
    }
        public ArrayList<MMonitor> getAllMonitor() throws Exception { 
        //primero creamos el objeto Genero
        MMonitor monitor;
        //Lista de generos
        ArrayList<MMonitor> monitores;
        monitores = new ArrayList();
      
        try{
            
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "SELECT * FROM MMonitor";
                
                //para darle fprmato a la querry hay que usar prepareStatement            
                PreparedStatement ps = con.prepareStatement(q);
                //sse ejecuta
                ResultSet rs = ps.executeQuery();
                
                while (rs.next() == true) {
                    monitor = new MMonitor();
                    monitor.setMonitor_id(rs.getString(1));
                    monitor.setMonitor_descripcion(rs.getString(2));
                    monitores.add(monitor);
                }
            }
            
//            System.out.println("Lista de Generos correcta");
            
        }catch(SQLException ex){
            System.out.println("Error al generar la lista");
            System.out.println(ex.getMessage());
            
        }
        return monitores;
    }



    public String getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(String monitor_id) {
        this.monitor_id = monitor_id;
    }

    public String getMonitor_descripcion() {
        return monitor_descripcion;
    }

    public void setMonitor_descripcion(String monitor_descripcion) {
        this.monitor_descripcion = monitor_descripcion;
    }
    
}
