package negocioImpl;

import java.util.ArrayList;

import entidades.Provincia;
import negocio.negocioProvincia;
import dao.daoCliente;
import dao.daoProvincia;
import daoImpl.daoClienteImpl;
import daoImpl.daoProvinciaImpl;

public class negocioProvinciaImpl implements negocioProvincia {

	private daoProvincia dao = new daoProvinciaImpl();
	private daoProvinciaImpl provinciaDao;
	
	public negocioProvinciaImpl() {
		this.dao = new daoProvinciaImpl();
		this.provinciaDao=new daoProvinciaImpl();
	}
	@Override
	public ArrayList<Provincia> listarProvincias() {
	
		return dao.listarProvincias();
	}
	
	
}
