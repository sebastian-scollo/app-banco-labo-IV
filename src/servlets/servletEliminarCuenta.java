package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.negocioCliente;
import negocio.negocioCuenta;
import negocioImpl.negocioClienteImpl;
import negocioImpl.negocioCuentaImpl;

/**
 * Servlet implementation class servletEliminarCuenta
 */
@WebServlet("/servletEliminarCuenta")
public class servletEliminarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarCuenta() {
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
	
		negocioCuenta negCuenta = new negocioCuentaImpl();
		String enter_idCuenta = request.getParameter("idCuenta");
		int idCuenta =Integer.parseInt(enter_idCuenta);
		boolean eliminado = negCuenta.eliminarCuenta(idCuenta);
		if(eliminado) {
			response.sendRedirect("AdministrarCuenta.jsp"); 
		}else {
			 response.sendRedirect("EliminarCuenta.jsp?error=NoSePudoEliminar");
		}
		
	}

}
