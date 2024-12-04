package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocio.negocioCliente;
import negocioImpl.negocioClienteImpl;

/**
 * Servlet implementation class servletEditarCliente
 */
@WebServlet("/servletEditarCliente")
public class servletEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String dni = request.getParameter("dni");
	        if (dni != null && !dni.isEmpty()) {     
	            negocioCliente negocio = new negocioClienteImpl(); 
	            ArrayList<Cliente> clientes = negocio.ListarDni(dni);
	            
	            if (!clientes.isEmpty()) {
	                Cliente cliente = clientes.get(0); 
	                request.setAttribute("cliente", cliente);
	            }
	        }
	        
	        
	        request.getRequestDispatcher("EditarClientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellido");
	    String telefono = request.getParameter("telefono");
	    String sexo = request.getParameter("sexo");
	    String email = request.getParameter("email");

	    Cliente cliente = new Cliente();
	    cliente.setDni(dni);
	    cliente.setNombre(nombre);
	    cliente.setApellido(apellido);
	    cliente.setTelefono(telefono);
	    cliente.setSexo(sexo);
	    cliente.setCorreo(email);

	    negocioCliente negocio = new negocioClienteImpl(); 
	    boolean actualizado = negocio.EditarClieente(cliente);

	    if (actualizado) {
	    } else {
	        request.setAttribute("error", "Error en la modificacion del cliente.");
	        request.getRequestDispatcher("EditarClientes.jsp").forward(request, response);
	    }
	}

}
