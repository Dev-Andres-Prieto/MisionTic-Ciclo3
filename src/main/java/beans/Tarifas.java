package beans;

public class Tarifas {
    private int idTarifa;
    private double tarifaContrato;
    private double tarifaProteccionObligatoria;
    private double tasaServicios;
    private double tarifaAdicional;

    public Tarifas(int idTarifa, double tarifaContrato, double tarifaProteccionObligatoria, double tasaServicios, double tarifaAdicional) {
        this.idTarifa = idTarifa;
        this.tarifaContrato = tarifaContrato;
        this.tarifaProteccionObligatoria = tarifaProteccionObligatoria;
        this.tasaServicios = tasaServicios;
        this.tarifaAdicional = tarifaAdicional;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public double getTarifaContrato() {
        return tarifaContrato;
    }

    public void setTarifaContrato(double tarifaContrato) {
        this.tarifaContrato = tarifaContrato;
    }

    public double getTarifaProteccionObligatoria() {
        return tarifaProteccionObligatoria;
    }

    public void setTarifaProteccionObligatoria(double tarifaProteccionObligatoria) {
        this.tarifaProteccionObligatoria = tarifaProteccionObligatoria;
    }

    public double getTasaServicios() {
        return tasaServicios;
    }

    public void setTasaServicios(double tasaServicios) {
        this.tasaServicios = tasaServicios;
    }

    public double getTarifaAdicional() {
        return tarifaAdicional;
    }

    public void setTarifaAdicional(double tarifaAdicional) {
        this.tarifaAdicional = tarifaAdicional;
    }

    @Override
    public String toString() {
        return "Tarifas{" + "idTarifa=" + idTarifa + ", tarifaContrato=" + tarifaContrato + ", tarifaProteccionObligatoria=" + tarifaProteccionObligatoria + ", tasaServicios=" + tasaServicios + ", tarifaAdicional=" + tarifaAdicional + '}';
    }
    
    
    
}
