package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.Usuario;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        Usuario user = usuarioNegocio.autenticarUsuario(usuario, password);

        if (user != null && user.getEstado()) {
            // Si el usuario es válido, crear una sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", user);
            response.sendRedirect("MenuAdmin.jsp"); // Redirigir al usuario a la página de inicio
        } else {
            // Si el usuario no es válido, redirigir al login con un mensaje de error
            response.sendRedirect("ClienteAgregar.jsp?error=true");
        }
    }
}