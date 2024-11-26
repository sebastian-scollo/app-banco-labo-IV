package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Movimiento;
import negocio.negocioMovimiento;
import negocioImpl.negocioMovimientoImpl;

/**
 * Servlet implementation class ServletTransferencias
 */
@WebServlet("/ServletTransferencias")
public class ServletTransferencias extends HttpServlet {
	negocioMovimiento nm = new negocioMovimientoImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTransferencias() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			System.out.println("entro al if param va bien");
			ArrayList<Movimiento> lista = nm.getMovimientosUsuario((int)request.getSession().getAttribute("idUsuario"));
			request.setAttribute("lista", lista);
			RequestDispatcher rd = request.getRequestDispatcher("HistorialTransacciones.jsp");
			rd.forward(request, response);
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (request.getParameter("btnMostrarTodos") != null) {
			 ArrayList<Movimiento> lista = nm.getMovimientosUsuario((int)request.getSession().getAttribute("idUsuario"));
	         request.setAttribute("lista", lista);
	         RequestDispatcher rd = request.getRequestDispatcher("HistorialTransacciones.jsp");
	         rd.forward(request, response);
 	    }
		doGet(request, response);
	}

}
