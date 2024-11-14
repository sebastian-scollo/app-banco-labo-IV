package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocioImpl.UsuarioNegocioImpl;
import entidades.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioNegocioImpl usuarioNegocio = new UsuarioNegocioImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los valores ingresados en el formulario
        String nombreUsuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");

        // Autenticar al usuario
        Usuario usuario = usuarioNegocio.autenticarUsuario(nombreUsuario, contrasenia);

        if (usuario != null) {
            // Si la autenticaci�n es exitosa, guardar el usuario en la sesi�n
            request.getSession().setAttribute("usuarioLogueado", usuario);

            // Verificar el tipo de usuario
            if (usuario.getTipoUsuario() == 1) {
                // Redirigir a MenuAdmin.jsp si es un administrador
                response.sendRedirect("MenuAdmin.jsp");
            } else if (usuario.getTipoUsuario() == 2) {
                // Redirigir a MenuCliente.jsp si es un cliente
                response.sendRedirect("MenuCliente.jsp");
            } else {
                // Redirigir a una p�gina de error si el tipo de usuario es inv�lido
                response.sendRedirect("error.jsp");
            }
        } else {
            // Si falla la autenticaci�n, redirigir de vuelta al formulario con un mensaje de error
            request.setAttribute("mensajeError", "Usuario o contrase�a incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}