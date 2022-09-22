package servlets;

import controller.VehiculoController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletVehiculoAlquilar", urlPatterns = {"/ServletVehiculoAlquilar"})
public class ServletVehiculoAlquilar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVehiculoAlquilar() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VehiculoController vehiculo = new VehiculoController();
        int id = Integer.parseInt(request.getParameter("id"));
        
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        String vehiculoStr = vehiculo.alquilar(id, precio, idUser);
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(vehiculoStr);
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
}
