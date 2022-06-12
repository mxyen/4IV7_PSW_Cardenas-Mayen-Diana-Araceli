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
public class MCpu {
    private String cpu_serial;
    private String cpu_descripcion;
    
    public MCpu(){
        cpu_serial="";
        cpu_descripcion="";
    }
    public ArrayList<MCpu> getAllCpu() throws Exception { 
        //primero creamos el objeto Genero
        MCpu cpu;
        //Lista de generos
        ArrayList<MCpu> cpus;
        cpus = new ArrayList();
      
        try{
            
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "SELECT * FROM MCpu";
                
                //para darle fprmato a la querry hay que usar prepareStatement            
                PreparedStatement ps = con.prepareStatement(q);
                //sse ejecuta
                ResultSet rs = ps.executeQuery();
                
                while (rs.next() == true) {
                    cpu = new MCpu();
                    cpu.setCpu_serial(rs.getString(1));
                    cpu.setCpu_descripcion(rs.getString(2));
                    cpus.add(cpu);
                }
            }
            
//            System.out.println("Lista de Generos correcta");
            
        }catch(SQLException ex){
            System.out.println("Error al generar la lista");
            System.out.println(ex.getMessage());
            
        }
        return cpus;
    }

    public String getCpu_serial() {
        return cpu_serial;
    }

    public void setCpu_serial(String cpu_serial) {
        this.cpu_serial = cpu_serial;
    }

    public String getCpu_descripcion() {
        return cpu_descripcion;
    }

    public void setCpu_descripcion(String cpu_descripcion) {
        this.cpu_descripcion = cpu_descripcion;
    }
    
}
