
package Modelo;

import Control.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class MConfiguracion {
    private String config_id;
    private String config_descripcion;
    
    public MConfiguracion(){
        config_id= "";
        config_descripcion="";
    }

    public ArrayList<MConfiguracion> getAllConfiguracion() throws Exception { 
        //primero creamos el objeto Genero
        MConfiguracion configuracion;
        //Lista de generos
        ArrayList<MConfiguracion> configuraciones;
        configuraciones = new ArrayList();
        try{
            
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "SELECT * FROM MConfiguracion";
                
                //para darle fprmato a la querry hay que usar prepareStatement            
                PreparedStatement ps = con.prepareStatement(q);
                //sse ejecuta
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    configuracion = new MConfiguracion();
                    configuracion.setConfig_id(rs.getString(1));
                    configuracion.setConfig_descripcion(rs.getString(2));

                    configuraciones.add(configuracion);
                }
            }
            
//            System.out.println("Lista de Generos correcta");
            
        }catch(SQLException ex){
            System.out.println("Error al generar la lista");
            System.out.println(ex.getMessage());
            
        }
        return configuraciones;
    }



    public String getConfig_id() {
        return config_id;
    }

    public void setConfig_id(String config_id) {
        this.config_id = config_id;
    }

    public String getConfig_descripcion() {
        return config_descripcion;
    }

    public void setConfig_descripcion(String config_descripcion) {
        this.config_descripcion = config_descripcion;
    }
    
}
