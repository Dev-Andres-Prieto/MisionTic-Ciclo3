package beans;

public class TipoUsuario {
    private int idTipoPersona;
    private String NombreTipoPersona;

    public TipoUsuario(int idTipoPersona, String NombreTipoPersona) {
        this.idTipoPersona = idTipoPersona;
        this.NombreTipoPersona = NombreTipoPersona;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return NombreTipoPersona;
    }

    public void setNombreTipoPersona(String NombreTipoPersona) {
        this.NombreTipoPersona = NombreTipoPersona;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoPersona=" + idTipoPersona + ", NombreTipoPersona=" + NombreTipoPersona + '}';
    }
    
    
}
