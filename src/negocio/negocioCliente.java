package negocio;

import java.util.ArrayList;

import entidades.Cliente;

public interface negocioCliente {

	public ArrayList<Cliente>ListarCliente();
	public ArrayList<Cliente>ListarDni(String paramDni);
	public ArrayList<Cliente>ListarNombre(String paramNombre);
	boolean EditarClieente(Cliente cliente);

	public boolean eliminarCliente(int paraIdcliente);

	public boolean RegistrarCliente(Cliente cliente);
    public boolean ExisteIdCliente(int idCliente);
  
}
