package dao;
import java.util.ArrayList;

import entidades.Cliente;
public interface daoCliente {
	
    public ArrayList<Cliente>ListarCl();
	public ArrayList<Cliente>ListarDni(String paramDni);
	public ArrayList<Cliente>ListarNombre(String paramNombre);
}
