package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImpl.UsuarioNegocioImpl;

/**
 * Servlet implementation class ServletEditarPassword
 */
@WebServlet("/ServletEditarPassword")
public class ServletEditarPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UsuarioNegocioImpl usuarioNegocio = new UsuarioNegocioImpl();
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarPassword() {
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
		// Recuperar par�metros del formulario
	    String nombreUsuario = request.getParameter("nombreUsuario");
	    String contrase�a = request.getParameter("contrase�a");
	    String nuevaContrase�a = request.getParameter("nuevaContrase�a");
	    String repContrase�a = request.getParameter("repContrase�a");

	    // L�gica para procesar la actualizaci�n de contrase�a
	    if (nuevaContrase�a.equals(repContrase�a)) {
	        boolean resultado = usuarioNegocio.editarPassword(nombreUsuario, contrase�a, nuevaContrase�a);
	    } else {
	        // Manejar el error si las contrase�as no coinciden
	        response.getWriter().println("Las contrase�as no coinciden.");
	    }
	}

}
