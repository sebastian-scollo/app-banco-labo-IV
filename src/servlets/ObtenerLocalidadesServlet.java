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

import daoImpl.daoLocalidadImpl;
import entidades.Localidad;
/**
 * Servlet implementation class ObtenerLocalidadesServlet
 */
@WebServlet("/ObtenerLocalidadesServlet")
public class ObtenerLocalidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerLocalidadesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        String idProvincia = request.getParameter("provinciaID");
        PrintWriter out = response.getWriter();

        if (idProvincia != null && !idProvincia.isEmpty()) {
            try {
                int provinciaId = Integer.parseInt(idProvincia);
                daoLocalidadImpl localidadDAO = new daoLocalidadImpl();
                ArrayList<Localidad> localidades = localidadDAO.listarLocalidadPorProvincia(provinciaId);
                Gson gson = new Gson();
                out.print(gson.toJson(localidades));
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print("{\"error\":\"IDProvincia debe ser un número válido\"}");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\":\"IDProvincia es requerido\"}");
        }
        out.flush();
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
