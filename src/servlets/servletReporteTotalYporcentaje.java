package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Movimiento;
import negocio.negocioReporte;
import negocioImpl.negocioReporteImpl;

/**
 * Servlet implementation class servletReporteTotalYporcentaje
 */
@WebServlet("/servletReporteTotalYporcentaje")
public class servletReporteTotalYporcentaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletReporteTotalYporcentaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idTipoMovimientoStr = request.getParameter("txtIdTipoMovimiento");
	    ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
	    ArrayList<Double> listaPorcentaje = new ArrayList<>();
	    
	    try {

	        if (idTipoMovimientoStr != null && !idTipoMovimientoStr.trim().isEmpty()) {
	            int idTipoMovimiento = Integer.parseInt(idTipoMovimientoStr);

	            negocioReporte negR = new negocioReporteImpl();

	            ArrayList<Object> resultado = negR.TotalYPorcentaje(idTipoMovimiento);

	           
	            listaMovimientos = (ArrayList<Movimiento>) resultado.get(0);  
	            listaPorcentaje = (ArrayList<Double>) resultado.get(1); 

	        } else {
	            request.setAttribute("error", "Debe ingresar un Id de Tipo de Movimiento válido.");
	        }
	    } catch (NumberFormatException ex) {
	      
	        request.setAttribute("error", "El Id de Tipo de Movimiento debe ser un número.");
	    } catch (Exception ex) {
	      
	        request.setAttribute("error", "Ocurrió un error al procesar la solicitud: " + ex.getMessage());
	    }

	
	    request.setAttribute("listaMovimientos", listaMovimientos);
	    request.setAttribute("listaPorcentaje", listaPorcentaje);

	  
	    request.getRequestDispatcher("TipoMovimientoTotalconPorcentaje.jsp").forward(request, response);
	}

}
