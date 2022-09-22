package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import beans.Vehiculo;
import connection.DBConnection;
import com.google.gson.Gson;
import java.util.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class VehiculoController implements IVehiculo{
    
    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select v.id_vehiculo as id_vehiculo, v.marcas as marcas, v.modelo as modelo, v.id_descripcion,\n" +
                       " t.tarifa_contrato as tarifa from vehiculo as v, tarifas as t WHERE t.id_tarifas=v.id_tarifas LIMIT 20";

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
                int descripcion = rs.getInt("id_descripcion");
                int tarifa = rs.getInt("tarifa");                

                Vehiculo vehiculo = new Vehiculo(idVehiculo, modelo, marca, descripcion, tarifa);

                vehiculos.add(gson.toJson(vehiculo));                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(vehiculos);

    }
    
    @Override
    public String alquilar(int idVehiculo, double precio, int idUser) {

        Timestamp fechaRecepcion = new Timestamp(new Date().getTime());
        DBConnection con = new DBConnection();
        
        String sql = "Insert into reserva values (NULL, '" + idVehiculo + "', '" + idUser + "', " + 1 + ", '" + fechaRecepcion + "', NULL, NULL,'" + precio +"')";
        System.out.println(sql);
        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            return "true";

//            String modificar = modificar(idVehiculo);
//            if (modificar.equals("true")) {
//                return "true";
//            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }
        return "false";

    }

    @Override
    public String modificar(int id) {
        
        DBConnection con = new DBConnection();
        String sql = "Update peliculas set copias = (copias - 1) where id = " + id;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }
}
