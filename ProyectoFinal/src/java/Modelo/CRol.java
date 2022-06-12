
package Modelo;

public class CRol {
    private int rol_id;
    private String rol_tipo;
    
    public CRol(){
        rol_id = 1;
        rol_tipo = "";
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_tipo() {
        return rol_tipo;
    }

    public void setRol_tipo(String rol_tipo) {
        this.rol_tipo = rol_tipo;
    }
}
