package servlets;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocioImpl.UsuarioNegocioImpl;
import negocio.UsuarioNegocio;
import entidades.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	if (request.getParameter("btnLogin") != null)
    	{
    		String nombreUsuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("password");
          
            Usuario usuario = usuarioNegocio.autenticarUsuario(nombreUsuario, contrasenia);

            if (usuario != null) {
                request.getSession().setAttribute("usuarioLogueado", nombreUsuario);
                request.getSession().setAttribute("idUsuario", usuario.getIDUsuario());
                request.getSession().setAttribute("tipoUsuario", usuario.getTipoUsuario());
                 
               
                if (usuario.getTipoUsuario() == 1) {
                    
                    response.sendRedirect("MenuAdmin.jsp");
                } else if (usuario.getTipoUsuario() == 2) {
                   
                    response.sendRedirect("MenuCliente.jsp");
                } else {
                    
                    response.sendRedirect("error.jsp");
                }
            } else {
            	
                request.setAttribute("mensajeError", "Usuario o contrasenia incorrectos");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
    	}
        
    }
}