package negocio;
import java.util.ArrayList;

import entidades.Localidad;
import entidades.Provincia;
public interface negocioLocalidad {
	public ArrayList<Localidad> listarLocalidadesPorProvincia(int IDProvincia);
}
