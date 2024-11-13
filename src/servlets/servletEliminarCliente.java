package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.negocioCliente;
import negocioImpl.negocioClienteImpl;

/**
 * Servlet implementation class servletEliminarCliente
 */
@WebServlet("/servletEliminarCliente")
public class servletEliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
		  negocioCliente negCliente = new negocioClienteImpl();
		  String enter_idCliente = request.getParameter("idCliente");
	        int idCliente = Integer.parseInt(enter_idCliente);
	        boolean eliminado = negCliente.eliminarCliente(idCliente);
	        if (eliminado) {
	            response.sendRedirect("AdministrarClientes.jsp"); 
	        } else {
	            response.sendRedirect("EliminarCliente.jsp?error=NoSePudoEliminar");
	        }
	}

}
