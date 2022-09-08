package test;

import beans.Vehiculo;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperationsDB {
    public static void main(String[] args){
        listarVehiculos();
        //actualizarVehiculo(1, "3000");
    }
    
    public static void actualizarVehiculo(int idVehiculo, String modelo){
        DBConnection con = new DBConnection();
        String sql = "UPDATE vehiculo SET genero = '"+ modelo + "' WHERE id=" + idVehiculo;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
    
    public static void listarVehiculos(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM vehiculo";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id_vehiculo");                
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marcas");
                int idDescripcion = rs.getInt("id_descripcion");
                int idTarifa = rs.getInt("id_tarifas");              
                
                Vehiculo vehiculo = new Vehiculo(id, modelo, marca, idDescripcion, idTarifa);
                System.out.println(vehiculo.toString());
                
            }
            st.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
}
