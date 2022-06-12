
package Modelo;

import java.sql.*;
import Control.Conexion;

public class MPersona {
    private int persona_id;
    private int alumno_boleta;
    private int empleado_num;
    private String persona_nombre;
    private String persona_appat;
    private String persona_apmat;
    private String persona_sexo;
    private String persona_fechaNacimiento;
    private String persona_user;
    private String persona_pass;
    
    private CRol rol;
    private CPrivilegio privilegio;
    private CGrupo grupo;
    
    public MPersona(){
        persona_id=0;
        alumno_boleta=0;
        empleado_num=0;
        persona_nombre="";
        persona_appat="";
        persona_apmat="";
        persona_sexo="";
        persona_fechaNacimiento="";
        persona_user="";
        persona_pass="";
        
        rol= new CRol();
        privilegio= new CPrivilegio();
        grupo= new CGrupo();
    }
    public MPersona verificarUsuario(String user, String pass) throws ClassNotFoundException{
    
        //primero creamos el objeto persona
        MPersona persona = null;
        //Connection
        Connection con = null;
        //PreparedStatement
        PreparedStatement ps = null;
        //Consulta
        ResultSet rs = null;
        
        try{
            //establecemos la conexion
            con = Conexion.getConecction();
            //querry
            
            
            String q = "Select " +
                        "m.*, g.grupo_tipo, r.rol_tipo, p.privilegio_tipo  " +
                        "from mpersona as m " +
                        "inner join crol as r " +
                        "on m.rol_id = r.rol_id " +
                        "inner join cprivilegio as p " +
                        "on m.privilegio_id = p.privilegio_id " +
                        "inner join cgrupo as g " +
                        "on m.grupo_id = g.grupo_id " +
                        "where persona_user = ? and persona_pass= ?";
              
            //prearo la sentencia
            ps = con.prepareStatement(q);
            //obtengo los elementos
            ps.setString(1, user);
            ps.setString(2, pass);
            //ejecuto la consulta
            rs = ps.executeQuery();
            //recorrer la tabla
            while(rs.next()){
                //objeto persona
                persona = new MPersona();
                persona.setPersona_id(rs.getInt("persona_id"));
                persona.setAlumno_boleta(rs.getInt("alumno_boleta"));
                persona.setEmpleado_num(rs.getInt("empleado_num"));
                persona.setPersona_nombre(rs.getString("persona_nombre"));
                persona.setPersona_appat(rs.getString("persona_appat"));
                persona.setPersona_apmat(rs.getString("persona_apmat"));
                persona.setPersona_sexo(rs.getString("persona_sexo"));
                persona.setPersona_fechaNacimiento(rs.getString("persona_fechaNacimiento"));
                persona.setPersona_user(rs.getString("persona_user"));
                persona.setPersona_pass(rs.getString("persona_pass"));
                
                persona.getGrupo().setGrupo_id(rs.getInt("grupo_id"));
                persona.getRol().setRol_id(rs.getInt("rol_id"));
                persona.getPrivilegio().setPrivilegio_id(rs.getInt("privilegio_id"));

                persona.getGrupo().setGrupo_tipo(rs.getString("grupo_tipo"));
                persona.getRol().setRol_tipo(rs.getString("rol_tipo"));
                persona.getPrivilegio().setPrivilegio_tipo(rs.getString("privilegio_tipo"));
                
                System.out.println(persona);
                break;
            }
            
        }catch(SQLException eq){
            System.out.println("Error al verificar el usuario");
            System.out.println(eq.getMessage());
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
                System.out.println("Se cerraron las conexiones");
            }catch(Exception ex){
                System.out.println("No se encontro los elementos de la clase");
                System.out.println(ex.getMessage());
            }
        }
        return persona;   
    }
    
    public boolean verificarSiExiste(String user) throws ClassNotFoundException{
    
        //primero creamos el objeto persona
        MPersona persona = null;
        //Connection
        Connection con = null;
        //PreparedStatement
        PreparedStatement ps = null;
        //Consulta
        ResultSet rs = null;
        
        boolean existe = false;
        
        try{
            //establecemos la conexion
            con = Conexion.getConecction();
            //querry
            
            
            String q = "Select " +
                        "m.*, g.grupo_tipo, r.rol_tipo, p.privilegio_tipo  " +
                        "from mpersona as m " +
                        "inner join crol as r " +
                        "on m.rol_id = r.rol_id " +
                        "inner join cprivilegio as p " +
                        "on m.privilegio_id = p.privilegio_id " +
                        "inner join cgrupo as g " +
                        "on m.grupo_id = g.grupo_id " +
                        "where persona_user = ?";
              
            //prearo la sentencia
            ps = con.prepareStatement(q);
            //obtengo los elementos
            ps.setString(1, user);
            //ejecuto la consulta
            rs = ps.executeQuery();
            //recorrer la tabla
            while(rs.next()){
                //objeto persona
                existe = true;
                break;
            }
            
        }catch(SQLException eq){
            System.out.println("Error al verificar el usuario");
            System.out.println(eq.getMessage());
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
                System.out.println("Se cerraron las conexiones");
            }catch(SQLException ex){
                System.out.println("No se encontro los elementos de la clase");
                System.out.println(ex.getMessage());
            }
        }
        return existe;   
    }
    
    public int registrarPersona(MPersona e){
        int estatus = 0;
        try{
            try ( //la conecxion
                    Connection con = Conexion.getConecction()) {
                String q = "insert into MPersona " +
                        "values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                //para darle fprmato a la querry hay que usar prepareStatement
                
                PreparedStatement ps = con.prepareStatement(q);
                
                ps.setInt(1, e.getAlumno_boleta());
                ps.setInt(2, e.getEmpleado_num());
                ps.setString(3, e.getPersona_nombre());
                ps.setString(4, e.getPersona_appat());
                ps.setString(5, e.getPersona_apmat());
                ps.setString(6, e.getPersona_sexo());
                ps.setString(7, e.getPersona_fechaNacimiento());
                ps.setString(8, e.getPersona_user());
                ps.setString(9, e.getPersona_pass());
                ps.setInt(10, e.getGrupo().getGrupo_id());
                ps.setInt(11, e.getRol().getRol_id());
                ps.setInt(12, e.getPrivilegio().getPrivilegio_id());
                
                System.out.println(q);
                //se ejecuta
                estatus = ps.executeUpdate();
                System.out.println("Estatus: " + estatus);
            }
            
            System.out.println("Registro Exitoso");
            
        }catch(SQLException ex){
            System.out.println("Error al Registrar");
            System.out.println(ex.getMessage());
            
        }
       return estatus;
    }
    

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getAlumno_boleta() {
        return alumno_boleta;
    }

    public void setAlumno_boleta(int alumno_boleta) {
        this.alumno_boleta = alumno_boleta;
    }

    public int getEmpleado_num() {
        return empleado_num;
    }

    public void setEmpleado_num(int empleado_num) {
        this.empleado_num = empleado_num;
    }

    public String getPersona_nombre() {
        return persona_nombre;
    }

    public void setPersona_nombre(String persona_nombre) {
        this.persona_nombre = persona_nombre;
    }

    public String getPersona_appat() {
        return persona_appat;
    }

    public void setPersona_appat(String persona_appat) {
        this.persona_appat = persona_appat;
    }

    public String getPersona_apmat() {
        return persona_apmat;
    }

    public void setPersona_apmat(String persona_apmat) {
        this.persona_apmat = persona_apmat;
    }

    public String getPersona_sexo() {
        return persona_sexo;
    }

    public void setPersona_sexo(String persona_sexo) {
        this.persona_sexo = persona_sexo;
    }

    public String getPersona_fechaNacimiento() {
        return persona_fechaNacimiento;
    }

    public void setPersona_fechaNacimiento(String persona_fechaNacimiento) {
        this.persona_fechaNacimiento = persona_fechaNacimiento;
    }

    public String getPersona_user() {
        return persona_user;
    }

    public void setPersona_user(String persona_user) {
        this.persona_user = persona_user;
    }

    public String getPersona_pass() {
        return persona_pass;
    }

    public void setPersona_pass(String persona_pass) {
        this.persona_pass = persona_pass;
    }   

    public CRol getRol() {
        return rol;
    }

    public void setRol(CRol rol) {
        this.rol = rol;
    }

    public CPrivilegio getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(CPrivilegio privilegio) {
        this.privilegio = privilegio;
    }

    public CGrupo getGrupo() {
        return grupo;
    }

    public void setGrupo(CGrupo grupo) {
        this.grupo = grupo;
    }
    
    
}
