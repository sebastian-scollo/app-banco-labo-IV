package negocioImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.daoReporte;
import daoImpl.daoReporteImpl;
import entidades.Cliente;
import entidades.Cuenta;
import negocio.negocioReporte;

public class negocioReporteImpl implements negocioReporte {
	daoReporte dao = new daoReporteImpl();

	public List<Cliente> obtenerClientesPorProvincia(int provinciaID) {
		 return dao.obtenerClientesPorProvincia(provinciaID);
	}

	@Override
	public ArrayList<Cuenta> BusquedaIntervaloFecha(Date fechaInicio, Date fechaFinal) {
		return dao.BusquedaIntervaloFecha(fechaInicio, fechaFinal);
	}
	
	public ArrayList<Cuenta> BusquedaIntervaloSaldo(int saldoInicio, int saldoFinal) {
		return dao.BusquedaIntervaloSaldo(saldoInicio, saldoFinal);
	}
}
