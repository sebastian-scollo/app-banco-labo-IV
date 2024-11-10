package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;

import entidades.Cliente;
import negocio.negocioCliente;
import negocioImpl.negocioClienteImpl;

@WebServlet("/ServletListarCliente")
public class ServletListarCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletListarCliente() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 negocioCliente negC = new negocioClienteImpl();
    	    
    	    // Verificar si se presionó el botón "Mostrar Todos"
    	    if (request.getParameter("btnMostrarTodos") != null) {
    	        try {
  
    	            ArrayList<Cliente> listaClientes = negC.ListarCliente();
    	            
    	           
    	            request.setAttribute("listaClientes", listaClientes != null ? listaClientes : new ArrayList<>());
    	            
    	            
    	            RequestDispatcher rd = request.getRequestDispatcher("AdministrarClientes.jsp");
    	            rd.forward(request, response);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	            
    	        }
    	    }
    }
}