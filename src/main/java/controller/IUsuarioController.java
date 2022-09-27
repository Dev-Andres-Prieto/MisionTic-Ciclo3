package controller;

public interface IUsuarioController {
    public String login(String email, String contrasena);
    public String register(String nombre, String apellido, String telefono, String direccion, String email, String contrasena, String numDocumento, int idTipoDocumento, int idTipoPersona, double saldo);
    public String pedir(String email);
    public String restarDinero(int idUser, double nuevoSaldo);
    public String modificar(int idUsuario, String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevaDireccion, String nuevoEmail, String nuevaContrasena, String nuevoNumDocumento, double nuevoSaldo);
    public String eliminar(int idUsuario);
}