/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cerna
 */
public class CLaboratorio {
    private int lab_id;
    private String lab_nom;
    private int lab_numEquipos;
    
    public CLaboratorio(){
        lab_id=0;
        lab_nom="";
        lab_numEquipos=0;
    }
    
    public ArrayList<CLaboratorio> getAllLaboratorio() throws Exception { 
        //primero creamos el objeto Genero
        CLaboratorio lab;
        //Lista de generos
        ArrayList<CLaboratorio> laboratorios;
        laboratorios = new ArrayList();
      
        try{
            
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "SELECT * FROM CLaboratorio";
                
                //para darle fprmato a la querry hay que usar prepareStatement            
                PreparedStatement ps = con.prepareStatement(q);
                //sse ejecuta
                ResultSet rs = ps.executeQuery();
                
                while (rs.next() == true) {
                    lab = new CLaboratorio();
                    lab.setLab_id(rs.getInt(1));
                    lab.setLab_nom(rs.getString(2));
                    laboratorios.add(lab);
                }
            }
            
//            System.out.println("Lista de Generos correcta");
            
        }catch(SQLException ex){
            System.out.println("Error al generar la lista");
            System.out.println(ex.getMessage());
            
        }
        return laboratorios;
    }

    public int getLab_id() {
        return lab_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public String getLab_nom() {
        return lab_nom;
    }

    public void setLab_nom(String lab_nom) {
        this.lab_nom = lab_nom;
    }

    public int getLab_numEquipos() {
        return lab_numEquipos;
    }

    public void setLab_numEquipos(int lab_numEquipos) {
        this.lab_numEquipos = lab_numEquipos;
    }
}
