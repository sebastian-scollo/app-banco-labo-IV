package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
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
		//Buscar X IDProvincia -- Informes
		if (request.getParameter("btnBuscarIdp") != null) {
	           
			int provinciaID = Integer.parseInt(request.getParameter("txtBuscarIdProvincia"));
			System.out.println("Provincia ID recibido en servlet: " + provinciaID);
            negocioReporte negocio = new negocioReporteImpl();
            List<Cliente> listaClientes = negocio.obtenerClientesPorProvincia(provinciaID);

            request.setAttribute("listaClientes", listaClientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Informes.jsp");
            dispatcher.forward(request, response);
        }
		
		
		//Buscar X rango fecha -- InformesCuentaCreadas
		    String fechaInicio = request.getParameter("txtFechaInicio");

		    String fechaFinal = request.getParameter("txtFechaFinal");
		    negocioReporte negReporte = new negocioReporteImpl();
		    if (request.getParameter("btnBuscarIntervalo") != null) {
		        try {
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		          
		            java.sql.Date inicioDate = new java.sql.Date(sdf.parse(fechaInicio).getTime());
		            java.sql.Date finalDate = new java.sql.Date(sdf.parse(fechaFinal).getTime());

		         
		            if (finalDate.equals(inicioDate)) {
		                request.setAttribute("error", "Fecha Final no puede ser igual a la Fecha de Inicio.");
		            } else if (finalDate.before(inicioDate)) {
		                request.setAttribute("error", "Fecha Final debe ser anterior a la Fecha de Inicio.");
		            } else {
		               
		                List<Cuenta> listaCuentasXfecha = negReporte.BusquedaIntervaloFecha(inicioDate, finalDate);
		                request.setAttribute("listaCuentas", listaCuentasXfecha);
		            }

		           
		            RequestDispatcher dispatcher = request.getRequestDispatcher("InformeCuentaCreadas.jsp");
		            dispatcher.forward(request, response);

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            request.setAttribute("error", "Ocurrió un error al procesar las fechas.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("InformeCuentaCreadas.jsp");
		            dispatcher.forward(request, response);
	 	        }
	 }
		    
		    //Buscar X rango de saldo -- InformeCuentaCreada
		    
		    if (request.getParameter("btnBuscarIntervaloSaldo") != null) {
		        try {
		        	String saldoInicio = request.getParameter("txtSaldoInicio");

				    String saldoFinal = request.getParameter("txtSaldoFinal");
		        	
				    
		            if (Integer.parseInt(saldoInicio) == Integer.parseInt(saldoFinal)) {
		                request.setAttribute("error", "Saldo Final no puede ser igual a la Saldo de Inicio.");
		            } else if (Integer.parseInt(saldoFinal)<Integer.parseInt(saldoInicio)) {
		                request.setAttribute("error", "Saldo Final debe ser anterior a la Saldo de Inicio.");
		            } else {
		               
		                List<Cuenta> listaCuentasXsaldo = negReporte.BusquedaIntervaloSaldo(Integer.parseInt(saldoInicio), Integer.parseInt(saldoFinal));
		                request.setAttribute("listaCuentas", listaCuentasXsaldo);
		            }

		           
		            RequestDispatcher dispatcher = request.getRequestDispatcher("InformeCuentaCreadas.jsp");
		            dispatcher.forward(request, response);

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            request.setAttribute("error", "Ocurrió un error al procesar los saldos.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("InformeCuentaCreadas.jsp");
		            dispatcher.forward(request, response);
	 	        }
	 }
		    
	}
}
