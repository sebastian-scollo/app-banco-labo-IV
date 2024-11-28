package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cuenta;
import entidades.Movimiento;
import entidades.TipoMovimiento;
import negocio.negocioCuenta;
import negocio.negocioMovimiento;
import negocioImpl.negocioCuentaImpl;
import negocioImpl.negocioMovimientoImpl;

/**
 * Servlet implementation class servletMovimientoTransferencia
 */
@WebServlet("/servletMovimientoTransferencia")
public class servletMovimientoTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public servletMovimientoTransferencia() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Validar si existe una cuenta seleccionada en la sesión
        HttpSession session = request.getSession();
        Cuenta cuenta = (Cuenta) session.getAttribute("cuentaElegida");
        
        if (cuenta == null) {
            // Si no hay cuenta seleccionada, redirigir con mensaje de error
            request.setAttribute("error", "Debes seleccionar una cuenta antes de realizar una transferencia.");
            request.getRequestDispatcher("OpcionesCuenta.jsp").forward(request, response);
            return;
        }

        // Si la cuenta está seleccionada, mostrar la página de transferencias
        request.getRequestDispatcher("Transferencias.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 negocioMovimiento negMovimiento = new negocioMovimientoImpl();
		    negocioCuenta negCuenta = new negocioCuentaImpl();
		    String cbuEmisor = request.getParameter("txtCbuEmisor");
		    String cbuReceptor = request.getParameter("txtCbuReceptor");
		    String _monto = request.getParameter("txtMonto");
		    String descripcion = request.getParameter("txtDescripcion");
		    
		    double monto = Double.parseDouble(_monto);
		    
		   
		    Cuenta cuentaEmisor = negCuenta.cuentaXcbu(cbuEmisor);
		    Cuenta cuentaReceptor = negCuenta.cuentaXcbu(cbuReceptor);
		    
		   
		    if (cuentaEmisor == null || cuentaReceptor == null) {
		        request.setAttribute("mensaje", "Error: No se encontraron cuentas con los CBU proporcionados.");
		        request.getRequestDispatcher("Transferencias.jsp").forward(request, response);
		        return;
		    }
		    if (!negCuenta.repiteCbu(cbuEmisor)) {
		        request.setAttribute("mensaje", "El CBU del emisor no existe.");
		        request.getRequestDispatcher("Transferencias.jsp").forward(request, response);
		        return;  
		    }

		    if (!negCuenta.repiteCbu(cbuReceptor)) {
		        request.setAttribute("mensaje", "El CBU del receptor no existe.");
		        request.getRequestDispatcher("Transferencias.jsp").forward(request, response);
		        return;  
		    } 
		  
		    int tipoMovimiento = 4;

		    if (cbuEmisor.equals(cbuReceptor)) {
		        request.setAttribute("mensaje", "ESTIMADO,Los CBU deben ser diferentes.");
		        request.getRequestDispatcher("Transferencias.jsp").forward(request, response);
		        return;  
		    }
		    Movimiento movimientoNaranja = new Movimiento();
		    movimientoNaranja.setCuentaEmisor(cuentaEmisor); 
		    movimientoNaranja.setCuentaReceptor(cuentaReceptor); 
		    movimientoNaranja.setImporte(monto);
		    movimientoNaranja.setDetalle(descripcion);
		    movimientoNaranja.setTipomovimiento(new TipoMovimiento(tipoMovimiento, "Transferencia")); 

		   
		    boolean exito = negMovimiento.AsigarTransaccion(movimientoNaranja);

		    
		    if (exito) {
		        request.setAttribute("mensaje", "¡Transferencia realizada!");
		    } else {
		        request.setAttribute("mensaje", "Error: UPS sucedio algo inesperado F,Mr Conejo en camino!.");
		    }
		    
		  
		    request.getRequestDispatcher("Transferencias.jsp").forward(request, response);
	}

}
