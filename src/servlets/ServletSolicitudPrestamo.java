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
import entidades.Cuenta;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
