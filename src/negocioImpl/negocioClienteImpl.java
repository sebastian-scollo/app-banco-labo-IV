package negocioImpl;

import java.util.ArrayList;

import dao.daoCliente;
import daoImpl.daoClienteImpl;
import entidades.Cliente;
import negocio.negocioCliente;

public class negocioClienteImpl implements negocioCliente {

	private daoCliente dao = new daoClienteImpl();
	private daoClienteImpl clienteDao;
	
	public negocioClienteImpl() {
		this.dao = new daoClienteImpl();
				this.clienteDao=new daoClienteImpl();
	}
	
	@Override
	public ArrayList<Cliente> ListarCliente() {
		return dao.ListarCl();
	}

	@Override
	public ArrayList<Cliente>ListarDni(String paramDni) {
		return dao.ListarDni(paramDni);
	}

	@Override
	public ArrayList<Cliente> ListarNombre(String paramNombre) {
	
		return dao.ListarNombre(paramNombre);
	}

	@Override
	public boolean eliminarCliente(int paraIdcliente) {
		
		return dao.eliminarCliente(paraIdcliente);
	}

	
	
}
