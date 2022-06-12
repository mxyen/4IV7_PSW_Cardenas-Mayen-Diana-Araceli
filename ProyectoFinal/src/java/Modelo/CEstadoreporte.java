/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cerna
 */
public class CEstadoreporte {
    private int edoRe_id;
    private String edoRe_tipo;
    
    public CEstadoreporte(){
        edoRe_id=0;
        edoRe_tipo="";
    }

    public int getEdoRe_id() {
        return edoRe_id;
    }

    public void setEdoRe_id(int edoRe_id) {
        this.edoRe_id = edoRe_id;
    }

    public String getEdoRe_tipo() {
        return edoRe_tipo;
    }

    public void setEdoRe_tipo(String edoRe_tipo) {
        this.edoRe_tipo = edoRe_tipo;
    }
    
}
