package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.Cuenta;

public interface negocioReporte {
	public List<Cliente> obtenerClientesPorProvincia(int provinciaID);
	public ArrayList<Cuenta>BusquedaIntervaloFecha(Date fechaInicio,Date fechaFinal);
	public ArrayList<Cuenta> BusquedaIntervaloSaldo(int saldoInicio, int saldoFinal);
}
