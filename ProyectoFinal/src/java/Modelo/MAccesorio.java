
package Modelo;

import Control.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class MAccesorio {
    private int accesorio_id;
    private String config_descripcionTeclado;
    private String config_descripcionMause;
    
    public MAccesorio(){
        accesorio_id=0;
        config_descripcionTeclado="";
        config_descripcionMause="";
    }
    
    public ArrayList<MAccesorio> getAllAccesorio() throws Exception { 
        //primero creamos el objeto Genero
        MAccesorio accesorio;
        //Lista de generos
        ArrayList<MAccesorio> accesorios;
        accesorios = new ArrayList();
      
        try{
            
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "SELECT * FROM MAccesorio";
                
                //para darle fprmato a la querry hay que usar prepareStatement            
                PreparedStatement ps = con.prepareStatement(q);
                //sse ejecuta
                ResultSet rs = ps.executeQuery();
                
                while (rs.next() == true) {
                    accesorio = new MAccesorio();
                    accesorio.setAccesorio_id(rs.getInt(1));
                    accesorio.setConfig_descripcionTeclado(rs.getString(2));
                    accesorio.setConfig_descripcionMause(rs.getString(3));
                    accesorios.add(accesorio);
                }
            }
            
//            System.out.println("Lista de Generos correcta");
            
        }catch(SQLException ex){
            System.out.println("Error al generar la lista");
            System.out.println(ex.getMessage());
            
        }
        return accesorios;
    }

    public int getAccesorio_id() {
        return accesorio_id;
    }

    public void setAccesorio_id(int accesorio_id) {
        this.accesorio_id = accesorio_id;
    }

    public String getConfig_descripcionTeclado() {
        return config_descripcionTeclado;
    }

    public void setConfig_descripcionTeclado(String config_descripcionTeclado) {
        this.config_descripcionTeclado = config_descripcionTeclado;
    }

    public String getConfig_descripcionMause() {
        return config_descripcionMause;
    }

    public void setConfig_descripcionMause(String config_descripcionMause) {
        this.config_descripcionMause = config_descripcionMause;
    }
    
}
