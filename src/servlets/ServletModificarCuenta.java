package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cuenta;
import entidades.TipoCuenta;
import negocio.negocioCuenta;
import negocio.negocioTipoCuenta;
import negocioImpl.negocioCuentaImpl;
import negocioImpl.negocioTipoCuentaImpl;

/**
 * Servlet implementation class ServletModificarCuenta
 */
@WebServlet("/ServletModificarCuenta")
public class ServletModificarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 negocioTipoCuenta negTipoCuenta = new negocioTipoCuentaImpl();
		    ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();

		    if (listaTiposCuenta != null && !listaTiposCuenta.isEmpty()) {
		        request.setAttribute("listaTiposCuenta", listaTiposCuenta);
		    } else {
		        request.setAttribute("mensaje", "No hay tipos de cuenta disponibles.");
		    }
		    
		    RequestDispatcher rd = request.getRequestDispatcher("EdicionCuenta.jsp");
		    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 negocioCuenta negCuenta = new negocioCuentaImpl();

	       
	        Cuenta cuenta = new Cuenta();
	        cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo")));
	        cuenta.setClienteId(Integer.parseInt(request.getParameter("txtClienteId")));
	        cuenta.setClienteId(Integer.parseInt(request.getParameter("txtIdCuenta")));
	        TipoCuenta tipoCuenta = new TipoCuenta();
	        tipoCuenta.setIdTipoCuenta(Integer.parseInt(request.getParameter("selectTipoCuenta")));
	        cuenta.setObjidTipoCuenta(tipoCuenta);

	        
	        boolean exito = negCuenta.ModificarCuenta(cuenta);
	        String mensaje = exito ? "Cuenta modificada con éxito" : "Error al modificar la cuenta";

	      
	        negocioTipoCuenta negTipoCuenta = new negocioTipoCuentaImpl();
	        ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();

	        request.setAttribute("mensaje", mensaje);
	        request.setAttribute("listaTiposCuenta", listaTiposCuenta);
	        RequestDispatcher rd = request.getRequestDispatcher("EdicionCuenta.jsp");
	        rd.forward(request, response);
	}

}
