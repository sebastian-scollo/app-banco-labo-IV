package negocioImpl;
import java.util.ArrayList;

import dao.daoCuota;
import daoImpl.daoCuotaImpl;
import entidades.Cuota;
import entidades.Prestamo;
import negocio.negocioCuotas;
public class negocioCuotaImpl implements negocioCuotas {
    daoCuota dao = new daoCuotaImpl();
	@Override
	public Double ValorCuotaIndividual(int idPrestamo) {
     return		dao.ValorCuotaIndividual(idPrestamo);
	}

	@Override
	public ArrayList<Prestamo> ListarPrestamos(String cbu) {
		
		return dao.ListarPrestamos(cbu);
	}

	@Override
	public ArrayList<Cuota> getCuotaPendiente(int idPrestamo) {
		return dao.getCuotaPendiente(idPrestamo);
	}

	@Override
	public boolean pagarCuota(int idCuota, double importe) {
	return	dao.pagarCuota(idCuota, importe);
		
	}

	@Override
	public double obtenerSaldoCuentaPorPrestamo(int idPrestamo) {
		return dao.obtenerSaldoCuentaPorPrestamo(idPrestamo);
	}

}
