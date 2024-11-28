package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cuenta;
import entidades.Prestamo;
import negocio.negocioCuotas;
import negocioImpl.negocioCuotaImpl;

/**
 * Servlet implementation class servletCuota
 */
@WebServlet("/servletCuota")
public class servletCuota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public servletCuota() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session = request.getSession();
		    Cuenta cuentaElegida = (Cuenta) session.getAttribute("cuentaElegida");
		    
		    if (cuentaElegida != null) {
		        String cbu = cuentaElegida.getCBU(); // Obtén el CBU del objeto Cuenta
		        
		        negocioCuotas negCuota = new negocioCuotaImpl();
		        ArrayList<Prestamo> prestamos = negCuota.ListarPrestamos(cbu);
		        
		        request.setAttribute("listadoPrestamos", prestamos);
		        request.getRequestDispatcher("verPrestamos.jsp").forward(request, response);
		    } else {
		        response.sendRedirect("opcionCuotas.jsp");
		    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		    String cbu = (String) session.getAttribute("cuentaElegida");

		    negocioCuotas negCuota = new negocioCuotaImpl();
		    ArrayList<Prestamo> prestamos = negCuota.ListarPrestamos(cbu);

		    request.setAttribute("listadoPrestamos", prestamos);
		    request.getRequestDispatcher("verPrestamos.jsp").forward(request, response);
	}

}
