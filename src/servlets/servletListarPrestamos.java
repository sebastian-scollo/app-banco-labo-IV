package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.daoPrestamoImpl;
import entidades.Prestamo;

/**
 * Servlet implementation class servletListarPrestamos
 */
@WebServlet("/servletListarPrestamos")
public class servletListarPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletListarPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{
	            daoPrestamoImpl prestamoDAO = new daoPrestamoImpl();
	            
	            List<Prestamo> prestamosEnTramite = prestamoDAO.obtenerPorEstado("En tramite");
	            List<Prestamo> prestamosAprobados = prestamoDAO.obtenerPorEstado("Aprobado");
	            List<Prestamo> prestamosRechazados = prestamoDAO.obtenerPorEstado("Rechazado");
	            request.setAttribute("prestamosEnTramite", prestamosEnTramite);
	            request.setAttribute("prestamosAprobados", prestamosAprobados);
	            request.setAttribute("prestamosRechazados", prestamosRechazados);
	            request.getRequestDispatcher("AdministrarPrestamos.jsp").forward(request, response);
	        } catch (Exception e) {
	            throw new ServletException("Error al cargar los préstamos", e);
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
