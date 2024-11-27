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

import entidades.Cuenta;
import negocio.negocioOpcionCuenta;
import negocioImpl.negocioOpcionCuentaImpl;


@WebServlet("/servletOpcionCuenta")
public class servletOpcionCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletOpcionCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int usuarioID = (int) session.getAttribute("idUsuario");
	    negocioOpcionCuenta negOpCuenta = new negocioOpcionCuentaImpl();
	    if(request.getParameter("Param")!=null) {
			try {
			ArrayList<Cuenta> listado = negOpCuenta.OpcionCuentas(usuarioID);
			request.setAttribute("listadoCuenta",listado!=null? listado:new ArrayList<>());
			RequestDispatcher rd = request.getRequestDispatcher("OpcionesCuenta.jsp");
			rd.forward(request, response);
			
			
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error F:"+ex.getMessage());
			}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
