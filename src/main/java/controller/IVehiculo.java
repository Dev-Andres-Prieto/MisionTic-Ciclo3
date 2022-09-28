package controller;


public interface IVehiculo {
    public String listar(boolean ordenar, String orden);
    public String alquilar(int id, double precio, int idUser);
    public String modificar(int id);
    public String devolver(int idUsuario, int idVehiculo, int idReserva);
}
