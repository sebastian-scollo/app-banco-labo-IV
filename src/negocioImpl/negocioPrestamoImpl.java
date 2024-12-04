package negocioImpl;



import java.util.List;

import dao.daoPrestamo;
import daoImpl.daoPrestamoImpl;
import entidades.Prestamo;
import negocio.negocioPrestamo;

public class negocioPrestamoImpl implements negocioPrestamo {
	private daoPrestamo dao = new daoPrestamoImpl();
	
	
	@Override
	public boolean solicitarPrestamo(Prestamo prestamo) {
		return dao.solicitarPrestamo(prestamo);
	}


	@Override
	public List<Prestamo> obtenerPrestamosPorEstado(String estado) {
		return dao.obtenerPorEstado(estado);
	}
	@Override
	public Prestamo obtenerPorId(int IDPrestamo) {
		return dao.obtenerPorId(IDPrestamo);
	}
	@Override
	public boolean actualizarEstado(Prestamo prestamo) {
		return dao.actualizarEstado(prestamo);
	}
	
	
}
