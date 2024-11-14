package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao.daoProvincia;
import entidades.Provincia;
import negocio.negocioProvincia;
import negocioImpl.negocioProvinciaImpl;

/**
 * Servlet implementation class ObtenerProvinciasServlet
 */
@WebServlet("/ObtenerProvinciasServlet")
public class ObtenerProvinciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private negocioProvinciaImpl negocioProvincia;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerProvinciasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		negocioProvincia = new negocioProvinciaImpl();
		response.setContentType("application/json;charset=UTF-8");
        
        ArrayList<Provincia> provincias = negocioProvincia.listarProvincias();
        if (provincias != null && !provincias.isEmpty()) {
            Gson gson = new Gson();
            String jsonProvincias = gson.toJson(provincias);
            System.out.println("JSON generado: " + jsonProvincias);  // Depuración

            try (PrintWriter out = response.getWriter()) {
                out.print(jsonProvincias);
                out.flush();
            }
        } else {
            System.out.println("Error: La lista de provincias está vacía o es nula.");
            response.sendError(HttpServletResponse.SC_NO_CONTENT, "No hay provincias disponibles.");
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
