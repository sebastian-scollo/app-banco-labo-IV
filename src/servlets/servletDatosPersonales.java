package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;

/**
 * Servlet implementation class servletDatosPersonales
 */
@WebServlet("/servletDatosPersonales")
public class servletDatosPersonales extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletDatosPersonales() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  System.out.println("Entrando en servletDatosPersonales");
            UsuarioNegocio negUsuario = new UsuarioNegocioImpl();
		    Integer idUsuario = (Integer) request.getSession().getAttribute("idUsuario");
		    System.out.println("ID de usuario en sesión: " + idUsuario);

		    if (idUsuario != null) {
		   
		     

		        Cliente cliente = negUsuario.DatosPersonal(idUsuario);
		        System.out.println("Cliente encontrado: " + (cliente != null ? "Sí" : "No"));

		        if (cliente != null) {
		            request.setAttribute("cliente", cliente);
		            request.getRequestDispatcher("VerDatosPersonales.jsp").forward(request, response);
		        } else {
		            request.setAttribute("mensaje", "No se encontraron datos para el ID: " + idUsuario);
		            request.getRequestDispatcher("VerDatosPersonales.jsp").forward(request, response);
		        }
		    } else {
		        System.out.println("ID de usuario es nulo, redirigiendo a Login.jsp");
		        response.sendRedirect("Login.jsp");
		    }
	     
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
