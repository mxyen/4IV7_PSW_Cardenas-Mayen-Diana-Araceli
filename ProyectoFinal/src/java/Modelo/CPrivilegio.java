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
public class CPrivilegio {
    private int privilegio_id;
    private String privilegio_tipo;

    public CPrivilegio(){
        privilegio_id=0;
        privilegio_tipo="";
    }

    public int getPrivilegio_id() {
        return privilegio_id;
    }

    public void setPrivilegio_id(int privilegio_id) {
        this.privilegio_id = privilegio_id;
    }

    public String getPrivilegio_tipo() {
        return privilegio_tipo;
    }

    public void setPrivilegio_tipo(String privilegio_tipo) {
        this.privilegio_tipo = privilegio_tipo;
    }
}
