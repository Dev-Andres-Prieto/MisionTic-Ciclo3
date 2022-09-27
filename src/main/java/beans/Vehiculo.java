package beans;

public class Vehiculo {
    private int idVehiculo;    
    private String modelo;
    private String marca;
    private int idDescripcion;
    private int idTarifa;
    private int reservado;

    public Vehiculo(int idVehiculo, String modelo, String marca, int idDescripcion, int idTarifa, int reservado) {
        this.idVehiculo = idVehiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.idDescripcion = idDescripcion;
        this.idTarifa = idTarifa;
        this.reservado = reservado;
    }    

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdDescripcion() {
        return idDescripcion;
    }

    public void setDescripcion(int idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }
    
    public int getReservado() {
        return reservado;
    }

    public void setReservado(int reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", modelo=" + modelo + ", marca=" + marca + ", idDescripcion=" + idDescripcion + ", idTarifa=" + idTarifa + ", reservado=" + reservado + '}';
    }
    
    
}

