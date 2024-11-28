package servlets;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import negocio.negocioCliente;
import negocio.negocioCuenta;
import negocio.negocioMovimiento;
import negocioImpl.negocioClienteImpl;
import negocioImpl.negocioCuentaImpl;
import negocioImpl.negocioMovimientoImpl;
import entidades.TipoCuenta;
import entidades.TipoMovimiento;
import negocio.negocioTipoCuenta;
import negocioImpl.negocioTipoCuentaImpl;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Excepciones.CBUrepetido;
import Excepciones.LimiteCuentaPorCliente;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {
		    try {
		        if (request.getParameter("btnAceptar") != null) {
		            Cuenta c = new Cuenta();
		            int idTipo = Integer.parseInt(request.getParameter("TipoCuenta"));
		            int idCliente = Integer.parseInt(request.getParameter("IdCliente"));
		            String numeroCuenta = request.getParameter("NumCuenta");
		            String cbuCuenta = request.getParameter("CBU");
		            
		            negocioCuenta nc = new negocioCuentaImpl();
		            negocioCliente clienteNeg = new negocioClienteImpl();
		            negocioTipoCuenta negTipoCuenta = new negocioTipoCuentaImpl();
		            negocioCliente negCliente = new negocioClienteImpl();
		            
		        
		            validarCantidadCuentas(nc, idCliente);
		            validarCBU(nc, cbuCuenta);
		            
		        
		            if (!clienteNeg.ExisteIdCliente(idCliente)) {
		                request.setAttribute("mensajeErrorCliente", "El ID de cliente ingresado no existe.");
		                throw new Exception("Cliente no existe");
		            }
		            
		            if (nc.repiteNroCuenta(numeroCuenta)) {
		                request.setAttribute("mensajeErrorNroCuenta", "El número de cuenta ya existe. Ingrese otro.");
		                throw new Exception("Número de cuenta duplicado");
		            }
		         
		            c.setObjidTipoCuenta(new TipoCuenta(idTipo));
		            c.setObjCliente(new Cliente(idCliente));
		            c.setCBU(cbuCuenta);
		            c.setNroCuenta(numeroCuenta);
		            c.setSaldo(Double.parseDouble(request.getParameter("Saldo")));
		            
		            boolean exitoAgregar = nc.AgregarCuenta(c);
		            if(exitoAgregar) {
		            	negocioMovimiento negMov = new negocioMovimientoImpl();
		            	Movimiento nuevoMovimiento = new Movimiento();
		            	nuevoMovimiento.setDetalle("Alta Cuenta");
		            	nuevoMovimiento.setImporte(Double.parseDouble(request.getParameter("Saldo")));
		            	nuevoMovimiento.setCbuEmisor("AUSENTE");
		            	nuevoMovimiento.setCbuReceptor("AUSENTE"); 

		            
		            	TipoMovimiento tipoMovimiento = new TipoMovimiento(1, "Alta de Cuenta"); 
		            	nuevoMovimiento.setTipomovimiento(tipoMovimiento);
		                negMov.registrarMovimiento(nuevoMovimiento);
		            }
		            request.setAttribute("mensajeExito", "La cuenta se agregó exitosamente.");
		        }
		    } catch (LimiteCuentaPorCliente e) {
		        request.setAttribute("mensajeErrorCuentas", e.getMessage());
		    } catch (CBUrepetido e) {
		        request.setAttribute("mensajeErrorCBU", e.getMessage());
		    } catch (Exception e) {
		       
		        request.setAttribute("mensajeError", e.getMessage());
		    } finally {
		        request.getRequestDispatcher("AgregarCuenta.jsp").forward(request, response);
		    }
		}

	
		private void validarCantidadCuentas(negocioCuenta nc, int idCliente) throws LimiteCuentaPorCliente {
		    if (nc.CantidadCuenta(idCliente, nc.NuevaId())) {
		        throw new LimiteCuentaPorCliente("El cliente ya tiene la cantidad máxima permitida de cuentas.");
		    }
		}

		private void validarCBU(negocioCuenta nc, String cbuCuenta) throws CBUrepetido {
		    if (nc.repiteCbu(cbuCuenta)) {
		        throw new CBUrepetido("El CBU ingresado ya está en uso. Ingrese otro.");
		    }
		}

}