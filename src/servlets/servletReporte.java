package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocio.negocioReporte;
import negocioImpl.negocioReporteImpl;

/**
 * Servlet implementation class servletReporte
 */
@WebServlet("/servletReporte")
public class servletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletReporte() {
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
		if (request.getParameter("btnBuscarIdp") != null) {
	           
			int provinciaID = Integer.parseInt(request.getParameter("txtBuscarIdProvincia"));
			System.out.println("Provincia ID recibido en servlet: " + provinciaID);

            
       
            negocioReporte negocio = new negocioReporteImpl();
            List<Cliente> listaClientes = negocio.obtenerClientesPorProvincia(provinciaID);
            
            
            request.setAttribute("listaClientes", listaClientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Informes.jsp");  // La página donde quieres mostrar los datos
            dispatcher.forward(request, response);
        }
	}

}
