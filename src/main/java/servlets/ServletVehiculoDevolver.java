package servlets;

import controller.VehiculoController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletVehiculoDevolver", urlPatterns = {"/ServletVehiculoDevolver"})
public class ServletVehiculoDevolver extends HttpServlet {

   private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVehiculoDevolver() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VehiculoController vehiculo = new VehiculoController();

        int idUsuario = Integer.parseInt(request.getParameter("idUser"));
        int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));

        String peliculaStr = vehiculo.devolver(idUsuario, idVehiculo);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(peliculaStr);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
