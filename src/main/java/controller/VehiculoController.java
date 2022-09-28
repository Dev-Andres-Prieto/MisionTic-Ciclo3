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

public class VehiculoController implements IVehiculo {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        /*====================================================================*/
        String sql = "Select v.id_vehiculo as id_vehiculo,v.id_descripcion,v.reservado, v.marcas as marca, v.modelo as modelo,t.tarifa_contrato as tarifa \n" +
                        "from vehiculo as v, tarifas as t WHERE t.id_tarifas=v.id_tarifas and\n" +
                        "v.reservado=0 LIMIT 20";

        if (ordenar == true) {
            sql += " order by modelo " + orden;
        }
        
        List<String> vehiculos = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {

                int idVehiculo = rs.getInt("id_vehiculo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int descripcion = rs.getInt("id_descripcion");
                int tarifa = rs.getInt("tarifa");
                int reservado = rs.getInt("reservado");                

                Vehiculo vehiculo = new Vehiculo(idVehiculo, modelo, marca, descripcion, tarifa, reservado);

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

        String sql = "Insert into reserva values (NULL, '" + idVehiculo + "', '" + idUser + "', " + 1 + ", '" + fechaRecepcion + "', NULL, NULL,'" + precio + "')";
        System.out.println(sql);
        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            String modificar = modificar(idVehiculo);
            if (modificar.equals("true")) {
                return "true";
            }
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
        String sql = "Update vehiculo set reservado = 1 where id_vehiculo = " + id;

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

    @Override
    public String devolver(int idUsuario, int idVehiculo, int idReserva) {
        Timestamp fechaDevolucion = new Timestamp(new Date().getTime());
        DBConnection con = new DBConnection();
        String sql = "Update reserva set fecha_devolucion='" + fechaDevolucion + "' "
                + " where id_vehiculo= " + idVehiculo + " and id_usuarios = "
                + idUsuario + " and id_reserva = " + idReserva + " limit 1";
        
        String sql2 = "Update vehiculo set reservado = 0"
                + " where id_vehiculo= " + idVehiculo;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}
