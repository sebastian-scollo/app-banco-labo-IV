package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.TipoCuenta;
import negocio.negocioCliente;
import negocio.negocioCuenta;
import negocio.negocioTipoCuenta;
import negocioImpl.negocioClienteImpl;
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
		/* negocioTipoCuenta dao = new negocioTipoCuentaImpl();
		 
	        try {
	 
	            String listTipo = dao.obtenerOpcionesDDL();
	            request.setAttribute("listaTiposCuenta", listTipo);

	            RequestDispatcher dispatcher = request.getRequestDispatcher("EditarCuenta.jsp");
	            dispatcher.forward(request, response);
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new ServletException(e);
	        }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    negocioCuenta negCuenta = new negocioCuentaImpl();
	    negocioTipoCuenta negTipoCuenta = new negocioTipoCuentaImpl();
	    negocioCliente negCliente = new negocioClienteImpl();

	
	    int idCuenta = Integer.parseInt(request.getParameter("txtIdCuenta"));
	    int clienteId = Integer.parseInt(request.getParameter("txtClienteId"));
	    String cbuCuenta = request.getParameter("txtCBU");
	    String numeroCuenta = request.getParameter("txtNumCuenta");
	    double saldo = Double.parseDouble(request.getParameter("txtSaldo"));
	    int idTipo = Integer.parseInt(request.getParameter("selectTipoCuenta"));

	  
	    boolean hayError = false;
	    String mensajeError = "";

	   
	    if (negCuenta.CantidadCuenta(clienteId)) {
	        mensajeError = "Este cliente tiene el limite de posesion de cuenta(3).No se le puede asignar mas.";
	        hayError = true;
	    }

	    
	    if (negCuenta.repiteCbu(cbuCuenta)) {
	        mensajeError = "Este CBU ya esta en uso. Ingrese otro.";
	        hayError = true;
	    }

	  
	    if (negCuenta.repiteNroCuenta(numeroCuenta)) {
	        mensajeError = "Numero Cuenta existente, Ingrese otro.";
	        hayError = true;
	    }

	   
	    if (hayError) {
	        ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();
	        ArrayList<Cliente> listaClientes = negCliente.ListarCliente();

	        request.setAttribute("mensajeError", mensajeError);
	        request.setAttribute("listaTiposCuenta", listaTiposCuenta);
	        request.setAttribute("listaClientes", listaClientes);
	        RequestDispatcher rd = request.getRequestDispatcher("EditarCuenta.jsp");
	        rd.forward(request, response);
	        return;
	    }

	    Cuenta cuenta = new Cuenta();
	    cuenta.setIdCuenta(idCuenta);
	    cuenta.setObjCliente(new Cliente(clienteId));
	    cuenta.setObjidTipoCuenta(new TipoCuenta(idTipo));
	    cuenta.setCBU(cbuCuenta);
	    cuenta.setNroCuenta(numeroCuenta);
	    cuenta.setSaldo(saldo);

	    boolean exito = negCuenta.ModificarCuenta(cuenta);

	  
	    String mensaje = exito ? "Cuenta modificada con éxito" : "Error al modificar la cuenta";
	    ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();
	    ArrayList<Cliente> listaClientes = negCliente.ListarCliente();

	  
	    request.setAttribute("mensaje", mensaje);
	    request.setAttribute("listaTiposCuenta", listaTiposCuenta);
	    request.setAttribute("listaClientes", listaClientes);
	    RequestDispatcher rd = request.getRequestDispatcher("EditarCuenta.jsp");
	    rd.forward(request, response);
		
		
	/*	
		negocioCuenta negCuenta = new negocioCuentaImpl();
        negocioTipoCuenta negTipoCuenta= new negocioTipoCuentaImpl();
	    int clienteId = Integer.parseInt(request.getParameter("txtClienteId"));
	    
	  
	    boolean tieneDemasiadasCuentas = negCuenta.CantidadCuenta(clienteId);
	    if (tieneDemasiadasCuentas) {
	      
	        String mensaje = "El cliente ya alcanzó el límite de cuentas permitidas (3). No se puede modificar esta cuenta.";
	        request.setAttribute("mensaje", mensaje);
	        RequestDispatcher rd = request.getRequestDispatcher("EditarCuenta.jsp");
	        rd.forward(request, response);
	        return;
	    }

	   
	    Cuenta cuenta = new Cuenta();
	    cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo")));
	    cuenta.setClienteId(clienteId);
	    cuenta.setTipoCuentaId(Integer.parseInt(request.getParameter("selectTipoCuenta")));
	    cuenta.setIdCuenta(Integer.parseInt(request.getParameter("txtIdCuenta")));

	    boolean exito = negCuenta.ModificarCuenta(cuenta);
	    String mensaje = exito ? "Cuenta modificada con éxito" : "Error al modificar la cuenta";

	   
	    ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();

	    request.setAttribute("mensaje", mensaje);
	    request.setAttribute("listaTiposCuenta", listaTiposCuenta);
	    RequestDispatcher rd = request.getRequestDispatcher("EditarCuenta.jsp");
	    rd.forward(request, response);
		
		
	 */
	}

}