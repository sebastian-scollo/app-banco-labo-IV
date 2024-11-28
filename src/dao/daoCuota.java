package dao;
import entidades.Cuota;
import entidades.Prestamo;
import java.util.ArrayList;
public interface daoCuota {
	
   Double ValorCuotaIndividual(int idPrestamo);
   ArrayList<Prestamo> ListarPrestamos(String cbu);	
   ArrayList<Cuota> getCuotaPendiente(int idPrestamo);
   boolean pagarCuota(int idCuota, double importe);
    double obtenerSaldoCuentaPorPrestamo(int idPrestamo);
}
