package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import beans.Vehiculo;
import connection.DBConnection;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class VehiculoController implements IVehiculo{
    
    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from vehiculo LIMIT 20";

        if (ordenar == true) {
            sql += " order by modelo " + orden;
        }

        List<String> vehiculos = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int idVehiculo = rs.getInt("id_vehiculo");
                String marca = rs.getString("marcas");
                String modelo = rs.getString("modelo");
                int idDescripcion = rs.getInt("id_descripcion");
                int idTarifa = rs.getInt("id_tarifas");                

                Vehiculo vehiculo = new Vehiculo(idVehiculo, modelo, marca, idDescripcion, idTarifa);

                vehiculos.add(gson.toJson(vehiculo));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(vehiculos);

    }
}
