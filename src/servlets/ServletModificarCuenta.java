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
		 negocioTipoCuenta dao = new negocioTipoCuentaImpl();
		 
	        try {
	 
	            String listTipo = dao.obtenerOpcionesDDL();
	            request.setAttribute("listaTiposCuenta", listTipo);

	            RequestDispatcher dispatcher = request.getRequestDispatcher("EditarCuenta.jsp");
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
		
		negocioCuenta negCuenta = new negocioCuentaImpl();
	        Cuenta cuenta = new Cuenta();
	        cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo")));
	        cuenta.setClienteId(Integer.parseInt(request.getParameter("txtClienteId")));
	        cuenta.setClienteId(Integer.parseInt(request.getParameter("txtIdCuenta")));
	        TipoCuenta tipoCuenta = new TipoCuenta();
	        tipoCuenta.setIdTipoCuenta(Integer.parseInt(request.getParameter("selectTipoCuenta")));
	        cuenta.setObjidTipoCuenta(tipoCuenta);

	        
	        boolean exito = negCuenta.ModificarCuenta(cuenta);
	        String mensaje = exito ? "Cuenta modificada con �xito" : "Error al modificar la cuenta";

	      
	        negocioTipoCuenta negTipoCuenta = new negocioTipoCuentaImpl();
	        ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();

	        request.setAttribute("mensaje", mensaje);
	        request.setAttribute("listaTiposCuenta", listaTiposCuenta);
	        RequestDispatcher rd = request.getRequestDispatcher("EditarCuenta.jsp");
	        rd.forward(request, response);
	}

}
