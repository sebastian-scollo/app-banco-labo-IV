package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Prestamo;
import negocioImpl.negocioMovimientoImpl;
import negocioImpl.negocioPrestamoImpl;

/**
 * Servlet implementation class ServletProcesarPrestamo
 */
@WebServlet("/ServletProcesarPrestamo")
public class ServletProcesarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProcesarPrestamo() {
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
		String accion = request.getParameter("btnAprobar") != null ? "aprobar" : "rechazar";
		    String idPrestamo = request.getParameter("idPrestamo");
		    boolean confirmacion;
		    String mensaje;

		    try {
		        if (idPrestamo == null || idPrestamo.isEmpty()) {
		            throw new IllegalArgumentException("El ID del préstamo es requerido.");
		        }
		        int prestamoId = Integer.parseInt(idPrestamo);

		        
		        negocioPrestamoImpl negocioPrestamo = new negocioPrestamoImpl();
		        negocioMovimientoImpl negocioMovimiento = new negocioMovimientoImpl();

		        Prestamo prestamo = negocioPrestamo.obtenerPorId(prestamoId);

		        if (prestamo == null || prestamo.getIdPrestamo() == 0) {
		            throw new IllegalArgumentException("El préstamo no existe.");
		        }

		        if ("aprobar".equals(accion)) {
		            prestamo.setEstado("Aprobado");
	
		            boolean altaExitosa = negocioMovimiento.altaPrestamo(prestamo);
		            if (!altaExitosa) {
		                throw new RuntimeException("Error al registrar el préstamo en movimientos.");
		            }
		        } else if ("rechazar".equals(accion)) {
		            prestamo.setEstado("Rechazado");
		        }

		        confirmacion = negocioPrestamo.actualizarEstado(prestamo);

		        if (confirmacion) {
		            mensaje = "El préstamo fue " + prestamo.getEstado().toLowerCase() + " exitosamente.";
		        } else {
		            mensaje = "Ocurrió un error al intentar procesar el préstamo.";
		        }

		        List<Prestamo> prestamosEnTramite = negocioPrestamo.obtenerPrestamosPorEstado("En Tramite");
		        request.setAttribute("prestamosEnTramite", prestamosEnTramite);

		        request.setAttribute("mensaje", mensaje);

		    } catch (Exception e) {

		        request.setAttribute("error", "Ocurrió un error: " + e.getMessage());
		    }

		    request.getRequestDispatcher("AdministrarPrestamos.jsp").forward(request, response);
		/* String accion = request.getParameter("btnAprobar") != null ? "aprobar" : "rechazar";
		    String idPrestamo = request.getParameter("idPrestamo");
		    boolean confirmacion;
		    String mensaje;

		    try {
		        if (idPrestamo == null || idPrestamo.isEmpty()) {
		            throw new IllegalArgumentException("El ID del préstamo es requerido.");
		        }
		        int prestamoId = Integer.parseInt(idPrestamo);
		     
		        negocioPrestamoImpl negocioPrestamo = new negocioPrestamoImpl();
		        negocioMovimientoImpl negocioMovimiento = new negocioMovimientoImpl();
		        Prestamo prestamo = negocioPrestamo.obtenerPorId(prestamoId);

		        if (prestamo == null || prestamo.getIdPrestamo() == 0) {
		            throw new IllegalArgumentException("El préstamo no existe.");
		        }
		        if ("aprobar".equals(accion)) {
		            prestamo.setEstado("Aprobado");
		        } else if ("rechazar".equals(accion)) {
		            prestamo.setEstado("Rechazado");
		        }


		        confirmacion = negocioPrestamo.actualizarEstado(prestamo);
		        if (confirmacion) {
		            mensaje = "El préstamo fue " + prestamo.getEstado().toLowerCase() + " exitosamente.";
		        } else {
		            mensaje = "Ocurrió un error al intentar procesar el préstamo.";
		        }

		       
		        request.setAttribute("mensaje", mensaje);

		    } catch (Exception e) {
		        
		        request.setAttribute("error", "Ocurrió un error: " + e.getMessage());
		    }

		    request.getRequestDispatcher("AdministrarPrestamos.jsp").forward(request, response);*/
		
		/*String accion = request.getParameter("btnAprobar") != null ? "aprobar" : "rechazar";
        String idPrestamo = request.getParameter("idPrestamo");
        boolean confirmacion;
        try {
            if (idPrestamo == null || idPrestamo.isEmpty()) {
                throw new IllegalArgumentException("El ID del préstamo es requerido.");
            }
            int prestamoId = Integer.parseInt(idPrestamo);
            // Lógica de procesamiento del préstamo
            negocioPrestamoImpl negocioPrestamo = new negocioPrestamoImpl();
            negocioMovimientoImpl negocioMovimiento = new negocioMovimientoImpl();
            Prestamo prestamo = negocioPrestamo.obtenerPorId(prestamoId);
            
            if (prestamo == null || prestamo.getIdPrestamo() == 0) {
                throw new IllegalArgumentException("El préstamo no existe.");
            }
            if ("aprobar".equals(accion)) {
                prestamo.setEstado("Aprobado");
            } else if ("rechazar".equals(accion)) {
                prestamo.setEstado("Rechazado");
            }
            // Actualiza el préstamo en la base de datos
            confirmacion = negocioPrestamo.actualizarEstado(prestamo);
            if (confirmacion && "Aprobado".equals(prestamo.getEstado()))
            {
            	if (negocioMovimiento.altaPrestamo(prestamo)){
            		request.setAttribute("mensaje", "El préstamo fue procesado exitosamente.");
            	}else
            	{
            		request.setAttribute("mensaje", "Error en el alta del prestamo.");
            	}
            	
            }
            // Redirige o muestra un mensaje
            response.sendRedirect("MenuAdmin.jsp");
            //request.getRequestDispatcher("MenuAdmin.jsp").forward(request, response);
            //request.setAttribute("mensaje", "El préstamo fue procesado exitosamente.");
        } catch (Exception e) {
            // Manejo de errores
            request.setAttribute("error", "Ocurrió un error al procesar el préstamo: " + e.getMessage());
        }*/
	}

}
