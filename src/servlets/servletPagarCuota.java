package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cuota;
import entidades.Movimiento;
import entidades.TipoMovimiento;
import negocio.negocioCuenta;
import negocio.negocioCuotas;
import negocio.negocioMovimiento;
import negocioImpl.negocioCuentaImpl;
import negocioImpl.negocioCuotaImpl;
import negocioImpl.negocioMovimientoImpl;

/**
 * Servlet implementation class servletPagarCuota
 */
@WebServlet("/servletPagarCuota")
public class servletPagarCuota extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletPagarCuota() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
		    int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
		    double importeTotal = Double.parseDouble(request.getParameter("importeTotal"));

		    negocioCuotas negCuota = new negocioCuotaImpl();
		    ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
		    Double valorCuotaIndividual = negCuota.ValorCuotaIndividual(idPrestamo);

		    request.setAttribute("idPrestamo", idPrestamo);
		    request.setAttribute("importeTotal", importeTotal);
		    request.setAttribute("cuotasPendientes", cuotasPendientes);
		    request.setAttribute("valorCuotaIndividual", valorCuotaIndividual);

		    request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
		} else if ("realizarPago".equals(action)) {
		    try {
		        int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
		        int idCuota = Integer.parseInt(request.getParameter("idCuota"));
		        double importeTotal = Double.parseDouble(request.getParameter("importeTotal"));
		        double importePagar = Double.parseDouble(request.getParameter("importePagar"));

		        negocioCuotas negCuota = new negocioCuotaImpl();
		        negocioCuenta negCuenta = new negocioCuentaImpl();
		        negocioMovimiento negMov = new negocioMovimientoImpl();

		        Double valorCuotaIndividual = negCuota.ValorCuotaIndividual(idPrestamo);
		        if (importePagar != valorCuotaIndividual) {
		            request.setAttribute("mensaje", "El importe a pagar debe ser exactamente: $" + valorCuotaIndividual);
		            recargarDatos(request, response, idPrestamo, importeTotal, negCuota, valorCuotaIndividual);
		            return;
		        }

		        double saldoDisponible = negCuota.obtenerSaldoCuentaPorPrestamo(idPrestamo);
		        if (saldoDisponible < importePagar) {
		            request.setAttribute("mensaje", "Saldo insuficiente. Su saldo actual es: $" + saldoDisponible);
		            recargarDatos(request, response, idPrestamo, importeTotal, negCuota, valorCuotaIndividual);
		            return;
		        }

		        boolean pagoExitoso = negCuota.pagarCuota(idCuota, importePagar);

		        if (pagoExitoso) {
		            boolean saldoActualizado = negCuenta.actualizarSaldoCuenta(idPrestamo, importePagar);

		            if (saldoActualizado) {
		              
		            	Movimiento nuevoMovimiento = new Movimiento();
		            	nuevoMovimiento.setDetalle("Pago de prestamo");
		            	nuevoMovimiento.setImporte(importePagar);
		            	nuevoMovimiento.setCbuEmisor("AUSENTE");
		            	nuevoMovimiento.setCbuReceptor("AUSENTE"); 

		            
		            	TipoMovimiento tipoMovimiento = new TipoMovimiento(3, "Pago de prestamo"); 
		            	nuevoMovimiento.setTipomovimiento(tipoMovimiento);
		                boolean movimientoRegistrado = negMov.registrarMovimiento(nuevoMovimiento);

		                if (movimientoRegistrado) {
		                    ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
		                    request.setAttribute("mensaje", "Pago realizado con éxito y movimiento registrado");
		                    request.setAttribute("cuotasPendientes", cuotasPendientes);
		                } else {
		                    request.setAttribute("mensaje", "Pago realizado, pero no se pudo registrar el movimiento");
		                }
		            } else {
		                request.setAttribute("mensaje", "Error al actualizar el saldo de la cuenta");
		            }
		        } else {
		            request.setAttribute("mensaje", "Error al procesar el pago");
		        }

		        recargarDatos(request, response, idPrestamo, importeTotal, negCuota, valorCuotaIndividual);

		    } catch (NumberFormatException e) {
		        request.setAttribute("mensaje", "Error en los datos ingresados");
		        request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
		    } catch (Exception e) {
		        request.setAttribute("mensaje", "Ocurre un error inesperado: " + e.getMessage());
		        request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
		    }
		}

		
		/* String action = request.getParameter("action");

		    if (action == null) {
		    
		        int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
		        double importeTotal = Double.parseDouble(request.getParameter("importeTotal"));

		        negocioCuotas negCuota = new negocioCuotaImpl();
		        ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
		        Double valorCuotaIndividual = negCuota.ValorCuotaIndividual(idPrestamo);

		        request.setAttribute("idPrestamo", idPrestamo);
		        request.setAttribute("importeTotal", importeTotal);
		        request.setAttribute("cuotasPendientes", cuotasPendientes);
		        request.setAttribute("valorCuotaIndividual", valorCuotaIndividual);

		        request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
		    } else if ("realizarPago".equals(action)) {
		        try {
		            int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
		            int idCuota = Integer.parseInt(request.getParameter("idCuota"));
		            double importeTotal = Double.parseDouble(request.getParameter("importeTotal"));
		            double importePagar = Double.parseDouble(request.getParameter("importePagar"));

		            negocioCuotas negCuota = new negocioCuotaImpl();
                    negocioCuenta negCuenta = new negocioCuentaImpl();
		         
		            Double valorCuotaIndividual = negCuota.ValorCuotaIndividual(idPrestamo);
		            if (importePagar != valorCuotaIndividual) {
		                request.setAttribute("mensaje", "El importe a pagar debe ser exactamente: $" + valorCuotaIndividual);
		                recargarDatos(request, response, idPrestamo, importeTotal, negCuota, valorCuotaIndividual);
		                return;
		            }

		            double saldoDisponible = negCuota.obtenerSaldoCuentaPorPrestamo(idPrestamo);
		            if (saldoDisponible < importePagar) {
		                request.setAttribute("mensaje", "Saldo insuficiente. Su saldo actual es: $" + saldoDisponible);
		                recargarDatos(request, response, idPrestamo, importeTotal, negCuota, valorCuotaIndividual);
		                return;
		            }

		          
		            boolean pagoExitoso = negCuota.pagarCuota(idCuota, importePagar);

		            if (pagoExitoso) {
		              
		                boolean saldoActualizado = negCuenta.actualizarSaldoCuenta(idPrestamo, importePagar);

		                if (saldoActualizado) {
		                    ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
		                    request.setAttribute("mensaje", "Pago realizado con éxito");
		                    request.setAttribute("cuotasPendientes", cuotasPendientes);
		                } else {
		                    request.setAttribute("mensaje", "Error al actualizar el saldo de la cuenta");
		                }
		            } else {
		                request.setAttribute("mensaje", "Error al procesar el pago");
		            }

		            recargarDatos(request, response, idPrestamo, importeTotal, negCuota, valorCuotaIndividual);

		        } catch (NumberFormatException e) {
		            request.setAttribute("mensaje", "Error en los datos ingresados");
		            request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
		        } catch (Exception e) {
		            request.setAttribute("mensaje", "Ocurrió un error inesperado: " + e.getMessage());
		            request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
		        }
		    }*/
     
		
		/*   String action = request.getParameter("action");

        if (action == null) {
            // Primera carga desde verPrestamos.jsp
            int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
            double importeTotal = Double.parseDouble(request.getParameter("importeTotal"));

            negocioCuotas negCuota = new negocioCuotaImpl();
            ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
            Double valorCuotaIndividual = negCuota.ValorCuotaIndividual(idPrestamo);

            request.setAttribute("idPrestamo", idPrestamo);
            request.setAttribute("importeTotal", importeTotal);
            request.setAttribute("cuotasPendientes", cuotasPendientes);
            request.setAttribute("valorCuotaIndividual", valorCuotaIndividual);

            request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
        } else if ("realizarPago".equals(action)) {
            // Procesar el pago
            try {
                int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
                int idCuota = Integer.parseInt(request.getParameter("idCuota"));
                double importeTotal = Double.parseDouble(request.getParameter("importeTotal"));
                double importePagar = Double.parseDouble(request.getParameter("importePagar"));

                negocioCuotas negCuota = new negocioCuotaImpl();
                
                // Validar que el importe a pagar sea correcto
                Double valorCuotaIndividual = negCuota.ValorCuotaIndividual(idPrestamo);
                
                if (importePagar != valorCuotaIndividual) {
                    // Manejo de error si el importe no coincide
                    request.setAttribute("mensaje", "El importe a pagar debe ser exactamente: $" + valorCuotaIndividual);
                    
                    // Recargar los datos para mostrar nuevamente
                    ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
                    
                    request.setAttribute("idPrestamo", idPrestamo);
                    request.setAttribute("importeTotal", importeTotal);
                    request.setAttribute("cuotasPendientes", cuotasPendientes);
                    request.setAttribute("valorCuotaIndividual", valorCuotaIndividual);
                    
                    request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
                    return;
                }

                // Realizar el pago
                boolean pagoExitoso = negCuota.pagarCuota(idCuota, importePagar);

                if (pagoExitoso) {
                    // Obtener cuotas pendientes actualizadas
                    ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);
                    
                    request.setAttribute("mensaje", "Pago realizado con éxito");
                    request.setAttribute("idPrestamo", idPrestamo);
                    request.setAttribute("importeTotal", importeTotal);
                    request.setAttribute("cuotasPendientes", cuotasPendientes);
                    request.setAttribute("valorCuotaIndividual", valorCuotaIndividual);
                } else {
                    request.setAttribute("mensaje", "Error al procesar el pago");
                }

                request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);

            } catch (NumberFormatException e) {
                request.setAttribute("mensaje", "Error en los datos ingresados");
                request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("mensaje", "Ocurrió un error inesperado: " + e.getMessage());
                request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
            }
        }*/
		
	
	}
	private void recargarDatos(HttpServletRequest request, HttpServletResponse response, int idPrestamo, double importeTotal, negocioCuotas negCuota, Double valorCuotaIndividual) throws ServletException, IOException {
	    ArrayList<Cuota> cuotasPendientes = negCuota.getCuotaPendiente(idPrestamo);

	    request.setAttribute("idPrestamo", idPrestamo);
	    request.setAttribute("importeTotal", importeTotal);
	    request.setAttribute("cuotasPendientes", cuotasPendientes);
	    request.setAttribute("valorCuotaIndividual", valorCuotaIndividual);

	    request.getRequestDispatcher("PagarCuotas.jsp").forward(request, response);
	}
}
