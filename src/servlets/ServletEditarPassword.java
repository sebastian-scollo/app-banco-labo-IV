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
	    String contrasena = request.getParameter("contrasena");
	    String nuevaContrasena = request.getParameter("nuevaContrasena");
	    String repContrasena = request.getParameter("repContrasena");

	    // Verificar si alguno de los par�metros es null
	    if (nombreUsuario == null || contrasena == null || nuevaContrasena == null || repContrasena == null) {
	        response.getWriter().println("Error: Faltan datos en el formulario.");
	        return;
	    }

	    System.out.println("nombreUsuario: " + nombreUsuario);
	    System.out.println("contrasena: " + contrasena);
	    System.out.println("nuevaContrasena: " + nuevaContrasena);
	    System.out.println("repContrasena: " + repContrasena);

	    // L�gica para procesar la actualizaci�n de contrase�a
	    if (nuevaContrasena.equals(repContrasena)) {
	        boolean resultado = usuarioNegocio.editarPassword(nombreUsuario, contrasena, nuevaContrasena);
	        if (resultado) {
	            response.getWriter().println("Contrase�a actualizada con �xito.");
	        } else {
	            response.getWriter().println("Error al actualizar la contrase�a.");
	        }
	    } else {
	        // Manejar el error si las contrase�as no coinciden
	        response.getWriter().println("Las contrase�as no coinciden.");
	    }
	}
}


