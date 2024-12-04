package negocio;

import java.util.ArrayList;

import entidades.Cuota;
import entidades.Prestamo;

public interface negocioCuotas {
	 
	Double ValorCuotaIndividual(int idPrestamo);
	 ArrayList<Prestamo> ListarPrestamos(String cbu);	
	   ArrayList<Cuota> getCuotaPendiente(int idPrestamo);   
	   boolean pagarCuota(int idCuota, double importe);
	   double obtenerSaldoCuentaPorPrestamo(int idPrestamo);


}

