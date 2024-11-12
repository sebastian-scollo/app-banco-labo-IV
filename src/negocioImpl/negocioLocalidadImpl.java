package negocioImpl;

import java.util.ArrayList;

import dao.daoLocalidad;
import dao.daoProvincia;
import daoImpl.daoLocalidadImpl;
import daoImpl.daoProvinciaImpl;
import entidades.Localidad;
import negocio.negocioLocalidad;

public class negocioLocalidadImpl implements negocioLocalidad{
	private daoLocalidad dao = new daoLocalidadImpl();
	private daoLocalidadImpl localidadDao;
	
	public negocioLocalidadImpl() {
		this.dao = new daoLocalidadImpl();
		this.localidadDao=new daoLocalidadImpl();
	}
	@Override
	public ArrayList<Localidad> listarLocalidadesPorProvincia(int IDProvincia) {
		return dao.listarLocalidadPorProvincia(IDProvincia);
	}
	
}
