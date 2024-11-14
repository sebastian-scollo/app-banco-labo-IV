package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.daoClienteImpl;
import entidades.Cliente;
import entidades.Direccion;

/**
 * Servlet implementation class ServletSignIn
 */
@WebServlet("/ServletSignIn")
public class ServletSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSignIn() {
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
		if (request.getParameter("btnRegistrar") != null) {
			daoClienteImpl dao = new daoClienteImpl();
			// Captura los datos del formulario
	        String nombreUsuario = request.getParameter("usuario");
	        String contrasenia = request.getParameter("contrasena");
	        String dni = request.getParameter("dni");
	        String cuil = request.getParameter("cuil");
	        String nombre = request.getParameter("nombre");
	        String apellido = request.getParameter("apellido");
	        String sexo = request.getParameter("genero");
	        String nacionalidad = request.getParameter("nacionalidad");
	        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
	        String telefono = request.getParameter("telefono");
	        String correoElectronico = request.getParameter("correo");
	        // direccion
	        String provincia = request.getParameter("provincia");
	        String calle = request.getParameter("calle");
	        String numeroCalle = request.getParameter("numero");
	        String piso = request.getParameter("piso");
	        String departamento = request.getParameter("departamento");
	        String nroLocalidad = request.getParameter("localidad");
	        
	   
	        // Conversin de fecha de String a Date
	        Date fechaNacimiento = null;
	        try {
	            fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	            //response.sendRedirect("error.jsp");  **Crear un jsp para manejar errores
	            return;
	        }
	        
	        // Crea un objeto Cliente y asigna los valores
	        Cliente cliente = new Cliente();
	        Direccion direccion = new Direccion();
	        direccion.setNombrecalle(calle);
	        direccion.setNumerCalle(Integer.parseInt(numeroCalle));
	        direccion.setPiso((piso != null && !piso.isEmpty()) ? Integer.parseInt(piso) : 0);
	        direccion.setDepartamento(departamento);
	        direccion.setNroLocalidad(Integer.parseInt(nroLocalidad));
	        cliente.setNombreUsuario(nombreUsuario);
	        cliente.setPassword(contrasenia);
	        cliente.setDni(dni);
	        cliente.setCuil(cuil);
	        cliente.setNombre(nombre);
	        cliente.setApellido(apellido);
	        cliente.setSexo(sexo);
	        cliente.setNacionalidad(nacionalidad);
	        cliente.setFechaNacimiento(fechaNacimiento);
	        cliente.setTelefono(telefono);
	        cliente.setCorreo(correoElectronico);
	        cliente.setDireccion(direccion);
	        
	        //llamar al dao de cliente
	        boolean exito = dao.RegistrarCliente(cliente);
	        if (exito) {
	            // Si el registro fue exitoso
	            response.sendRedirect("Login.jsp");
	        } else {
	            // Si hubo un error
	            response.sendRedirect("SignIn.jsp");
	        }
		}
	}

}
