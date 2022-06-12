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
public class CMarca {
    private int marca_id;
    private String marca_nom;
    
    public CMarca(){
        marca_id=0;
        marca_nom="";
    }
    
     public ArrayList<CMarca> getAllMarca() throws Exception { 
        //primero creamos el objeto Genero
        CMarca marca;
        //Lista de generos
        ArrayList<CMarca> marcas;
        marcas = new ArrayList();
      
        try{
            
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "SELECT * FROM CMarca";
                
                //para darle fprmato a la querry hay que usar prepareStatement            
                PreparedStatement ps = con.prepareStatement(q);
                //sse ejecuta
                ResultSet rs = ps.executeQuery();
                
                while (rs.next() == true) {
                    marca = new CMarca();
                    marca.setMarca_id(rs.getInt(1));
                    marca.setMarca_nom(rs.getString(2));
                    marcas.add(marca);
                }
            }
            
//            System.out.println("Lista de Generos correcta");
            
        }catch(SQLException ex){
            System.out.println("Error al generar la lista");
            System.out.println(ex.getMessage());
            
        }
        return marcas;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public String getMarca_nom() {
        return marca_nom;
    }

    public void setMarca_nom(String marca_nom) {
        this.marca_nom = marca_nom;
    }
    
}
