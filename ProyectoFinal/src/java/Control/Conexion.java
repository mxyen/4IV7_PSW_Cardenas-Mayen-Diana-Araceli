package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConecction(){
        String url, username, password;
        
        url = "jdbc:mysql://localhost/maquinasbatiz";
        username = "root";
        password = "n0m3l0";
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Se conecto con la BD");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No se conecto con la bd");
            System.out.println(e.getMessage());
        
        }
        return con;
    }
}