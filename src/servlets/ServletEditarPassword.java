package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.UsuarioNegocio;
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
		
	   // String nombreUsuario = request.getParameter("nombreUsuario");
		UsuarioNegocio superSudo = new UsuarioNegocioImpl();
		HttpSession session = request.getSession();
	    String nombreUsuario = (String) session.getAttribute("usuarioLogueado");
		int idUsuarioExiste= superSudo.buscarXid(nombreUsuario); // lo que pense es que aca es mejor buscar por ID , pero no estoy seguro si es eso mejor que nombre.
		String contrasena = request.getParameter("contrasena");
	    String nuevaContrasena = request.getParameter("nuevaContrasena");
	    String repContrasena = request.getParameter("repContrasena");

	    
	    if (nombreUsuario == null || contrasena == null || nuevaContrasena == null || repContrasena == null) {
	        response.getWriter().println("Error: Faltan datos en el formulario.");
	        return;
	    }
	    if (idUsuarioExiste == -1) {
	        response.getWriter().println("UPS,mi estimado el usuario no se encunetraa.");
	        return;
	    }
	    System.out.println("nombreUsuario: " + nombreUsuario);
	    System.out.println("contrasena: " + contrasena);
	    System.out.println("nuevaContrasena: " + nuevaContrasena);
	    System.out.println("repContrasena: " + repContrasena);

	
	    if (nuevaContrasena.equals(repContrasena)) {
	        boolean resultado = usuarioNegocio.editarPassword(nombreUsuario, contrasena, nuevaContrasena);
	        if (resultado) {
	            response.getWriter().println("Contraseña actualizada con éxito.");
	        } else {
	            response.getWriter().println("Error al actualizar la contraseña.");
	        }
	    } else {
	      
	        response.getWriter().println("Las contraseñas no coinciden.");
	    }
	    request.getRequestDispatcher("EditarPassword.jsp").forward(request, response);
	}
}


