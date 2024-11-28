package negocioImpl;



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
	
}
