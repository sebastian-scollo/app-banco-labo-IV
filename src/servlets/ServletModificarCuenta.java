package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cuenta;
import negocio.negocioCuenta;
import negocioImpl.negocioCuentaImpl;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getParameter("btnAceptar") != null ) {
            Cuenta c = new Cuenta();

        	c.setTipoCuentaId( Integer.parseInt( request.getParameter("CodigoTipoCuenta") ) );
           	c.setClienteId( Integer.parseInt( request.getParameter("IdCliente") ) );
            c.setCBU( request.getParameter("CBU") );
            c.setNroCuenta( request.getParameter("NumCuenta") );
            c.setSaldo( Double.parseDouble( request.getParameter( "Saldo" ) );
            
            negocioCuenta nc = new negocioCuentaImpl();
          	nc.ModificarCuenta(c);
    	}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AgregarCuenta.jsp");  // La página donde quieres mostrar los datos
        dispatcher.forward(request, response);
	}

}
