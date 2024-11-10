package negocio;

import java.util.ArrayList;

import entidades.Cliente;

public interface negocioCliente {

	public ArrayList<Cliente>ListarCliente();
	public ArrayList<Cliente>ListarDni(String paramDni);
	public ArrayList<Cliente>ListarNombre(String paramNombre);
	
}
