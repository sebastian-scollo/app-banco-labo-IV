package servlets;
import entidades.Cuenta;
import negocio.negocioCuenta;
import negocioImpl.negocioCuentaImpl;
import entidades.TipoCuenta;
import negocio.negocioTipoCuenta;
import negocioImpl.negocioTipoCuentaImpl;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ServletAgregarCuenta
 */
@WebServlet("/ServletAgregarCuenta")
public class ServletAgregarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		        negocioTipoCuenta dao = new negocioTipoCuentaImpl();
		 
		        try {
		 
		            String listTipo = dao.obtenerOpcionesDDL();
		            request.setAttribute("listTipo", listTipo);
		 
		            RequestDispatcher dispatcher = request.getRequestDispatcher("AgregarCuenta.jsp");
		            dispatcher.forward(request, response);
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		            throw new ServletException(e);
		        }
		    }
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if (request.getParameter("btnAceptar") != null) {
		        Cuenta c = new Cuenta();

		        int idTipo = Integer.parseInt(request.getParameter("TipoCuenta"));
		        int idCliente = Integer.parseInt(request.getParameter("IdCliente"));

		        
		        negocioCuenta nc = new negocioCuentaImpl();
		        boolean cantidadCuentas = nc.CantidadCuenta(idCliente);
		        

		        if (cantidadCuentas==true) {
		           
		            request.setAttribute("mensajeError", "El cliente ya tiene el número máximo permitido de cuentas.");
		        } else {
		           
		            c.setTipoCuentaId(idTipo);
		            c.setClienteId(idCliente);
		            c.setCBU(request.getParameter("CBU"));
		            c.setNroCuenta(request.getParameter("NumCuenta"));
		            c.setSaldo(Double.parseDouble(request.getParameter("Saldo")));

		            nc.AgregarCuenta(c);
		        }
		    }

		    RequestDispatcher dispatcher = request.getRequestDispatcher("AgregarCuenta.jsp");
		    dispatcher.forward(request, response);	
		
		 /* if (request.getParameter("btnAceptar") != null) {
		        Cuenta c = new Cuenta();

		       
		        int idTipo = Integer.parseInt(request.getParameter("TipoCuenta"));
		        request.setAttribute("tipoSeleccionado", idTipo);
		        
		    
		        c.setTipoCuentaId(idTipo);
		        c.setClienteId(Integer.parseInt(request.getParameter("IdCliente")));
		        c.setCBU(request.getParameter("CBU"));
		        c.setNroCuenta(request.getParameter("NumCuenta"));
		        
		       
		        c.setSaldo(Double.parseDouble(request.getParameter("Saldo")));

		        
		   
		        negocioCuenta nc = new negocioCuentaImpl();
		        nc.AgregarCuenta(c); 
		    }

		  
		    RequestDispatcher dispatcher = request.getRequestDispatcher("AgregarCuenta.jsp");
		    dispatcher.forward(request, response);*/
	}


}