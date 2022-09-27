package controller;

import beans.Reserva;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import connection.DBConnection;

public class ReservaController implements IReservaController {

    @Override
    public String listarReservas(String email) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select v.id_vehiculo, v.marcas, v.modelo, r.total_contrato, r.fecha_recepcion,r.id_sucursales, r.id_reserva, u.id_usuarios from vehiculo v "
                + "inner join reserva r on v.id_vehiculo = r.id_vehiculo inner join usuarios u on r.id_usuarios = u.id_usuarios "
                + "where v.reservado = 1 and r.fecha_devolucion IS NULL and u.email = '" + email + "'";
        
        List<String> reservas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idVehiculo = rs.getInt("id_vehiculo");
                int idUsuario = rs.getInt("id_usuarios");
                int idReserva = rs.getInt("id_reserva");
                String marca = rs.getString("marcas");
                String modelo = rs.getString("modelo");
                double precio = rs.getDouble("total_contrato");
                Date fechaReserva= rs.getDate("fecha_recepcion");

                Reserva reserva = new Reserva(idReserva,idVehiculo, idUsuario, fechaReserva,precio, marca, modelo);                

                reservas.add(gson.toJson(reserva));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(reservas);
    }
}



