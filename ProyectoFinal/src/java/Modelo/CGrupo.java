
package Modelo;

public class CGrupo {
    private int grupo_id;
    private String grupo_tipo;
    
    public CGrupo(){
        grupo_id=0;
        grupo_tipo="";
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getGrupo_tipo() {
        return grupo_tipo;
    }

    public void setGrupo_tipo(String grupo_tipo) {
        this.grupo_tipo = grupo_tipo;
    }
    
}
