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
                Usuario usuario = new Usuario(idUser,nombre, apellido, telefono, direccion, correo, contrasena, numDocumentos,idTipoDocumento, idTipoPersona);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        return "false";
    }
}
