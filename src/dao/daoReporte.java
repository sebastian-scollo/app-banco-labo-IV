package dao;

import java.util.List;

import entidades.Cliente;

public interface daoReporte {
	 List<Cliente> obtenerClientesPorProvincia(int provinciaID);
}
