package dao;
import java.util.ArrayList;

import entidades.Cliente;
public interface daoCliente {
	
    public ArrayList<Cliente>ListarCl();
	public ArrayList<Cliente>ListarDni(String paramDni);
	public ArrayList<Cliente>ListarNombre(String paramNombre);
<<<<<<< Updated upstream
	public boolean eliminarCliente(int paraIdcliente);
=======
	public boolean verificarDNI(String DNI);
	public boolean verificarCUIL(String CUIL);
	public boolean RegistrarCliente(Cliente cliente);
>>>>>>> Stashed changes
}
