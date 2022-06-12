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
public class EReportespersona {
    private int reportePer_id;
    private MPersona persona_id;
    
    public EReportespersona(){
        reportePer_id=0;
        persona_id=new MPersona();
    }

    public int getReportePer_id() {
        return reportePer_id;
    }

    public void setReportePer_id(int reportePer_id) {
        this.reportePer_id = reportePer_id;
    }

    public MPersona getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(MPersona persona_id) {
        this.persona_id = persona_id;
    }
    
}
