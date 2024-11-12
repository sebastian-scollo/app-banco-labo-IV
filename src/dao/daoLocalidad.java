package dao;

import java.util.ArrayList;

import entidades.Localidad;

public interface daoLocalidad {
	public ArrayList<Localidad>listarLocalidadPorProvincia(int IDProvincia);

}
