package beans;

public class Documento {
    private int idDocumento;
    private String documento;

    public Documento(int idDocumento, String documento) {
        this.idDocumento = idDocumento;
        this.documento = documento;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Documento{" + "idDocumento=" + idDocumento + ", documento=" + documento + '}';
    }
}
