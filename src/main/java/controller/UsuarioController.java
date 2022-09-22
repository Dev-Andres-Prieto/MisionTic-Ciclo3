package controller;


import beans.Usuario;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioController implements IUsuarioController{
    @Override
    public String login(String email, String contrasena){
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        
        String sql = "SELECT * FROM usuarios WHERE email = '" + email + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int idUser = rs.getInt("id_usuarios");
                String nombre = rs.getString("nombre_usuario");
                String apellido = rs.getString("apellido_usuario");
                String correo = rs.getString("email");
                int idTipoDocumento = rs.getInt("idtipo_documen");
                String numDocumentos = rs.getString("num_documentos");
                int idTipoPersona = rs.getInt("idtipo_personas");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                int saldo = rs.getInt("saldo");
                Usuario usuario = new Usuario(idUser, nombre, apellido, telefono, direccion, correo, contrasena, numDocumentos,idTipoDocumento, idTipoPersona, saldo);
                
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        return "false";
    }
    
    @Override
    public String register(String nombre, String apellido, String telefono, String direccion, String email, String contrasena, String numDocumento, int idTipoDocumento, int idTipoPersona, double saldo) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        
        String sql = "Insert into usuarios values(NULL, '" + nombre + "','" + apellido + "', " + idTipoDocumento + ", '" + numDocumento
                + "', " + idTipoPersona + ",'" + telefono + "', '" + direccion + "', '" + email
                + "', '" + contrasena + "', " + saldo + ")";
        
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Usuario usuario = new Usuario(nombre, apellido, telefono, direccion, email, contrasena, numDocumento, idTipoDocumento, idTipoPersona, saldo);
            st.close();
            return gson.toJson(usuario);
            
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }finally{
            con.desconectar();
        }
        
        return "false";
        
        
    }

    @Override
    public String pedir(String email) {
        
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        
        String sql = "SELECT * FROM usuarios WHERE email = '" +  email + "'";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int idUsuario = rs.getInt("id_usuarios");
                String nombre = rs.getString("nombre_usuario");
                String apellido = rs.getString("apellido_usuario");
                int idTipoDocumento = rs.getInt("idtipo_documen");
                String numDocumento = rs.getString("num_documentos");
                int idTipoPersona = rs.getInt("idtipo_personas");                
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");     
                String contrasena = rs.getString("contrasena");
                double saldo = rs.getDouble("saldo");
                
                Usuario usuario = new Usuario(idUsuario,nombre, apellido, telefono, direccion, email, contrasena, numDocumento, idTipoDocumento, idTipoPersona, saldo);
                return gson.toJson(usuario);
            }
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }finally{
            con.desconectar();
        }
        
        return "false";
    }
    
    @Override
    public String restarDinero(int idUser, double nuevoSaldo) {
        DBConnection con = new DBConnection();
        String sql = "Update usuarios set saldo = " + nuevoSaldo + " where id_usuarios = " + idUser;
        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}
