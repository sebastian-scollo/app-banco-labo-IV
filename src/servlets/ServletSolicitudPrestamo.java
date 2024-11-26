package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.daoCuentaImpl;
import daoImpl.daoPrestamoImpl;
import entidades.Cuenta;
import entidades.Prestamo;

/**
 * Servlet implementation class ServletSolicitudPrestamo
 */
@WebServlet("/ServletSolicitudPrestamo")
public class ServletSolicitudPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	daoCuentaImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSolicitudPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new daoCuentaImpl();
		HttpSession session = request.getSession();
		int IDCliente = (int) session.getAttribute("idUsuario");
		if(request.getParameter("Param") != null)
		{
			ArrayList<Cuenta> cuentas = dao.ListarXidCl(IDCliente);
			request.setAttribute("cuentas", cuentas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SolicitudPrestamo.jsp");
	        dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		Prestamo prestamoSolicitado = new Prestamo();
		Cuenta cuentaAsociada = new Cuenta();
		daoPrestamoImpl dao = new daoPrestamoImpl();
		HttpSession session = request.getSession();
		int IDCliente = (int) session.getAttribute("idUsuario");
		if (accion != null)
		{
			
			String monto = request.getParameter("monto");
            String cuotas = request.getParameter("cuotas");
            String importeTotal = request.getParameter("importeTotal");
            String importePorCuota = request.getParameter("importePorCuota");
            String cuenta = request.getParameter("cuenta");
            
            cuentaAsociada.setIdCuenta(Integer.parseInt(cuenta));
            cuentaAsociada.setClienteId(IDCliente);
            
            prestamoSolicitado.setCuenta(cuentaAsociada);
            prestamoSolicitado.setPlazo(Integer.parseInt(cuotas));
            prestamoSolicitado.setMontoSolicitado(Double.parseDouble(monto));
            prestamoSolicitado.setImporteApagar(Double.parseDouble(importeTotal));
            
            boolean exito = dao.solicitarPrestamo(prestamoSolicitado);
            if (exito) {
                session.setAttribute("mensajeExito", "El préstamo fue enviado correctamente.");
                response.sendRedirect("MenuCliente.jsp");
            } else {
                session.setAttribute("mensajeError", "Hubo un problema al enviar la solicitud del préstamo. Intente nuevamente.");
                response.sendRedirect("MenuCliente.jsp");
            }
		}
	}

}
