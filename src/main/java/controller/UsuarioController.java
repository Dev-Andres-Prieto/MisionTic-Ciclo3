package controller;

import beans.Usuario;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String email, String contrasena) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        //String passwordHash = BCrypt.checkpw(password, hashedPassword);

        //String sql = "SELECT * FROM usuarios WHERE email = '" + email + "' and contrasena = '" + contrasena + "'";
        String sql = "SELECT * FROM usuarios WHERE email = '" + email + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String contrasenaHash = rs.getString("contrasena");
                boolean passwordHash = BCrypt.checkpw(contrasena, contrasenaHash);

                if (passwordHash) {
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
                    Usuario usuario = new Usuario(idUser, nombre, apellido, telefono, direccion, correo, contrasenaHash, numDocumentos, idTipoDocumento, idTipoPersona, saldo);

                    return gson.toJson(usuario);
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String nombre, String apellido, String telefono, String direccion, String email, String contrasena, String numDocumento, int idTipoDocumento, int idTipoPersona, double saldo) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String passwordHash = BCrypt.hashpw(contrasena, BCrypt.gensalt(10));

        String sql = "Insert into usuarios values(NULL, '" + nombre + "','" + apellido + "', " + idTipoDocumento + ", '" + numDocumento
                + "', " + idTipoPersona + ",'" + telefono + "', '" + direccion + "', '" + email
                + "', '" + passwordHash + "', " + saldo + ")";
        System.out.println(sql);
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Usuario usuario = new Usuario(nombre, apellido, telefono, direccion, email, passwordHash, numDocumento, idTipoDocumento, idTipoPersona, saldo);
            st.close();
            
            return gson.toJson(usuario);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String email) {

        Gson gson = new Gson();
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM usuarios WHERE email = '" + email + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
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

                Usuario usuario = new Usuario(idUsuario, nombre, apellido, telefono, direccion, email, contrasena, numDocumento, idTipoDocumento, idTipoPersona, saldo);
                return gson.toJson(usuario);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
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

    @Override
    public String modificar(int idUsuario, String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevaDireccion, String nuevoEmail, String nuevaContrasena, String nuevoNumDocumento, double nuevoSaldo) {

        DBConnection con = new DBConnection();

        String sql = "Update usuarios set contrasena = '" + nuevaContrasena
                + "', nombre_usuario = '" + nuevoNombre + "', "
                + "apellido_usuario = '" + nuevoApellido + "', email = '"
                + nuevoEmail + "', saldo = " + nuevoSaldo + ", direccion = '" + nuevaDireccion + "', "
                + "telefono = '" + nuevoTelefono + "', num_documentos = " + nuevoNumDocumento;

        sql += " where id_usuarios = '" + idUsuario + "'";

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

    @Override
    public String eliminar(int idUsuario) {
        DBConnection con = new DBConnection();

        String sql1 = "UPDATE vehiculo v, reserva r, usuarios u SET v.reservado = 0 WHERE v.id_vehiculo=r.id_vehiculo AND r.id_usuarios=u.id_usuarios\n"
                + "AND u.id_usuarios= '" + idUsuario + "'";
        String sql2 = "Delete from reserva where id_usuarios = '" + idUsuario + "'";
        String sql3 = "Delete from usuarios where id_usuarios = '" + idUsuario + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
}
