package negocioImpl;

import java.util.List;

import dao.daoReporte;
import daoImpl.daoReporteImpl;
import entidades.Cliente;
import negocio.negocioReporte;

public class negocioReporteImpl implements negocioReporte {
	daoReporte dao = new daoReporteImpl();

	public List<Cliente> obtenerClientesPorProvincia(int provinciaID) {
		 return dao.obtenerClientesPorProvincia(provinciaID);
	}
}
