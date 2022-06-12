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
public class MReporte {
    private int maestraReporte_id;
    private int maestraReporte_cantidadRepeticiones;
    
    public MReporte(){
        maestraReporte_id=0;
        maestraReporte_cantidadRepeticiones=0;
    }

    public int getMaestraReporte_id() {
        return maestraReporte_id;
    }

    public void setMaestraReporte_id(int maestraReporte_id) {
        this.maestraReporte_id = maestraReporte_id;
    }

    public int getMaestraReporte_cantidadRepeticiones() {
        return maestraReporte_cantidadRepeticiones;
    }

    public void setMaestraReporte_cantidadRepeticiones(int maestraReporte_cantidadRepeticiones) {
        this.maestraReporte_cantidadRepeticiones = maestraReporte_cantidadRepeticiones;
    }
}
