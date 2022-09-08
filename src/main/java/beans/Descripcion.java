package beans;

public class Descripcion {
    private int idDescripcion;
    private int anio;
    private String matricula;
    private String cilindraje;
    private String potencia;
    private String torque;
    private String gamaVehiculo;
    private String transmision;

    public Descripcion(int idDescripcion, int anio, String matricula, String cilindraje, String potencia, String torque, String gamaVehiculo, String transmision) {
        this.idDescripcion = idDescripcion;
        this.anio = anio;
        this.matricula = matricula;
        this.cilindraje = cilindraje;
        this.potencia = potencia;
        this.torque = torque;
        this.gamaVehiculo = gamaVehiculo;
        this.transmision = transmision;
    }

    public int getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(int idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getGamaVehiculo() {
        return gamaVehiculo;
    }

    public void setGamaVehiculo(String gamaVehiculo) {
        this.gamaVehiculo = gamaVehiculo;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    @Override
    public String toString() {
        return "Descripcion{" + "idDescripcion=" + idDescripcion + ", anio=" + anio + ", matricula=" + matricula + ", cilindraje=" + cilindraje + ", potencia=" + potencia + ", torque=" + torque + ", gamaVehiculo=" + gamaVehiculo + ", transmision=" + transmision + '}';
    }
   
}
