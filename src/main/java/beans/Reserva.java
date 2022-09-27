package beans;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private int idVehiculo;
    private int idUSuario;
    private int idSucursal;
    private Date fechaRecepcion;
    private Date fechaDevolucion;
    private String duracion;
    private double totalContrato;    
    private String marca;
    private String modelo;
    
    public Reserva(int idVehiculo, int idUSuario, int idSucursal, Date fechaRecepcion, Date fechaDevolucion, String duracion, double totalContrato) {
        
        this.idVehiculo = idVehiculo;
        this.idUSuario = idUSuario;
        this.idSucursal = idSucursal;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaDevolucion = fechaDevolucion;
        this.duracion = duracion;
        this.totalContrato = totalContrato;
    }

    public Reserva(int idReserva, int idVehiculo, int idUSuario, int idSucursal, Date fechaRecepcion, Date fechaDevolucion, String duracion, double totalContrato) {
        this.idReserva = idReserva;
        this.idVehiculo = idVehiculo;
        this.idUSuario = idUSuario;
        this.idSucursal = idSucursal;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaDevolucion = fechaDevolucion;
        this.duracion = duracion;
        this.totalContrato = totalContrato;
    }

    public Reserva(int idReserva, int idVehiculo, int idUSuario, Date fechaRecepcion, double totalContrato, String marca, String modelo) {
        this.idReserva = idReserva;
        this.idVehiculo = idVehiculo;
        this.idUSuario = idUSuario;
        this.fechaRecepcion = fechaRecepcion;
        this.totalContrato = totalContrato;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdUSuario() {
        return idUSuario;
    }

    public void setIdUSuario(int idUSuario) {
        this.idUSuario = idUSuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getTotalContrato() {
        return totalContrato;
    }

    public void setTotalContrato(double totalContrato) {
        this.totalContrato = totalContrato;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idVehiculo=" + idVehiculo + ", idUSuario=" + idUSuario + ", idSucursal=" + idSucursal + ", fechaRecepcion=" + fechaRecepcion + ", fechaDevolucion=" + fechaDevolucion + ", duracion=" + duracion + ", totalContrato=" + totalContrato + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    

    
    
}
