package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cuenta;
import negocio.negocioCuenta;
import negocio.negocioOpcionCuenta;
import negocioImpl.negocioCuentaImpl;
import negocioImpl.negocioOpcionCuentaImpl;

/**
 * Servlet implementation class servletCuentaElegida
 */
@WebServlet("/servletCuentaElegida")
public class servletCuentaElegida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public servletCuentaElegida() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String cbu = request.getParameter("cbu"); 
	        negocioCuenta negocioCuenta = new negocioCuentaImpl(); 
	        Cuenta cuenta = negocioCuenta.cuentaXcbu(cbu);

	        if (cuenta != null) {
	    
	            HttpSession session = request.getSession();
	            session.setAttribute("cuentaElegida", cuenta);

	      
	            response.sendRedirect("CuentaElegida.jsp");
	        } else {
	          
	            response.getWriter().println("Cuenta no encontrada.");
	        }
	    
	
		
	}

}
