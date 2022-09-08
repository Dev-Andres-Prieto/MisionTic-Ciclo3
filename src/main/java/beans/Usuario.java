package beans;

public class Usuario {
    private int idUser;    
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String email;
    private String password;
    private String numDocumento;
    private int idTipoDocumento;
    private int idTipoPersona;

    public Usuario(int idUser, String nombre, String apellido, String telefono, String direccion, String email, String password, String numDocumento, int idTipoDocumento, int idTipoPersona) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.numDocumento = numDocumento;
        this.idTipoDocumento = idTipoDocumento;
        this.idTipoPersona = idTipoPersona;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", password=" + password + ", numDocumento=" + numDocumento + ", idTipoDocumento=" + idTipoDocumento + ", idTipoPersona=" + idTipoPersona + '}';
    }
    
    
}
