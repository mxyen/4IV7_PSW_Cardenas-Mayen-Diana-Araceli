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
public class EEquiposreportados {
    private int equiposRepor_id;
    private DEquipo equipo_etiqueta;
    
    public EEquiposreportados(){
        equiposRepor_id=0;
        equipo_etiqueta= new DEquipo();
    }

    public int getEquiposRepor_id() {
        return equiposRepor_id;
    }

    public void setEquiposRepor_id(int equiposRepor_id) {
        this.equiposRepor_id = equiposRepor_id;
    }

    public DEquipo getEquipo_etiqueta() {
        return equipo_etiqueta;
    }

    public void setEquipo_etiqueta(DEquipo equipo_etiqueta) {
        this.equipo_etiqueta = equipo_etiqueta;
    }
    
}
