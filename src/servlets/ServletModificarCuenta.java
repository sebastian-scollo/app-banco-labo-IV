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
		
		String idCuentaParam = request.getParameter("idCuenta");
	    if (idCuentaParam != null && !idCuentaParam.isEmpty()) {
	        int idCuenta = Integer.parseInt(idCuentaParam);

	        // Obtener la cuenta desde la base de datos
	        negocioCuenta negCuenta = new negocioCuentaImpl();
	        ArrayList<Cuenta> cuenta = negCuenta.ListarIDCuenta(idCuenta);

	        if (cuenta != null) {
	            request.setAttribute("cuenta", cuenta);
	        } else {
	            request.setAttribute("mensajeError", "Cuenta no encontrada.");
	        }
	    }

	    // Cargar los tipos de cuenta disponibles
	    cargarTiposCuenta(request, response);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("EditarCuenta.jsp");
	    dispatcher.forward(request, response);
		/*if(request.getParameter("Param")!=null) {
		cargarTiposCuenta(request, response);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("EditarCuenta.jsp");
	    dispatcher.forward(request, response);
		}*/
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idCuentaParam = request.getParameter("txtIdCuenta");
	    String saldoParam = request.getParameter("txtSaldo");
	    String clienteIdParam = request.getParameter("txtClienteId");
	    String tipoCuentaParam = request.getParameter("TipoCuenta");

	    if (idCuentaParam != null && !idCuentaParam.isEmpty()) {
	        try {
	            int idCuenta = Integer.parseInt(idCuentaParam);
	            double saldo = Double.parseDouble(saldoParam);
	            int clienteId = Integer.parseInt(clienteIdParam);
	            int tipoCuenta = Integer.parseInt(tipoCuentaParam);
	            if (saldo < 0) {
	              
	                request.setAttribute("mensajeError", "El saldo no puede ser negativo.");
	              
	                RequestDispatcher dispatcher = request.getRequestDispatcher("EditarCuenta.jsp");
	                dispatcher.forward(request, response);
	                return;
	            }
	            Cuenta cuenta = new Cuenta();
	            cuenta.setIdCuenta(idCuenta);
	            cuenta.setSaldo(saldo);
	            Cliente cliente = new Cliente();
	            cliente.setIdCliente(clienteId);
	            cuenta.setObjCliente(cliente);

	            TipoCuenta tipo = new TipoCuenta();
	            tipo.setIdTipoCuenta(tipoCuenta);
	            cuenta.setObjidTipoCuenta(tipo);

	         
	            negocioCuenta negCuenta = new negocioCuentaImpl();
	            boolean exito = negCuenta.ModificarCuenta(cuenta);

	            if (exito==true) {
	                request.setAttribute("mensajeExito", "Edicion completada efectivamente.");
	            } else {
	                request.setAttribute("mensajeError", "Error al editar la cuenta.");
	            }
	        } catch (Exception e) {
	            request.setAttribute("mensajeError", "Error: " + e.getMessage());
	        }
	    } else {
	        request.setAttribute("mensajeError", "Datos inválidos.");
	    }

	    // Volver al JSP
	    cargarTiposCuenta(request, response);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("EditarCuenta.jsp");
	    dispatcher.forward(request, response);
		
	   /* negocioCuenta negCuenta = new negocioCuentaImpl();
	    negocioTipoCuenta negTipoCuenta = new negocioTipoCuentaImpl();
	    negocioCliente negCliente = new negocioClienteImpl();

	    cargarTiposCuenta(request, response);
	    int idCuenta = Integer.parseInt(request.getParameter("txtIdCuenta"));
	    int clienteId = Integer.parseInt(request.getParameter("txtClienteId"));
	    double saldo = Double.parseDouble(request.getParameter("txtSaldo"));
	    int idTipo = Integer.parseInt(request.getParameter("TipoCuenta"));

	  
	    boolean hayError = false;
	    String mensajeError = "";

	   
	    if (negCuenta.CantidadCuenta(clienteId, idCuenta)) {
	        mensajeError = "Este cliente tiene el limite de posesion de cuenta(3).No se le puede asignar mas.";
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
	        System.out.println("error");
	        return;
	    }

	    Cuenta cuenta = new Cuenta();
	    cuenta.setIdCuenta(idCuenta);
	    cuenta.setObjCliente(new Cliente(clienteId));
	    cuenta.setObjidTipoCuenta(new TipoCuenta(idTipo));
	    cuenta.setSaldo(saldo);

	    boolean exito = negCuenta.ModificarCuenta(cuenta);

	  
	    String mensaje = exito ? "Cuenta modificada con éxito" : "Error al modificar la cuenta";
	    ArrayList<TipoCuenta> listaTiposCuenta = negTipoCuenta.obtenerTiposCuentas();
	    ArrayList<Cliente> listaClientes = negCliente.ListarCliente();

	  
	    request.setAttribute("mensaje", mensaje);
	    request.setAttribute("listaTiposCuenta", listaTiposCuenta);
	    request.setAttribute("listaClientes", listaClientes);
	    RequestDispatcher rd = request.getRequestDispatcher("EditarCuenta.jsp");
	    rd.forward(request, response);*/
		
	}
	private void cargarTiposCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    negocioTipoCuenta dao = new negocioTipoCuentaImpl();

	    try {
	        ArrayList<TipoCuenta> listTipo = dao.obtenerTiposCuentas();
	        System.out.println("Tipos de Cuenta encontrados: " + listTipo.size());

	      
	        if (listTipo.isEmpty()) {
	            request.setAttribute("errorMessage", "No se encontraron tipos de cuenta");
	        }

	        request.setAttribute("listTipo", listTipo);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("errorMessage", "Error al cargar tipos de cuenta: " + e.getMessage());
	    }
	}


}