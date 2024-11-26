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
	
	    HttpSession session = request.getSession();
	    String nombreUsuario = (String) session.getAttribute("usuarioLogueado");
	    String contrasena = request.getParameter("contrasena");
	    String nuevaContrasena = request.getParameter("nuevaContrasena");
	    String repContrasena = request.getParameter("repContrasena");

	
	    if (nombreUsuario == null || contrasena == null || nuevaContrasena == null || repContrasena == null ||
	        nombreUsuario.isEmpty() || contrasena.isEmpty() || nuevaContrasena.isEmpty() || repContrasena.isEmpty()) {
	        request.setAttribute("error", "Error: Faltan datos en el formulario.");
	        request.getRequestDispatcher("EditarPassword.jsp").forward(request, response);
	        return;
	    }

	   
	    if (nuevaContrasena.length() < 7) {
	       
	        request.setAttribute("error", "La nueva contraseña debe tener al menos 7 caracteres.");
	     
	        request.getRequestDispatcher("EditarPassword.jsp").forward(request, response);
	        return;
	    }
	    if (!nuevaContrasena.equals(repContrasena)) {
	        request.setAttribute("error", "Error: Las contraseñas no coinciden.");
	        request.getRequestDispatcher("EditarPassword.jsp").forward(request, response);
	        return;
	    }

	   
	    UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();
	    boolean resultado = usuarioNegocio.editarPassword(nombreUsuario, contrasena, nuevaContrasena);

	    
	    if (resultado) {
	        request.setAttribute("success", "Contraseña actualizada con éxito.");
	        request.getRequestDispatcher("EditarPassword.jsp").forward(request, response);
	    } else {
	        request.setAttribute("error", "Error al actualizar la contraseña. Verifique los datos ingresados.");
	        request.getRequestDispatcher("EditarPassword.jsp").forward(request, response);
	    }
	}
}


