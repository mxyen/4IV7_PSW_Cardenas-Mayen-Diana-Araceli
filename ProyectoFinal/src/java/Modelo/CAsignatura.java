
package Modelo;

public class CAsignatura {
    private int asignatura_id;
    private String asignatura_nombre;
    
    public CAsignatura(){
        asignatura_id=0;
        asignatura_nombre="";
    }

    public int getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(int asignatura_id) {
        this.asignatura_id = asignatura_id;
    }

    public String getAsignatura_nombre() {
        return asignatura_nombre;
    }

    public void setAsignatura_nombre(String asignatura_nombre) {
        this.asignatura_nombre = asignatura_nombre;
    }
    
}
