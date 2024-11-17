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
import negocio.negocioCliente;
import negocio.negocioCuenta;
import negocioImpl.negocioClienteImpl;
import negocioImpl.negocioCuentaImpl;

/**
 * Servlet implementation class servletCuenta
 */
@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public servletCuenta() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		negocioCuenta negCuenta = new negocioCuentaImpl();
		if(request.getParameter("Param")!=null) {
			try {
			ArrayList<Cuenta> listado =  negCuenta.ListarCuenta();
			request.setAttribute("listadoCuenta",listado!=null? listado:new ArrayList<>());
			RequestDispatcher rd = request.getRequestDispatcher("AdministrarCuenta.jsp");
			rd.forward(request, response);
			
			
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error F:"+ex.getMessage());
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//btnMostrarTodo
		negocioCuenta negCuenta = new negocioCuentaImpl();
		if(request.getParameter("btnMostrarTodo")!=null) {
			try {
			ArrayList<Cuenta> listado =  negCuenta.ListarCuenta();
			request.setAttribute("listadoCuenta",listado!=null? listado:new ArrayList<>());
			RequestDispatcher rd = request.getRequestDispatcher("AdministrarCuenta.jsp");
			rd.forward(request, response);
			
			
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error F:"+ex.getMessage());
			}
		}
		
		if(request.getParameter("btnBuscarTipoCuenta")!=null) {
			
			String enter_tipoCuenta = request.getParameter("txtBuscarTipoCuenta");
			int paramTipoCuenta=Integer.parseInt(enter_tipoCuenta);
			ArrayList<Cuenta> lista = negCuenta.ListarXtipoCuenta(paramTipoCuenta);
			request.setAttribute("listadoCuenta",lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("AdministrarCuenta.jsp");
			rd.forward(request,response);
		}
		if(request.getParameter("btnBuscarID")!=null) {
	    	String enter_idCuenta= request.getParameter("txtBuscarIdCliente");
	    	int paramIdCuenta=Integer.parseInt(enter_idCuenta);
			ArrayList<Cuenta> lista = negCuenta.ListarXidCl(paramIdCuenta);
			request.setAttribute("listadoCuenta",lista);
			RequestDispatcher rd = request.getRequestDispatcher("AdministrarCuenta.jsp");
			rd.forward(request,response);
	    }
		
		doGet(request, response);
	}

}
