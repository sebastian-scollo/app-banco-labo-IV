package negocio;

import java.util.List;

import entidades.Cliente;

public interface daoNegocio {
	public List<Cliente> obtenerClientesPorProvincia(int provinciaID);
}
