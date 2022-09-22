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

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idVehiculo=" + idVehiculo + ", idUSuario=" + idUSuario + ", idSucursal=" + idSucursal + ", fechaRecepcion=" + fechaRecepcion + ", fechaDevolucion=" + fechaDevolucion + ", duracion=" + duracion + ", totalContrato=" + totalContrato + '}';
    }
    
    
}
