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
		// Recuperar parámetros del formulario
	    String nombreUsuario = request.getParameter("nombreUsuario");
	    String contraseña = request.getParameter("contraseña");
	    String nuevaContraseña = request.getParameter("nuevaContraseña");
	    String repContraseña = request.getParameter("repContraseña");

	    // Lógica para procesar la actualización de contraseña
	    if (nuevaContraseña.equals(repContraseña)) {
	        boolean resultado = usuarioNegocio.editarPassword(nombreUsuario, contraseña, nuevaContraseña);
	    } else {
	        // Manejar el error si las contraseñas no coinciden
	        response.getWriter().println("Las contraseñas no coinciden.");
	    }
	}

}
