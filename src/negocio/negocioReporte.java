package negocio;

import java.util.List;

import entidades.Cliente;

public interface negocioReporte {
	public List<Cliente> obtenerClientesPorProvincia(int provinciaID);
}
