package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuarioModificar", urlPatterns = {"/ServletUsuarioModificar"})
public class ServletUsuarioModificar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioController usuario = new UsuarioController();

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");        
        String contrasena = request.getParameter("contrasena");        
        String email = request.getParameter("email");
        int idUsuario = Integer.parseInt(request.getParameter("idUser"));        
        String numDocumento = request.getParameter("numDocumento");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        String usuarioStr = usuario.modificar(idUsuario, nombre, apellido, telefono, direccion, email, contrasena, numDocumento, saldo);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(usuarioStr);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
